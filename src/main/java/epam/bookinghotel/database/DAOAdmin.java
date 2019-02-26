package epam.vakulchyk.bookinghotel.database;

import epam.vakulchyk.bookinghotel.entity.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOAdmin extends DAO<Admin> {
    private final static String SELECT_ADMIN_DATA_BY_LOGIN = "Select * from admin where login = ? ";

    public DAOAdmin(Connection connection) {
        super(connection);
    }

    public Admin dataAdmin(String login) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SELECT_ADMIN_DATA_BY_LOGIN);
        pstm.setString(1, login);
        ResultSet rs = pstm.executeQuery();
        Admin admin = new Admin();
        if (rs.next()) {
            String surname = rs.getString("surname");
            String name = rs.getString("name");
            String position = rs.getString("position");
            long id = rs.getInt("id_admin");
            admin.setIdAdmin(id);
            admin.setLogin(login);
            admin.setSurname(surname);
            admin.setName(name);
            admin.setPosition(position);
        }
        rs.close();
        pstm.executeUpdate();
        return admin;
    }
}
