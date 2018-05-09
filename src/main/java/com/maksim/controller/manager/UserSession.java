package com.maksim.controller.manager;

import com.maksim.domain.Ticket;
import com.maksim.domain.User;
import com.maksim.model.impl.TicketDaoImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.maksim.controller.comand.Command.PARAM_IS_EXPOSITION;

/**
 * Created by Максим on 03/May/18.
 */
public class UserSession {
    private static final Logger logger = Logger.getLogger(UserSession.class);


    private static final String PARAM_USER = "user";
    private static final String PARAM_USERNAME = "name";
    private static final String PARAM_TICKETS = "listOfTickets";


    public static String loadUserDataToSession(HttpServletRequest request, User user) {
        logger.info(Logs.LOAD_USER_TO_SESSION);
        String page;
        HttpSession se = request.getSession(true);
        se.setAttribute(PARAM_USER, user);
        se.setAttribute(PARAM_USERNAME, user.getFullName());


        if (se.getAttribute(PARAM_IS_EXPOSITION) != null) {
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.BUY_PAGE_PATH);
        } else {
            TicketDaoImpl ticketDao= new TicketDaoImpl();
            List<Ticket> list = ticketDao.findTicketsByUser(user.getUserId());
//                for (int i = 0; i <list.size() ; i++) {
//                    System.out.println(list.get(i));
//                }
            request.setAttribute(PARAM_TICKETS, list);

            //определение пути к main.jsp
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.MAIN_PAGE_PATH);
        }
//        }
        return page;
    }
}
