package epam.vakulchyk.bookinghotel.tag;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class GreetingsTag extends TagSupport {
    private String login;

    public void setLogin(String login) {
        this.login = login;
    }

    public int doStartTag() {
        try {
            pageContext.getOut().write("Hello,"+login);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
