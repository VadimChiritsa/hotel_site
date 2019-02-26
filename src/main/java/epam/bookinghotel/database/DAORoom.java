package epam.vakulchyk.bookinghotel.database;

import epam.vakulchyk.bookinghotel.entity.Room;

import java.sql.*;
import java.util.ArrayList;

public class DAORoom extends DAO<Room> {
    private final static String UPDATE_EMPLOYMENT = "UPDATE room SET employment=? WHERE number=?";
    private final static String SELECT_COST_BY_NUMBER = "select room.cost,room.number from room where number =?";
    private final static String SELECT_FREE_NUMBER = "SELECT number,number_of_seats,type_of_apartment,cost,employment FROM room where employment LIKE ?";
    private final static String FREE_ROOM = "free";

    public DAORoom(Connection connection) {
        super(connection);
    }


    public ArrayList<Room> listfreeRoom() throws SQLException {
        ArrayList<Room> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(SELECT_FREE_NUMBER);
        preparedStatement.setString(1, FREE_ROOM);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Room room = new Room();
            room.setNumber(rs.getInt("number"));
            room.setTypeApartment(rs.getString("type_of_apartment"));
            room.setNumberSeats(rs.getInt("number_of_seats"));
            room.setEmployment(rs.getString("employment"));
            room.setCost(rs.getInt("cost"));
            list.add(room);

        }
        rs.close();
        preparedStatement.close();
        return list;
    }

    public int takeCost(int number) throws SQLException {
        int cost = 0;
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(SELECT_COST_BY_NUMBER);
        preparedStatement.setInt(1, number);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            cost = resultSet.getInt("cost");
        }
       // preparedStatement.executeUpdate(); измненно без проверки
        resultSet.close();
        preparedStatement.close();
        return cost;
    }

    public void changeEmployment(int number, String employment) throws SQLException {
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(UPDATE_EMPLOYMENT);
        preparedStatement.setString(1, employment);
        preparedStatement.setInt(2, number);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
