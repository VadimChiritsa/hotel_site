package epam.vakulchyk.bookinghotel.database;

import epam.vakulchyk.bookinghotel.entity.Order;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DAOOrder extends DAO<Order> {
    private final static String SELECT_ALL = "SELECT * FROM bookinghotel.order";
    private final static String CREATE_ORDER = "INSERT INTO bookinghotel.order (number_of_seats, type_of_apartment, time_of_stay, data_of_arrival, id_client) VALUE (?,?,?,?,?)";
    private final static String SELECT_TIME_BY_ID = "select id_order,time_of_stay from bookinghotel.order where id_order=?";
    private final static String SELECT_ORDER_BY_ID = "SELECT number_of_seats,type_of_apartment,time_of_stay,data_of_arrival,id_client FROM bookinghotel.order WHERE id_client = ? ";

    public DAOOrder(Connection connection) {
        super(connection);
    }

    public ArrayList<Order> takeAllOrder() throws SQLException {
        ArrayList<Order> list = new ArrayList<>();
        Statement statmt = null;
        statmt = connection.createStatement();
        ResultSet resultSet;
        resultSet = statmt.executeQuery(SELECT_ALL);
        while (resultSet.next()) {
            Order order = new Order();
            order.setIdOrder(resultSet.getInt("id_order"));
            order.setNumberSeats(resultSet.getInt("number_of_seats"));
            order.setTypeApartment(resultSet.getString("type_of_apartment"));
            order.setTimeStay(resultSet.getInt("time_of_stay"));
            Date date = (Date) resultSet.getObject("data_of_arrival");
            order.setDataArrival(date);
            order.setIdClient(resultSet.getInt("id_client"));
            list.add(order);
        }

        return list;
    }

    public boolean deleteOrder(int idOrder) throws SQLException {
        String sql = "DELETE FROM bookinghotel.order WHERE id_order =?";
        boolean result=false;
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,idOrder);
        preparedStatement.executeUpdate();
        result = true;
        return result;

    }
    public boolean create(int numberSeats, int idClient, String typeApartment, int timeStay, String dateArrival) throws SQLException {
        boolean result = false;
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(CREATE_ORDER);

        preparedStatement.setInt(1, numberSeats);
        preparedStatement.setString(2, typeApartment);
        preparedStatement.setInt(3, timeStay);
        preparedStatement.setString(4, dateArrival);
        preparedStatement.setInt(5, idClient);
        preparedStatement.executeUpdate();
        result = true;
        return result;
    }

    public int takeTimeStay(int id) throws SQLException {
        int time = 0;
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(SELECT_TIME_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            time = resultSet.getInt("time_of_stay");
        }
        return time;
    }

    public ArrayList<Order> orederClient(int id) throws SQLException {
        ArrayList<Order> list = new ArrayList<>();
        Statement statmt = null;
        statmt = connection.createStatement();
        ResultSet resultSet;
        resultSet = statmt.executeQuery("SELECT id_order,number_of_seats,type_of_apartment,time_of_stay,data_of_arrival,id_client FROM bookinghotel.order WHERE id_client =" + id );
        while (resultSet.next()) {
            Order order = new Order();
            order.setIdOrder(resultSet.getInt("id_order"));
            order.setNumberSeats(resultSet.getInt("number_of_seats"));
            order.setTypeApartment(resultSet.getString("type_of_apartment"));
            order.setTimeStay(resultSet.getInt("time_of_stay"));
            Date date = (Date) resultSet.getObject("data_of_arrival");
            order.setDataArrival(date);
            order.setIdClient(resultSet.getInt("id_client"));
            list.add(order);
        }
        return list;
    }
}
