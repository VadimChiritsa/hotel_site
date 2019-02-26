package epam.vakulchyk.bookinghotel.database;


import epam.vakulchyk.bookinghotel.entity.Resident;

import java.sql.*;
import java.util.ArrayList;

public class DAOResident extends DAO<Resident> {

    public DAOResident(Connection connection) {
        super(connection);
    }
    public boolean deleteResident(int idOrder) throws SQLException {
        String sql = "DELETE FROM bookinghotel.residents WHERE id_order =?";
        boolean result=false;
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,idOrder);
        preparedStatement.executeUpdate();
        result = true;
        return result;

    }
    public boolean create(int cost, int idOrder, int numberRoom) {
        boolean result= false;
        try {
            Statement st = connection.createStatement();

            st.execute("INSERT INTO residents (cost,id_order,number_of_room) VALUES(' " + cost + "', '" + idOrder + "', '" + numberRoom + "');");
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public ArrayList<Resident> takeAllResident() throws SQLException {
        ArrayList<Resident> list = new ArrayList<>();
        String sql = "SELECT cost,id_order,number_of_room FROM bookinghotel.residents";

        Statement statmt = null;
        statmt = connection.createStatement();
        ResultSet resultSet;
        resultSet = statmt.executeQuery(sql);
        while (resultSet.next()) {
            Resident resident = new Resident();
            resident.setCoast(resultSet.getInt("cost"));
            resident.setIdOrder(resultSet.getInt("id_order"));
            resident.setNumderRoom(resultSet.getInt("number_of_room"));

            list.add(resident);
        }

        return list;
    }

}
