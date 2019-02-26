package epam.vakulchyk.bookinghotel.command.admin;

import epam.vakulchyk.bookinghotel.command.ActionCommand;
import epam.vakulchyk.bookinghotel.command.ConfigurationManager;
import epam.vakulchyk.bookinghotel.entity.Room;
import epam.vakulchyk.bookinghotel.logic.RoomLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class FreeRoomCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(FreeRoomCommand.class);
    /**
     * This method causes dao method, that find in db free room,
     * and than create list of this one
     * @return page for further work
     */
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String id = null;
        ArrayList<Room> list = new ArrayList<Room>();
        RoomLogic roomLogic = new RoomLogic();
        list = roomLogic.makeListFreeRoom();
        id = request.getParameter("id");
        request.setAttribute("idOrder", id);
        request.setAttribute("freeRoom", list);
        LOGGER.info("Admin take all free room");
        page = ConfigurationManager.getProperty("path.page.freeRoom");
        return page;
    }
}
