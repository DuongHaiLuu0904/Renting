package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Client;

public class ClientDAO extends DAO {

    public ClientDAO() {
        super();
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public ArrayList<Client> searchClient(String key) {
        ArrayList<Client> result = new ArrayList<>();
        String sql = "SELECT * FROM Client WHERE name LIKE ? OR CCCD LIKE ? ";

        try (PreparedStatement ps = new DAO().getConnection().prepareStatement(sql)) {

            String searchKey = "%" + key + "%";
            ps.setString(1, searchKey);
            ps.setString(2, searchKey);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Client client = new Client();
                    client.setId(rs.getInt("ID"));
                    client.setName(rs.getString("name"));
                    client.setCccd(rs.getString("cccd"));
                    client.setAddress(rs.getString("Address"));
                    client.setPhoneNumber(rs.getString("phoneNumber"));
                    client.setEmail(rs.getString("Email"));
                    client.setNote(rs.getString("Note"));
                    result.add(client);
                }
            }

        } catch (SQLException e) {
            System.err.println("Lỗi truy vấn cơ sở dữ liệu khi tìm kiếm khách hàng:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Lỗi không mong muốn khi tìm kiếm khách hàng:");
            e.printStackTrace();
        }

        return result;
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void addClient(Client client) {
        String sql = "INSERT INTO Client(name, CCCD, Address, phoneNumber, Email, Note) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement ps = new DAO().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, client.getName());
            ps.setString(2, client.getCccd());
            ps.setString(3, client.getAddress());
            ps.setString(4, client.getPhoneNumber());
            ps.setString(5, client.getEmail());
            ps.setString(6, client.getNote());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        client.setId(generatedKeys.getInt(1));
                    }
                }
            } else {
                System.err.println("Không thể thêm khách hàng, không có dòng nào bị ảnh hưởng.");
            }

        } catch (SQLException e) {
            System.err.println("Lỗi truy vấn cơ sở dữ liệu khi thêm khách hàng:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Lỗi không mong muốn khi thêm khách hàng:");
            e.printStackTrace();
        }
    }
}
