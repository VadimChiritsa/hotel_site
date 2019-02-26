package epam.vakulchyk.bookinghotel.command.client;

import epam.vakulchyk.bookinghotel.command.ActionCommand;
import epam.vakulchyk.bookinghotel.command.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class OpenRegistrationCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        page = ConfigurationManager.getProperty("path.page.registration");
        return page;
    }
}
