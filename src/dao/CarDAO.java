package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Car;

public class CarDAO extends DAO {

    public CarDAO() {
        super();
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public ArrayList<Car> searchCar(Date pickupDate, Date returnDate) {
        ArrayList<Car> result = new ArrayList<>();
        String sql = "SELECT * FROM Car WHERE ID NOT IN " + "(SELECT CarlD FROM RentedCar WHERE carReturnDate > ? AND carPickupDate < ?)";

        try (Connection connection = DAO.con; PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDate(1, returnDate);
            ps.setDate(2, pickupDate);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Car car = new Car();
                    car.setId(rs.getInt("ID"));
                    car.setName(rs.getString("name"));
                    car.setType(rs.getString("type"));
                    car.setPrice(rs.getFloat("price"));
                    car.setCarLine(rs.getString("Car_line"));
                    car.setFuelCondition(rs.getString("Fuel_Condition"));
                    car.setTypeCondition(rs.getString("Type_Codition"));
                    car.setInteriorCondition(rs.getString("Interior_codition"));
                    car.setDamages(rs.getString("Damages"));
                    car.setCarRentalShopID(rs.getInt("CarRentalShopID"));

                    result.add(car);
                }
            }

        } catch (SQLException e) {
            System.err.println("Lỗi truy vấn cơ sở dữ liệu khi tìm kiếm xe:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Lỗi không mong muốn khi tìm kiếm xe:");
            e.printStackTrace();
        }

        return result;
    }
}
