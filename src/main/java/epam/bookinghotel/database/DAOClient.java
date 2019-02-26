package epam.vakulchyk.bookinghotel.database;

import epam.vakulchyk.bookinghotel.entity.Client;

import java.sql.*;
import java.util.ArrayList;

public class DAOClient extends DAO<Client> {
    private final static String SELECT_CLIENT_DATA_BY_LOGIN = "SELECT * FROM client WHERE login LIKE ?";
    private final static String SELECT_CLIENT_DATA_BY_ID = "SELECT * FROM client WHERE id_client LIKE ?";
    private final static String CREATE_CLIENT = "INSERT INTO client (surname,name, phone,passport_number,login) VALUES(?,?,?,?,?)";

    public DAOClient(Connection connection) {
        super(connection);
    }

    public ArrayList<Client> dataClient(String login) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(SELECT_CLIENT_DATA_BY_LOGIN);
        ArrayList<Client> list = new ArrayList<>();
        pstm.setString(1, login);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id_client");
            String surname = rs.getString("surname");
            String name = rs.getString("name");
            int phone = rs.getInt("phone");
            String passport = rs.getString("passport_number");
            int discount = rs.getInt("discount");
            Client client = new Client();
            client.setDiscount(discount);
            client.setIdClient(id);
            client.setLogin(login);
            client.setName(name);
            client.setSurname(surname);
            client.setPassportNumber(passport);
            client.setPhone(phone);
            list.add(client);
        }
        rs.close();
        return list;
    }

    public ArrayList<Client> dataClientByID(int id) throws SQLException {
        ArrayList<Client> list = new ArrayList<>();
        PreparedStatement pstm = connection.prepareStatement(SELECT_CLIENT_DATA_BY_ID);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            String surname = rs.getString("surname");
            String name = rs.getString("name");
            int phone = rs.getInt("phone");
            String passport = rs.getString("passport_number");
            int discount = rs.getInt("discount");
            Client client = new Client();
            client.setDiscount(discount);
            client.setName(name);
            client.setSurname(surname);
            client.setPassportNumber(passport);
            client.setPhone(phone);
            list.add(client);
        }
        rs.close();
        return list;
    }

    public boolean create(String surname, String name, String passport, int phone, String login) throws SQLException {
        boolean result = false;
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(CREATE_CLIENT);
        preparedStatement.setString(1, surname);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, phone);
        preparedStatement.setString(4, passport);
        preparedStatement.setString(5, login);
        preparedStatement.executeUpdate();
        result = true;
        preparedStatement.executeUpdate();
        return result;
    }

}
