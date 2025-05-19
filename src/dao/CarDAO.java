package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import model.Car;

public class CarDAO extends DAO {

    public CarDAO() {
        super();
    }

    public ArrayList<Car> searchCar(Date pickupDate, Date returnDate) {
        ArrayList<Car> result = new ArrayList<>();
        String sql = "SELECT * FROM Car WHERE ID NOT IN "
                + "(SELECT CarID FROM RentedCar WHERE carReturnDate > ? AND carPickupDate < ?)";

        // Sử dụng try-with-resources để đảm bảo PreparedStatement, ResultSet và Connection được đóng
        try (Connection connection = new DAO().getConnection(); // Lấy kết nối từ lớp DAO
                 PreparedStatement ps = connection.prepareStatement(sql)) {

            // Chuyển đổi java.util.Date sang java.sql.Date để sử dụng trong PreparedStatement
            java.sql.Date sqlPickupDate = new java.sql.Date(pickupDate.getTime());
            java.sql.Date sqlReturnDate = new java.sql.Date(returnDate.getTime());

            // Sử dụng setDate để truyền tham số ngày tháng một cách an toàn
            ps.setDate(1, sqlReturnDate); // Tham số thứ nhất ứng với carReturnDate > ?
            ps.setDate(2, sqlPickupDate);  // Tham số thứ hai ứng với carPickupDate < ?

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // Tạo đối tượng Car từ dữ liệu trong ResultSet
                    Car car = new Car();
                    car.setId(rs.getInt("ID"));
                    car.setName(rs.getString("name"));
                    car.setType(rs.getString("type"));
                    car.setPrice(rs.getFloat("price"));
                    car.setCarLine(rs.getString("Car_line"));
                    car.setFuelCondition(rs.getString("Fuel_Condition"));
                    car.setTypeCondition(rs.getString("Type_Codition"));      
                    car.setInteriorCondition(rs.getString("Interior_codition"));
                    car.setCarRentalShopID(rs.getInt("CarRentalShopID"));

                    // Thêm đối tượng Car vào danh sách kết quả
                    result.add(car);
                }
            } // ResultSet rs được đóng tự động tại đây

        } catch (SQLException e) {
            System.err.println("Lỗi truy vấn cơ sở dữ liệu khi tìm kiếm xe:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Lỗi không mong muốn khi tìm kiếm xe:");
        }

        return result;
    }
}
