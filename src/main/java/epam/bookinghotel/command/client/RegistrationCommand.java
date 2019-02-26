package epam.vakulchyk.bookinghotel.command.client;

import epam.vakulchyk.bookinghotel.command.ActionCommand;
import epam.vakulchyk.bookinghotel.command.ConfigurationManager;
import epam.vakulchyk.bookinghotel.command.MessageManager;
import epam.vakulchyk.bookinghotel.connection.ConnectionPool;
import epam.vakulchyk.bookinghotel.database.DAOClient;
import epam.vakulchyk.bookinghotel.database.DAOUser;
import epam.vakulchyk.bookinghotel.entity.Client;
import epam.vakulchyk.bookinghotel.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegistrationCommand implements ActionCommand {
    private static final String PARAM_NAME_SURNAME = "surname";
    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_PHONE = "phone";
    private static final String PARAM_NAME_PASSPORT = "passportNumber";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_SECOND_PASSWORD = "secondPassword";
    private static final Logger LOGGER = LogManager.getLogger(RegistrationCommand.class);

    /**
     * This take from jsp file all data about client's order
     * than causes dao method, that insert it to db
     *
     * @return page for further work
     */
    @Override
    public String execute(HttpServletRequest request) {
        boolean resultUser;
        boolean resultClient;
        Validation validation = new Validation();
        String page = null;
        ConnectionPool connectionPool = new ConnectionPool(2);
        DAOUser daoUser;
        DAOClient daoClient;
        Connection connection = null;
        try {
            connection = connectionPool.retrieve();
            daoUser = new DAOUser(connection);
            daoClient = new DAOClient(connection);
            String surname = request.getParameter(PARAM_NAME_SURNAME);
            String name = request.getParameter(PARAM_NAME_NAME);
            int phone = Integer.parseInt(request.getParameter(PARAM_NAME_PHONE));
            String passport = request.getParameter(PARAM_NAME_PASSPORT);
            String login = request.getParameter(PARAM_NAME_LOGIN);
            String password = request.getParameter(PARAM_NAME_PASSWORD);
            String secondPassword = request.getParameter(PARAM_NAME_SECOND_PASSWORD);
            String resultValidationOne = validation.cheakPassword(password, secondPassword);
            String resultValidationTwo = validation.validationClient(name, surname, phone);


            resultUser = daoUser.create(login, password);
            resultClient = daoClient.create(surname, name, passport, phone, login);

            if (resultClient || resultUser) {
                page = ConfigurationManager.getProperty("path.page.login");
                LOGGER.info("User registered");
            } else {
                request.setAttribute("errorMessage", MessageManager.getProperty("message.error"));
                page = ConfigurationManager.getProperty("path.page.registration");
            }


        } catch (SQLException e) {
            LOGGER.error("Something wrong with sql query");
        } finally {
            connectionPool.putback(connection);
        }

        return page;
    }

}
