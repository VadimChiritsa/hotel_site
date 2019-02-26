package epam.vakulchyk.bookinghotel.command.client;

import epam.vakulchyk.bookinghotel.command.ActionCommand;
import epam.vakulchyk.bookinghotel.command.ConfigurationManager;
import epam.vakulchyk.bookinghotel.command.admin.ResidentCommand;
import epam.vakulchyk.bookinghotel.entity.Order;
import epam.vakulchyk.bookinghotel.logic.OrderLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ClientOrderCommand implements ActionCommand {
    private final static String PARAM_NAME_ID = "idPerson";
    private final static String PARAM_ORDER_PERSON = "personOrderList";
    private static final Logger LOGGER = LogManager.getLogger(ClientOrderCommand.class);
    /**
     * This take from jsp file id client
     * than causes dao method, that select all orders from db
     * @return page for further work
     */
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session= request.getSession();
        String page = null;
        int id =(int)session.getAttribute(PARAM_NAME_ID);
        OrderLogic orderLogic = new OrderLogic();
        ArrayList<Order> list = new ArrayList<Order>();
        list = orderLogic.personOreder(id);
        request.setAttribute(PARAM_ORDER_PERSON,list);
        LOGGER.info("Client take his order");
        page = ConfigurationManager.getProperty("path.page.applicationPage") ;
        return page;
    }
}
