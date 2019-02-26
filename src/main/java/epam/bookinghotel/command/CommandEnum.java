package epam.vakulchyk.bookinghotel.command;

import epam.vakulchyk.bookinghotel.command.admin.*;
import epam.vakulchyk.bookinghotel.command.client.*;
import epam.vakulchyk.bookinghotel.command.common.*;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    DELETEORDER{
        {
            this.command = new DeleteOrderCommand();
        }
    },
    ACCOUNT{
        {
            this.command = new AccountCommand();
        }
    },
    PERSONORDER {
        {
            this.command = new ClientOrderCommand();
        }
    },
    OPENPAGE {
        {
            this.command = new OpenCommand();
        }
    },
    INFOCLIENT {
        {
            this.command = new InfoClientCommand();
        }
    },
    LANGUAGE {
        {
            this.command = new LanguageCommand();
        }
    },
    ADDORDER {
        {
            this.command = new AddOrederCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    DELETERESIDENT {
        {
            this.command = new DeleteResidentCommand();
        }
    },
    LIST {
        {
            this.command = new RegistrationOrderCommand();
        }
    },
    TAKEFREEROOM {
        {
            this.command = new FreeRoomCommand();
        }
    },
    GETIN {
        {
            this.command = new AddOrederCommand();
        }
    },
    RESIDENT {
        {
            this.command = new ResidentCommand();
        }
    },

    REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
