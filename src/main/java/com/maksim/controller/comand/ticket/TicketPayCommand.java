package com.maksim.controller.comand.ticket;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.MessageManager;
import com.maksim.controller.manager.UserSession;
import com.maksim.domain.Exposition;
import com.maksim.domain.Ticket;
import com.maksim.domain.User;
import com.maksim.model.impl.DaoFactoryImpl;
import com.maksim.service.TicketService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public class TicketPayCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        HttpSession se = request.getSession(true);
        User user = (User) se.getAttribute(PARAM_USER);
//        int expositionAllId = (Integer) se.getAttribute(PARAM_EXPOSITION_ALL_ID);
        List<Exposition> listOfUserExpositions = (List<Exposition>) se.getAttribute("listOfUserExpositions");
        BigDecimal totalPrice = new BigDecimal("0.0");

        List<Ticket> ticketList = new ArrayList<Ticket>();
//        Ticket ticket = new Ticket();
        for (int i = 0; i < listOfUserExpositions.size(); i++) {
            Ticket ticket = new Ticket();
            ticket.setUser(user);
            ticket.setExposition(listOfUserExpositions.get(i));
            int expositionId = listOfUserExpositions.get(i).getExpositionId();
            ticket.setNumberOfPersons(Integer.parseInt(request.getParameter("numberOfPersons" + expositionId)));
            ticket.setEventDate(LocalDate.parse(request.getParameter("eventDate" + expositionId)));
            ticketList.add(ticket);
//            se.setAttribute(PARAM_EXPOSITION + i, null);
//            se.setAttribute(PARAM_IS_EXPOSITION, null);

            totalPrice = totalPrice.add(DaoFactoryImpl.getInstance().getExpositionDao()
                    .findById(listOfUserExpositions.get(i).getExpositionId())
                    .getPrice().multiply(BigDecimal.valueOf(ticket.getNumberOfPersons())));
        }

        if (user.getAccount().compareTo(totalPrice) >= 0) {
            try {
                TicketService.getService().ticketTransaction(user, ticketList, totalPrice);
                se.setAttribute(LIST_OF_USER_EXPOSITIONS, null);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", MessageManager.getInstance().getMessage(MessageManager.SERVER_ERROR_MESSAGE));
                page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
            }
            page = UserSession.loadUserDataToSession(request, user);
        } else {
            request.setAttribute("paymentErrorMessage", MessageManager.getInstance().getMessage(MessageManager.PAYMENT_ERROR_MESSAGE));
            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
//            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.BUY_PAGE_PATH);
        }

        return page;
    }
}
