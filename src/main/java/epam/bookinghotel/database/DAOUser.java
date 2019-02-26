package epam.vakulchyk.bookinghotel.database;

import epam.vakulchyk.bookinghotel.entity.User;

import java.sql.*;

public class DAOUser extends DAO<User> {
    private final static String SELECT_LOGIN_FROM_ADMIN = "Select login from admin";
    private final static String SELECT_AUTHORIZ_USER = "Select login,password from user";
    private final static String CREATE_USER = "INSERT INTO user (login,password) VALUES(?,?)";
    private final static String PARAM_ADMIN="admin";
    private final static String PARAM_CLIENT="client";

    public DAOUser(Connection connection) {
        super(connection);
    }

    public String authorization(String login, String password) throws SQLException {
        Statement statmt = null;
        statmt = connection.createStatement();
        String result = "error";
        ResultSet resSet;
        resSet = statmt.executeQuery(SELECT_AUTHORIZ_USER);

        while (resSet.next()) {
            String log = resSet.getString("login");
            String pass = resSet.getString("password");
            if (log.equals(login) && pass.equals(password)) {
                boolean role = false;
                role = cheakRole(login);
                if (role) {
                    result = PARAM_ADMIN;
                } else {
                    result = PARAM_CLIENT;
                }
            }
        }
        return result;
    }

    public boolean cheakRole(String login) throws SQLException {
        boolean result = false;
        Statement statmt = null;
        statmt = connection.createStatement();
        ResultSet resSet;
        resSet = statmt.executeQuery(SELECT_LOGIN_FROM_ADMIN);
        while (resSet.next()) {
            String log = resSet.getString("login");
            if (log.equals(login)) {
                result = true;
            }
        }
        return result;
    }

    public boolean create(String login, String password) {
        boolean result = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
           // preparedStatement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
