package epam.vakulchyk.bookinghotel.command.common;

import epam.vakulchyk.bookinghotel.command.ActionCommand;
import epam.vakulchyk.bookinghotel.command.ConfigurationManager;
import epam.vakulchyk.bookinghotel.command.MessageManager;
import epam.vakulchyk.bookinghotel.connection.ConnectionPool;
import epam.vakulchyk.bookinghotel.database.DAOClient;
import epam.vakulchyk.bookinghotel.database.DAOUser;
import epam.vakulchyk.bookinghotel.entity.Client;
import epam.vakulchyk.bookinghotel.entity.Order;
import epam.vakulchyk.bookinghotel.logic.OrderLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_ADMIN = "admin";
    private static final String PARAM_NAME_CLIENT = "client";
    private static final String PARAM_NAME_ERROR = "error";
    private static final String PARAM_DATA_ABOUT_CLIENT = "dataAboutClient";
    private static final String PARAM_ID_PERSON= "idPerson";
    private static final String PARAM_ORDER_LIST= "orderLogic";
    private static final String PARAM_LOGIN_ADMIN= "loginAdmin";
    private static final Logger LOGGER = LogManager.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        ConnectionPool connectionPool = new ConnectionPool(1);
        Connection connection= null;
        DAOUser daoUser = null;
        try {
            connection = connectionPool.retrieve();
            daoUser = new DAOUser(connection);
            String login = request.getParameter(PARAM_NAME_LOGIN);
            String pass = request.getParameter(PARAM_NAME_PASSWORD);

            String result = daoUser.authorization(login, pass);
            switch (result) {
                case PARAM_NAME_ADMIN: {
                    page = ConfigurationManager.getProperty("path.page.menuAdmin");
                    OrderLogic orderLogic = new OrderLogic();
                    ArrayList<Order> list = orderLogic.makeOrderList();

                    HttpSession session= request.getSession();
                    session.setAttribute(PARAM_LOGIN_ADMIN,login);
                    session.setAttribute(PARAM_ORDER_LIST,list);
                    LOGGER.info("User enter as a admin");
                    break;
                }
                case PARAM_NAME_CLIENT: {
                    takeData(request, login);
                    page = ConfigurationManager.getProperty("path.page.menuClient");
                    LOGGER.info("User enter as a client");
                    break;
                }
                case PARAM_NAME_ERROR: {
                    request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
                    page = ConfigurationManager.getProperty("path.page.login");
                    LOGGER.info("Some problem with enter");
                    break;
                }
            }
        }  catch (SQLException e) {
            LOGGER.error("Something wrong with sql query");
        }finally {
            connectionPool.putback(connection);
        }
        return page;
    }

    private void takeData(HttpServletRequest request, String login) {
        Client client = null;
        ArrayList<Client> list = new ArrayList<Client>();
        DAOClient daoClient;
        ConnectionPool connectionPool = new ConnectionPool(1);
        Connection connection = null;
        try {
            connection = connectionPool.retrieve();
            daoClient = new DAOClient(connection);
            list = daoClient.dataClient(login);
            request.setAttribute(PARAM_DATA_ABOUT_CLIENT, list);
            HttpSession session= request.getSession();
            session.setAttribute(PARAM_ID_PERSON,list.get(0).getIdClient());
            LOGGER.info("Problem with take data about client");

        } catch (SQLException e) {
            LOGGER.error("Something wrong with sql query");
        } finally {
            connectionPool.putback(connection);
        }

    }
}
