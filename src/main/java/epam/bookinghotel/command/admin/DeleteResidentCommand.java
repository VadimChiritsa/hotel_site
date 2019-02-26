package epam.vakulchyk.bookinghotel.command.admin;

import epam.vakulchyk.bookinghotel.command.ActionCommand;
import epam.vakulchyk.bookinghotel.connection.ConnectionPool;
import epam.vakulchyk.bookinghotel.database.DAORoom;
import epam.vakulchyk.bookinghotel.logic.ResidentLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;

public class DeleteResidentCommand implements ActionCommand {
    private static final String PARAM_ID = "id";
    private static final String PARAM_FREE = "free";
    private static final String PARAM_NUMBER = "number";
    private static final Logger LOGGER = LogManager.getLogger(DeleteResidentCommand.class);

    /**
     * This method causes dao method, that delete resident from db
     * @return page for further work
     */
    @Override
    public String execute(HttpServletRequest request) {
        ConnectionPool connectionPool = new ConnectionPool(1);
        Connection connection = null;
        String page = null;
        boolean result;
        int id = 0;
        int number = 0;
        try {
            connection = connectionPool.retrieve();
            DAORoom daoRoom = new DAORoom(connection);

            ResidentCommand residentCommand = new ResidentCommand();
            ResidentLogic residentLogic = new ResidentLogic();
            id = Integer.parseInt(request.getParameter(PARAM_ID));
            number = Integer.parseInt(request.getParameter(PARAM_NUMBER));
            result = residentLogic.delResident(id);
            daoRoom.changeEmployment(number, PARAM_FREE);

            page = residentCommand.execute(request);
            LOGGER.info("Delete resident by id_client and room number");
        } catch (SQLException e) {
            LOGGER.error("Something wrong with sql query");
        } finally {
            connectionPool.putback(connection);
        }
        return page;
    }
}
