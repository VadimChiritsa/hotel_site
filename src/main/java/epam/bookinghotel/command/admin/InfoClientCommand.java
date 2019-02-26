package epam.vakulchyk.bookinghotel.command.admin;

import epam.vakulchyk.bookinghotel.command.ActionCommand;
import epam.vakulchyk.bookinghotel.command.ConfigurationManager;
import epam.vakulchyk.bookinghotel.entity.Client;
import epam.vakulchyk.bookinghotel.logic.ClientLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class InfoClientCommand implements ActionCommand {
    private static final String ID_PARAMETER = "id";
    private static final String CLIENT_LIST = "clientList";
    private static final Logger LOGGER = LogManager.getLogger(InfoClientCommand.class);
    /**
     * This method take from jsp file id client,than causes dao method,
     * that find in db data about client
     * by id and create list of data about this client
     * @return page for further work
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int id = Integer.parseInt(request.getParameter(ID_PARAMETER));
        ArrayList<Client> list = ClientLogic.makeClientList(id);
        request.setAttribute(CLIENT_LIST,list);
        request.setAttribute(ID_PARAMETER,id);
        LOGGER.info("Admin take date about client");
        page= ConfigurationManager.getProperty("path.page.client");
        return page;
    }
}
