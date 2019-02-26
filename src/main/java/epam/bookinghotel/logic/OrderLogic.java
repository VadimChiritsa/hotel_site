package epam.vakulchyk.bookinghotel.logic;

import epam.vakulchyk.bookinghotel.connection.ConnectionPool;
import epam.vakulchyk.bookinghotel.database.DAOOrder;
import epam.vakulchyk.bookinghotel.entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class OrderLogic {
   private static final Logger LOGGER = LogManager.getLogger(OrderLogic.class);

    public ArrayList<Order> makeOrderList() {
        ConnectionPool connectionPool = new ConnectionPool(1);

        ArrayList<Order> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionPool.retrieve();
            DAOOrder daoOrder = new DAOOrder(connection);
            list = daoOrder.takeAllOrder();
            LOGGER.info("Make all orders in list");
        } catch (SQLException e) {
            LOGGER.error("Something wrong with sql query");
        } finally {
            connectionPool.putback(connection);

        }
        return list;
    }

    public ArrayList<Order> personOreder(int id) {
        ConnectionPool connectionPool = new ConnectionPool(1);
        ArrayList<Order> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionPool.retrieve();
            DAOOrder daoOrder = new DAOOrder(connection);
            list = daoOrder.orederClient(id);
            LOGGER.info("Got order of your person");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.putback(connection);
        }
        return list;
    }


    public boolean creatOreder(int numberSeats, int idClient, String typeApartment, int timeStay, String dateArrival) {
        ConnectionPool connectionPool = new ConnectionPool(1);
        boolean result = false;
        Connection connection = null;

        try {
            connection = connectionPool.retrieve();
            DAOOrder daoOrder = new DAOOrder(connection);
            result = daoOrder.create(numberSeats, idClient, typeApartment, timeStay, dateArrival);
            LOGGER.info("Client creat new order");
        } catch (SQLException e) {
            LOGGER.error("Something wrong with sql query");
        } finally {
            connectionPool.putback(connection);

        }
        return result;
    }
}
