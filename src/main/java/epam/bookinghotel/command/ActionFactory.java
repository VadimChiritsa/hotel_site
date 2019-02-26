package epam.vakulchyk.bookinghotel.command;
import javax.servlet.http.HttpServletRequest;
public class ActionFactory {
    /**method of
     it extracts the value of the command parameter from the query and, based on it,
     retrieves the corresponding object-command

     * @return
     */
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();

        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}

