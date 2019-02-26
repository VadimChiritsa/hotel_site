package epam.vakulchyk.bookinghotel.command.client;

import epam.vakulchyk.bookinghotel.command.ActionCommand;
import epam.vakulchyk.bookinghotel.command.ConfigurationManager;
import epam.vakulchyk.bookinghotel.command.MessageManager;
import epam.vakulchyk.bookinghotel.entity.Order;
import epam.vakulchyk.bookinghotel.logic.OrderLogic;
import epam.vakulchyk.bookinghotel.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddOrederCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(AddOrederCommand.class);
    /**
     * This take from jsp file all data about client's order
     * than causes dao method, that insert it to db
     * @return page for further work
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String resultValidation = null;
        OrderLogic orderLogic = new OrderLogic();
        HttpSession session = request.getSession();
        int idClient= (int) session.getAttribute("idPerson");
        int numberSeats = Integer.parseInt(request.getParameter("numberSeats"));
        String typeApartment = request.getParameter("typeApartment");
        int timeStay = Integer.parseInt(request.getParameter("time"));
        String dateArrival = request.getParameter("data");
        //int numberSeats, int idClient, String typeApartment, int timeStay, String dateArrival

        if (resultValidation!=null) {
            request.setAttribute("errorPassMessage", resultValidation);
        } else {
            orderLogic.creatOreder(numberSeats,idClient,typeApartment,timeStay,dateArrival);
            request.setAttribute("errorPassMessage", "Your order add");
        }
        page = ConfigurationManager.getProperty("path.page.addOrder");

        return page;
    }
}
