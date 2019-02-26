package epam.vakulchyk.bookinghotel.command.common;

import epam.vakulchyk.bookinghotel.command.ActionCommand;
import epam.vakulchyk.bookinghotel.command.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class OpenCommand implements ActionCommand{
    private static final String PARAM_PAGE = "page";
    /**
     * This  method for open page, that user want
     *
     * @return page for further work
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String newPage = request.getParameter(PARAM_PAGE);
        String n = "path.page."+newPage;
        page = ConfigurationManager.getProperty(n);
        return page;
    }
}
