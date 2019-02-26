package epam.vakulchyk.bookinghotel.command.common;

import epam.vakulchyk.bookinghotel.command.ActionCommand;
import epam.vakulchyk.bookinghotel.command.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LanguageCommand implements ActionCommand {
    private static final String LANGUAGE_PARAMETER = "lang";
    private static final String LOCALE_ATTRIBUTE = "locale";
    private static final Logger LOGGER = LogManager.getLogger(LanguageCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String newLocale = request.getParameter(LANGUAGE_PARAMETER);
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(LOCALE_ATTRIBUTE, newLocale);
        String newPage = request.getParameter("page");
        String n = "path.page."+newPage;
        page = ConfigurationManager.getProperty(n);
        LOGGER.info("Change language");
        return page;
    }
}
