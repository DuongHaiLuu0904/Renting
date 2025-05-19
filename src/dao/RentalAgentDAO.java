package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.RentalAgent;

public class RentalAgentDAO extends DAO {

    public RentalAgentDAO() {
        super();
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public boolean checkLogin(RentalAgent agent) {

        boolean result = false;
        String sql = "SELECT name, position FROM RentalAgent WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = new DAO().getConnection().prepareStatement(sql);
            ps.setString(1, agent.getUsername());
            ps.setString(2, agent.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                agent.setName(rs.getString("name"));
                agent.setPosition(rs.getString("position"));
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
}
