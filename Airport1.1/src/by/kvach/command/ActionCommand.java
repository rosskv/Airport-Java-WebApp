package by.kvach.command;

import by.kvach.dao.AppException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface ActionCommand {
    String execute(HttpServletRequest req) throws ServletException, IOException, AppException;
}
