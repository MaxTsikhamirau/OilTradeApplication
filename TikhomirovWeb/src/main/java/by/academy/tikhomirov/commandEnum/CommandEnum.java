package by.academy.tikhomirov.commandEnum;

import by.academy.tikhomirov.command.*;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LogInCommand();
        }
    },
    GETOFFERS {
        {
            this.command = new GetOffersCommand();
        }
    },
    GETORDERS {
        {
            this.command = new GetOrdersCommand();
        }
    },
	ADDORDER {
        {
            this.command = new AddOrderCommand();
        }
    },
	ADDOFFER {
        {
            this.command = new AddOfferCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

}