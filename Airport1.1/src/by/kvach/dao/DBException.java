package by.kvach.dao;

/**
 * Created by manager on 16.12.2016.
 */

public class DBException extends AppException {

    /**
     *
     */
    private static final long serialVersionUID = -4030225922890413273L;

    public DBException() {
        super();
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }

}