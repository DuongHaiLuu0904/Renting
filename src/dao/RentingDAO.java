package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.RentedCar;
import model.Renting;


public class RentingDAO extends DAO {

    public RentingDAO() {
        super();
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public boolean addRenting(Renting renting) {
        String sqlAddRenting = "INSERT INTO Renting(promotion, totalAmount, deposit, ClientID, RentalAgnetID) VALUES (?, ?, ?, ?, ?)";
        String sqlAddRentedCar = "INSERT INTO RentedCar(carPickupDate, carReturnDate, Amount, CarID, RentingID) VALUES (?, ?, ?, ?, ?)";
        String sqlCheckRentedCar = "SELECT ID FROM RentedCar WHERE CarID = ? AND carReturnDate > ? AND carPickupDate < ?";

        Connection conn = null;
        PreparedStatement psRenting = null;
        PreparedStatement psRentedCar = null;
        PreparedStatement psCheckRented = null;
        ResultSet rsCheck = null;

        try {
            conn = new DAO().getConnection();
            conn.setAutoCommit(false); 

            // 1. Thêm thông tin thuê xe vào bảng Renting
            psRenting = conn.prepareStatement(sqlAddRenting, Statement.RETURN_GENERATED_KEYS);
            psRenting.setString(1, renting.getPromotion());
            psRenting.setFloat(2, renting.getTotalAmount());
            psRenting.setFloat(3, renting.getDeposit());
            psRenting.setInt(4, renting.getClientID());
            psRenting.setInt(5, renting.getRentalAgentID());

            int affectedRows = psRenting.executeUpdate();
            if (affectedRows == 0) {
                conn.rollback();
                return false;
            }

            // 2. Lấy ID Renting vừa thêm
            ResultSet generatedKeys = psRenting.getGeneratedKeys();
            int rentingID;
            if (generatedKeys.next()) {
                rentingID = generatedKeys.getInt(1);
            } else {
                conn.rollback();
                return false;
            }

            // 3. Thêm từng xe đã thuê vào bảng RentedCar
            for (RentedCar rentedCar : renting.getRentedCars()) {
                // Kiểm tra xem xe đã được thuê trong khoảng thời gian đó chưa
                psCheckRented = conn.prepareStatement(sqlCheckRentedCar);
                psCheckRented.setInt(1, rentedCar.getCarID());
                psCheckRented.setDate(2, rentedCar.getCarPickupDate());
                psCheckRented.setDate(3, rentedCar.getCarReturnDate());
                rsCheck = psCheckRented.executeQuery();
                if (rsCheck.next()) {
                    conn.rollback();
                    return false; 
                }

                // Nếu không bị trùng lịch thì thêm vào
                psRentedCar = conn.prepareStatement(sqlAddRentedCar);
                psRentedCar.setDate(1, rentedCar.getCarPickupDate());
                psRentedCar.setDate(2, rentedCar.getCarReturnDate());
                psRentedCar.setFloat(3, rentedCar.getAmount());
                psRentedCar.setInt(4, rentedCar.getCarID());
                psRentedCar.setInt(5, rentingID);

                psRentedCar.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback(); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            try {
                if (rsCheck != null) rsCheck.close();
                if (psCheckRented != null) psCheckRented.close();
                if (psRentedCar != null) psRentedCar.close();
                if (psRenting != null) psRenting.close();
                if (conn != null) conn.setAutoCommit(true);
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
