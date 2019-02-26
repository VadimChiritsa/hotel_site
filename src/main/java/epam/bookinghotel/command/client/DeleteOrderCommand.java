package epam.vakulchyk.bookinghotel.command.client;

import epam.vakulchyk.bookinghotel.command.ActionCommand;
import epam.vakulchyk.bookinghotel.command.admin.ResidentCommand;
import epam.vakulchyk.bookinghotel.connection.ConnectionPool;
import epam.vakulchyk.bookinghotel.database.DAOOrder;
import epam.vakulchyk.bookinghotel.logic.ResidentLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;

public class DeleteOrderCommand implements ActionCommand {
    private static final String PARAM_ID_ORDER ="idOrder";
    private static final Logger LOGGER = LogManager.getLogger(DeleteOrderCommand.class);


    @Override
    public String execute(HttpServletRequest request) {
        ConnectionPool connectionPool = new ConnectionPool(1);
        Connection connection = null;
        String page = null;
        boolean result = false;
        int id = 0;

        try {
            connection = connectionPool.retrieve();
            DAOOrder daoOrder = new DAOOrder(connection);
            ResidentLogic residentLogic = new ResidentLogic();
            id = Integer.parseInt(request.getParameter(PARAM_ID_ORDER));
            result = daoOrder.deleteOrder(id);
            AccountCommand accountCommand = new AccountCommand();
            page = accountCommand.execute(request);
            LOGGER.info("Delete order by id_order");
        } catch (SQLException e) {
            LOGGER.error("Something wrong with sql query");
        } finally {
            connectionPool.putback(connection);
        }
        return page;
    }
}
