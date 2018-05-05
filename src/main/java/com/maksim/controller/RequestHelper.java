package com.maksim.controller;

import com.maksim.controller.comand.BasketCommand;
import com.maksim.controller.comand.Command;
import com.maksim.controller.comand.NoCommand;
import com.maksim.controller.comand.exposition.ExpositionListCommand;
import com.maksim.controller.comand.redirect.RedirectRegistration;
import com.maksim.controller.comand.ticket.TicketPayCommand;
import com.maksim.controller.comand.user.LoginCommand;
import com.maksim.controller.comand.user.LogoutCommand;
import com.maksim.controller.comand.user.RegistrationCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by Максим on 03/May/18.
 */
public class RequestHelper {
    private static RequestHelper instance = null;

    //создание единственного объекта по шаблону Singleton
    public static RequestHelper getInstance() {

        if (instance == null) {
            instance = new RequestHelper();
        }
        return instance;
    }

    HashMap<String, Command> commands = new HashMap<String, Command>();

    private RequestHelper() {
        //заполнение таблицы командами
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("registration", new RegistrationCommand());


        commands.put("redirect", new RedirectRegistration());


        commands.put("allExpositions", new ExpositionListCommand());

        commands.put("basket", new BasketCommand());


        commands.put("payment", new TicketPayCommand());
    }

    public Command getCommand(HttpServletRequest request) {
//извлечение команды из запроса
        String action = request.getParameter("command");
//получение объекта, соответствующего команде
        Command command = commands.get(action);
        if (command == null) {
//если команды не существует в текущем объекте
            command = new NoCommand();
        }
        return command;
    }


}

