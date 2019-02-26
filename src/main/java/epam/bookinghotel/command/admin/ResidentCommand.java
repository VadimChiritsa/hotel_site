package epam.vakulchyk.bookinghotel.command.admin;

import epam.vakulchyk.bookinghotel.command.ActionCommand;
import epam.vakulchyk.bookinghotel.command.ConfigurationManager;
import epam.vakulchyk.bookinghotel.entity.Resident;
import epam.vakulchyk.bookinghotel.logic.ResidentLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ResidentCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(ResidentCommand.class);

    /**
     * This  causes dao method, that select all resident
     * and than make list of this
     *
     * @return page for further work
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String id = null;
        ArrayList<Resident> list = new ArrayList<Resident>();
        ResidentLogic residentLogic = new ResidentLogic();
        list = residentLogic.makeResidentList();
        HttpSession session = request.getSession();
        session.setAttribute("resident", list);
        LOGGER.info("Admin take list of resident");
        page = ConfigurationManager.getProperty("path.page.tenants");
        return page;
    }
}
