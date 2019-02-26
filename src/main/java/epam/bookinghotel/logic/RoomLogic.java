package epam.vakulchyk.bookinghotel.logic;

import epam.vakulchyk.bookinghotel.connection.ConnectionPool;
import epam.vakulchyk.bookinghotel.database.DAORoom;
import epam.vakulchyk.bookinghotel.entity.Room;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomLogic {
  //  private static final Logger LOGGER = LogManager.getLogger(RoomLogic.class);

    public ArrayList<Room> makeListFreeRoom() {
        ConnectionPool connectionPool = new ConnectionPool(1);

        ArrayList<Room> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionPool.retrieve();
            DAORoom daoRoom = new DAORoom(connection);
            list = daoRoom.listfreeRoom();
      //      LOGGER.info("Admin take list of room that free at this moment");
        } catch (SQLException e) {
       //     LOGGER.error("Something wrong with sql query");
        } finally {
            connectionPool.putback(connection);
        }
        return list;
    }
}
