package epam.vakulchyk.bookinghotel.logic;

import epam.vakulchyk.bookinghotel.connection.ConnectionPool;
import epam.vakulchyk.bookinghotel.database.DAOResident;
import epam.vakulchyk.bookinghotel.entity.Resident;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResidentLogic {
    //private static final Logger LOGGER = LogManager.getLogger(ResidentLogic.class);

    public ArrayList<Resident> makeResidentList() {
        ConnectionPool connectionPool = new ConnectionPool(1);

        ArrayList<Resident> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionPool.retrieve();
            DAOResident daoResident = new DAOResident(connection);
            list = daoResident.takeAllResident();
      //      LOGGER.info("Make all residents in list");
        } catch (SQLException e) {
       //     LOGGER.error("Something wrong with sql query");
        } finally {
            connectionPool.putback(connection);
        }
        return list;
    }

    public boolean delResident(int id) {
        ConnectionPool connectionPool = new ConnectionPool(1);
        Connection connection = null;
        boolean result = false;
        try {
            connection = connectionPool.retrieve();
            DAOResident daoResident = new DAOResident(connection);
            result = daoResident.deleteResident(id);
       //     LOGGER.info("Delete resident by id");
        } catch (SQLException e) {
       //     LOGGER.error("Something wrong with sql query");
        } finally {
            connectionPool.putback(connection);
        }
        return result;
    }
}
