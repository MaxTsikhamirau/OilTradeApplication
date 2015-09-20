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
    },
	SAVEORDER {
        {
            this.command = new SaveOrderCommand();
        }
    },
	SAVEOFFER {
        {
           this.command = new SaveOfferCommand();
        }
    },
	CREATEUSER {
        {
            this.command = new CreateUserCommand();
        }
    },
	DELETEUSER {
        {
            this.command = new DeleteUserCommand();
        }
    },
	REGISTRATE {
        {
            this.command = new RegistrateCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

}