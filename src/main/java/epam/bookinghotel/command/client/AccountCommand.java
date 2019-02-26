package epam.vakulchyk.bookinghotel.command.client;

import epam.vakulchyk.bookinghotel.command.ActionCommand;
import epam.vakulchyk.bookinghotel.command.ConfigurationManager;
import epam.vakulchyk.bookinghotel.entity.Client;
import epam.vakulchyk.bookinghotel.logic.ClientLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


public class AccountCommand implements ActionCommand {
    private static final String PARAM_ID_PERSON= "idPerson";
    private static final String PARAM_DATA_ABOUT_CLIENT = "dataAboutClient";
    /**
     * This take from jsp file id client than causes dao method, that select all data
     * about client by id
     * @return page for further work
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page=null;
        int id =0;
        ArrayList<Client> list = new ArrayList<Client>();
        HttpSession session= request.getSession();
        id = (int)session.getAttribute(PARAM_ID_PERSON);
        ClientLogic clientLogic = new ClientLogic();
        list = clientLogic.makeClientList(id);
        request.setAttribute(PARAM_DATA_ABOUT_CLIENT, list);
        page = ConfigurationManager.getProperty("path.page.menuClient");

        return page;
    }
}
