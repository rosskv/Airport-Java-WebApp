package by.kvach.command;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    SIGNIN{
        {
            this.command = new SigninCommand();
        }

    },
    VIEWUSERS{
        {
            this.command = new ViewUsersCommand();
        }

    }
    ,
    REMOVEUSER{
        {
            this.command = new RemoveUserCommand();
        }

    }
    ,
    VIEWFLIGHTS{
        {
            this.command = new ViewFlightsCommand();
        }

    },
    REMOVEFLIGHTS{
        {
            this.command = new RemoveFlightsCommand();
        }

    },
    ADDFLIGHT{
        {
            this.command = new AddFlightCommand();
        }

    },
    VIEWBRIGADE{
        {
            this.command = new ViewBrigadeCommand();
        }

    }
    ,
    ADDBRIGADE{
        {
            this.command = new AddBrigadeCommand();
        }

    },
    REMOVEBRIGADE{
        {
            this.command = new RemoveBrigadeCommand();
        }

    }
    ,
    VIEWEMPLOYEES{
        {
            this.command = new ViewEmployeesCommand();
        }

    },
    VIEWPAGE{
        {
            this.command = new ViewPageCommand();
        }

    }
    ,
    VIEWEMPLOYEESBRIGADE{
        {
            this.command = new ViewEmployeesBrigadeCommand();
        }

    },
    ADDEMPLOYEESINTOBRIGADE{
        {
            this.command = new AddEmployeesIntoBrigadeCommand();
        }

    },
    REMOVEEMPLOYEESINTOBRIGADE{
        {
            this.command = new RemoveEmployeesIntoBrigadeCommand();
        }

    },
    ADDEMPLOYEES{
        {
            this.command = new AddEmployeesCommand();
        }

    },
    VIEWPROFESSIONS{
        {
            this.command = new ViewProfessionsCommand();
        }

    },
    ADDEMPLOYEESFORM{
        {
            this.command = new AddEmployeesFormCommand();
        }

    },
    REMOVEEMPLOYEES{
        {
            this.command = new RemoveEmployeesCommand();
        }

    };

    ActionCommand command;

    public ActionCommand getCurrentCommand(){
        return command;
    }
}


/* OLD

public enum CommandEnum {
    LOGIN("login"),
    LOGOUT("logout"),
    SIGNIN("signin");

    private final String commandName;

    CommandEnum(String commandName) {
        this.commandName = commandName;
    }

    public String getStringValue(){
        return this.commandName;
    }

    public static CommandEnum getCommandNameByString(String name){
        for (CommandEnum cn: CommandEnum.values()){
            if (cn.getStringValue().equals(name)){
                return cn;
            }
        }
        return null;
    }
}

 */