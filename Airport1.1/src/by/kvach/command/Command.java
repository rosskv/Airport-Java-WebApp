package by.kvach.command;

/**
 * Created by manager on 14.12.2016.
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Command {
    public abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    public String toString() {
        return getClass().getName();
    }


}
