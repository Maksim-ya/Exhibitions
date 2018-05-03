package com.maksim.controller.comand.user;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.MessageManager;
import com.maksim.controller.manager.UserSession;
import com.maksim.domain.User;
import com.maksim.model.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginCommand implements Command {

    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
//извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
//        User user = LoginLogic.checkLogin(login, pass);
       User user = new UserDaoImpl().checkLoginAndPassword(login,password);
//проверка логина и пароля

        if (user != null) {
//            HttpSession se = request.getSession();
//            se.setAttribute(PARAM_USER, user);
//            se.setAttribute(PARAM_USERNAME, user.getFullName());
//            if (se.getAttribute("publication") != null) {
//                page = ConfigurationManager.getInstance().getPage(ConfigurationManager.BUY_PAGE_PATH);
//
//            } else {
//
//                SubscriptionDaoImpl subscriptionDao = new SubscriptionDaoImpl();
//                List<Subscription> list = subscriptionDao.findSubscriptionsByUser(user.getUserId());
//                request.setAttribute(PARAM_SUBSCRITIONS, list);
//
//                //определение пути к main.jsp
//                page = ConfigurationManager.getInstance().getPage(ConfigurationManager.MAIN_PAGE_PATH);
//            }

           page= UserSession.loadUserDataToSession( request, user);
        } else {
            request.setAttribute("errorMessage", MessageManager.getInstance().getMessage(MessageManager.LOGIN_ERROR_MESSAGE));
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}

