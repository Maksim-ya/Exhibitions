package com.maksim.controller.comand.redirect;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.UserSession;
import com.maksim.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginPage implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("********************************");
        java.util.Enumeration cats = request.getAttributeNames();
        List<Object> list = java.util.Collections.list(cats);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        HttpSession se = request.getSession(true);
        User user = (User) se.getAttribute(PARAM_USER);
        return  UserSession.loadUserDataToSession( request);
//        return ConfigurationManager.getInstance().getPage(ConfigurationManager.LOGIN_PAGE_PATH);
    }
}
