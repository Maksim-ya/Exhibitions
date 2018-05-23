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
    public String execute(HttpServletRequest request, HttpServletResponse response)  {
        return  UserSession.loadUserDataToSession( request);
    }
}
