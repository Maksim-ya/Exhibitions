package com.maksim.controller.command.user;

import com.maksim.controller.comand.user.LoginCommand;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.domain.User;
import com.maksim.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginCommandTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private User user;
    @Mock
    private UserService userService;
    @InjectMocks
    private LoginCommand loginCommand = new LoginCommand();

    @Test
    public void rightLoginIn() throws ServletException, IOException {
        String login = "tom";
        String password = "tom";
        when(request.getParameter("login")).thenReturn(login);
        when(request.getParameter("password")).thenReturn(password);
        when(request.getSession()).thenReturn(session);

        user= new User(1,login,password,anyString(),anyString(), BigDecimal.ZERO);

        when(userService.checkLoginAndPassword(login,password));
        String page = loginCommand.execute(request,response);
        Assert.assertEquals(ConfigurationManager.getInstance().getPage(ConfigurationManager.MAIN_PAGE_PATH),page);
    }

}
