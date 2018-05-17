package com.maksim.controller;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.Logs;
import com.maksim.controller.manager.MessageManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Максим on 03/May/18.
 */
public class FrontController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(FrontController.class);

    //объект, содержащий список возможных команд
    RequestHelper requestHelper = RequestHelper.getInstance();

    public FrontController() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        try {
//определение команды, пришедшей из JSP
            Command command = requestHelper.getCommand(request);
/*вызов реализованного метода execute() интерфейса Command и передача
параметров классу-обработчику конкретной команды*/
            page = command.execute(request, response);
// метод возвращает страницу ответа
        } catch (ServletException e) {
            logger.error(e.getMessage());
//генерация сообщения об ошибке
            request.setAttribute("errorMessage", MessageManager.getInstance().getMessage(MessageManager.SERVLET_EXCEPTION_ERROR_MESSAGE));
//вызов JSP-страницы c cообщением об ошибке
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
        } catch (IOException e) {
            logger.error(e.getMessage());
            request.setAttribute("errorMessage", MessageManager.getInstance().getMessage(MessageManager.IO_EXCEPTION_ERROR_MESSAGE));
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            request.setAttribute("errorMessage", MessageManager.getInstance().getMessage(MessageManager.SERVER_ERROR_MESSAGE));
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
        }
//вызов страницы ответа на запрос
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        logger.info(Logs.REDIRECT_TO + page);
        dispatcher.forward(request, response);
    }
}
