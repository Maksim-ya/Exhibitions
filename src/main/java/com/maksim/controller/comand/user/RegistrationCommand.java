package com.maksim.controller.comand.user;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.MessageManager;
import com.maksim.domain.User;
import com.maksim.model.dao.UserDao;
import com.maksim.model.impl.DaoFactoryImpl;
import com.maksim.model.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 03/04/2018.
 */
public class RegistrationCommand implements Command {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_FULL_NAME = "fullName";
    private static final String PARAM_NAME_ADDRESS = "address";

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page ;
//извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        String fullName = request.getParameter(PARAM_NAME_FULL_NAME);
        String address = request.getParameter(PARAM_NAME_ADDRESS);
        UserDao userDao = DaoFactoryImpl.getInstance().getUserDao();

        User user = new User();

        user.setLogin(login);
        user.setPassword(pass);
        user.setFullName(fullName);
        user.setAddress(address);



        if (userDao.addUser(user)) {

            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.LOGIN_PAGE_PATH);
            request.setAttribute("registrationMessage", MessageManager.getInstance().getMessage(MessageManager.SUCCESS_REGISTRATION_MESSAGE));

        } else {
            request.setAttribute("errorMessage", MessageManager.getInstance().getMessage(MessageManager.LOGIN_ERROR_MESSAGE));
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
        }
        return page;
    }
}
