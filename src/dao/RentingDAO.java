package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; // Assuming Renting object might contain a list
import model.RentedCar;
import model.Renting;
// Assuming Renting object contains a list of RentedCar objects,
// and RentedCar object contains a Car object or just the car ID.
// Also assuming Renting object contains Client and RentalAgent objects or their IDs.

public class RentingDAO extends DAO {

    public RentingDAO() {
        super();
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public boolean addRenting(Renting renting) {
        // SQL to insert into the Renting table
        String sqlAddRenting = "INSERT INTO Renting(promotion, totalAmount, collateral, saleoff, clientID, rentalAgnetID) VALUES(?,?,?,?,?,?)";
        // SQL to insert into the RentedCar table
        String sqlAddRentedCar = "INSERT INTO RentedCar(carPickupDate, carReturnDate, Amount, CarlD, RentingID) VALUES(?,?,?,?,?)";
        // SQL to check if a car is already rented during a specific period
        String sqlCheckRentedCar = "SELECT ID FROM RentedCar WHERE CarlD = ? AND carReturnDate > ? AND carPickupDate < ?";

        boolean result = true;
        Connection connection = null; // Declare connection outside try-with-resources for rollback/commit

        try {
            connection = DAO.con; // Get the connection
            connection.setAutoCommit(false); // Start transaction

            // 1. Insert into Renting table
            try (PreparedStatement psRenting = connection.prepareStatement(sqlAddRenting, Statement.RETURN_GENERATED_KEYS)) {
                psRenting.setString(1, renting.getPromotion());
                psRenting.setFloat(2, renting.getTotalAmount());
                psRenting.setFloat(3, renting.getCollateral());
                psRenting.setInt(4, renting.getSaleoff());
                psRenting.setInt(5, renting.getClient().getId()); // Get Client ID
                psRenting.setInt(6, renting.getRentalAgent().getId()); // Get RentalAgent ID
                int affectedRows = psRenting.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating renting failed, no rows affected.");
                }

                // Get generated ID for Renting
                try (ResultSet generatedKeys = psRenting.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        renting.setId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating renting failed, no ID obtained.");
                    }
                }
            }

            // Assuming Renting object has a method getRentedCars() that returns a list of RentedCar
            ArrayList<RentedCar> rentedCars = renting.getRentedCars();

            if (rentedCars != null) {
                // 2. Insert Rented Cars and check availability
                for (RentedCar rentedCar : rentedCars) {
                    // Check if the car is available during the period
                    try (PreparedStatement psCheck = connection.prepareStatement(sqlCheckRentedCar)) {
                        psCheck.setInt(1, rentedCar.getCarlD()); // Assuming RentedCar has CarlD
                        psCheck.setDate(2, rentedCar.getCarPickupDate()); // Using java.sql.Date
                        psCheck.setDate(3, rentedCar.getCarReturnDate()); // Using java.sql.Date

                        try (ResultSet rsCheck = psCheck.executeQuery()) {
                            if (rsCheck.next()) {
                                // Car is unavailable
                                result = false;
                                System.err.println("Xe ID " + rentedCar.getCarlD() + " không khả dụng trong khoảng thời gian này.");
                                connection.rollback(); // Rollback the transaction
                                return result; // Exit the method
                            }
                        }
                    }

                    // Insert RentedCar
                    try (PreparedStatement psRentedCar = connection.prepareStatement(sqlAddRentedCar, Statement.RETURN_GENERATED_KEYS)) {
                        psRentedCar.setDate(1, rentedCar.getCarPickupDate()); // Using java.sql.Date
                        psRentedCar.setDate(2, rentedCar.getCarReturnDate()); // Using java.sql.Date
                        psRentedCar.setFloat(3, rentedCar.getAmount()); // Assuming Amount in RentedCar
                        psRentedCar.setInt(4, rentedCar.getCarlD()); // Assuming CarlD in RentedCar
                        psRentedCar.setInt(5, renting.getId()); // Link RentedCar to the new Renting ID

                        int affectedRows = psRentedCar.executeUpdate();

                        if (affectedRows == 0) {
                            throw new SQLException("Creating rented car failed, no rows affected.");
                        }

                        // Get generated ID for RentedCar (if needed)
                        try (ResultSet generatedKeys = psRentedCar.getGeneratedKeys()) {
                            if (generatedKeys.next()) {
                                rentedCar.setId(generatedKeys.getInt(1));
                            } else {
                                // Not strictly necessary to fail if RentedCar ID isn't obtained,
                                // but good practice if you rely on it later.
                                System.err.println("Warning: Could not retrieve generated ID for a rented car.");
                            }
                        }
                    }
                }
            }

            connection.commit(); // Commit the transaction if all inserts and checks were successful

        } catch (SQLException e) {
            result = false;
            System.err.println("Lỗi SQL khi thêm hợp đồng thuê:");
            e.printStackTrace();
            if (connection != null) {
                try {
                    System.err.println("Transaction is being rolled back.");
                    connection.rollback(); // Rollback on SQL error
                } catch (SQLException ex) {
                    System.err.println("Lỗi khi rollback transaction:");
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            result = false;
            System.err.println("Lỗi không mong muốn khi thêm hợp đồng thuê:");
            e.printStackTrace();
            if (connection != null) {
                try {
                    System.err.println("Transaction is being rolled back due to unexpected error.");
                    connection.rollback(); // Rollback on other errors
                } catch (SQLException ex) {
                    System.err.println("Lỗi khi rollback transaction:");
                    ex.printStackTrace();
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Restore auto-commit mode
                } catch (SQLException ex) {
                    System.err.println("Lỗi khi khôi phục auto-commit:");
                    ex.printStackTrace();
                }
            }
        }
        return result;
    }
}
