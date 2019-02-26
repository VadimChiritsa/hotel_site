package epam.vakulchyk.bookinghotel.command.common;

import epam.vakulchyk.bookinghotel.command.ActionCommand;
import epam.vakulchyk.bookinghotel.command.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final Logger LOGGER = LogManager.getLogger(LogoutCommand.class);
    /**
     * This  method for exit in account user
     *
     * @return page for further work
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.main");
        request.setAttribute(PARAM_NAME_LOGIN, null);
        HttpSession session = request.getSession();
        session.setAttribute("loginAdmin", null);
        session.setAttribute("idPerson", null);
        request.getSession().invalidate();
        return page;
    }
}
