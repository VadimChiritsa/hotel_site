package epam.vakulchyk.bookinghotel.logic;

import epam.vakulchyk.bookinghotel.connection.ConnectionPool;
import epam.vakulchyk.bookinghotel.database.DAOClient;

import epam.vakulchyk.bookinghotel.entity.Client;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientLogic {
   // private static final Logger LOGGER = LogManager.getLogger(ClientLogic.class);


    public static ArrayList<Client> makeClientList(int id) {
        ConnectionPool connectionPool = new ConnectionPool(1);

        Connection connection = null;
        ArrayList<Client> list = new ArrayList<>();
        try {
            connection = connectionPool.retrieve();
            DAOClient daoClient = new DAOClient(connection);
            list = daoClient.dataClientByID(id);
       //     LOGGER.info("Admin take list of Client");
        }  catch (SQLException e) {
        //    LOGGER.error("Something wrong with sql query");
        } finally {
            connectionPool.putback(connection);
        }
        return list;
    }

}
