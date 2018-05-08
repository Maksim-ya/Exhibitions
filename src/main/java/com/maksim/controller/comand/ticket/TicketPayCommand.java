package com.maksim.controller.comand.ticket;

import com.maksim.controller.comand.Command;
import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.MessageManager;
import com.maksim.controller.manager.UserSession;
import com.maksim.domain.Exposition;
import com.maksim.domain.Ticket;
import com.maksim.domain.User;
import com.maksim.model.impl.PaymentDaoImpl;

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
        boolean paymentResult = false;
        HttpSession se = request.getSession(true);
        User user = (User) se.getAttribute(PARAM_USER);
        int expositionAllId = (Integer) se.getAttribute(PARAM_EXPOSITION_ALL_ID);
        BigDecimal totalPrice = new BigDecimal("0.0");

//        BigDecimal totalPrice = new BigDecimal(String.valueOf(se.getAttribute(PARAM_TOTAL_PRICE)));

        List<Ticket> ticketList = new ArrayList<Ticket>();
        for (int i = 1; i <= expositionAllId; i++) {
            Exposition exposition = (Exposition) se.getAttribute(PARAM_EXPOSITION + i);
            Ticket ticket = new Ticket();
            if (exposition != null) {
//                    expositionList.add(exposition);
                ticket.setUser(user);
                ticket.setExposition(exposition);
                ticket.setNumberOfPersons(Integer.parseInt(request.getParameter("numberOfPersons" + i)));
                ticket.setEventDate(LocalDate.parse(request.getParameter("eventDate" + i)));
                ticketList.add(ticket);
                se.setAttribute(PARAM_EXPOSITION + i, null);
                se.setAttribute(PARAM_IS_EXPOSITION, null);


                totalPrice = totalPrice.add(exposition.getPrice().multiply(BigDecimal.valueOf(ticket.getNumberOfPersons())));

            }
        }


        System.out.println(totalPrice);


            if (user.getAccount().compareTo(totalPrice) >= 0) {

//            BigDecimal priceUpdate = user.getAccount().subtract(totalPrice);
//            user.setAccount(priceUpdate);
//            new UserDaoImpl().updateUser(user);
//            Subscription subscription = new Subscription();
//            SubscriptionDaoImpl subscriptionDao = new SubscriptionDaoImpl();
//            Payment payment= new Payment();
//            PaymentDaoImpl paymentDao = new PaymentDaoImpl();

//                payment.setTotalPrice(totalPrice);

                try {
                    paymentResult = new PaymentDaoImpl().addPayment(user, ticketList, totalPrice);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (paymentResult == true)
                    page = UserSession.loadUserDataToSession(request, user);
                else {
                    request.setAttribute("errorMessage", MessageManager.getInstance().getMessage(MessageManager.SERVER_ERROR_MESSAGE));
                    page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
                }
            }


//         java.util.Enumeration  cats = request.getAttributeNames();
//        List<Object> list =  java.util.Collections.list(cats);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }


//        if(user.getAccount().compareTo(price) ==1 ){
//        if (true) {
//
//            SubscriptionDaoImpl subscriptionDao = new SubscriptionDaoImpl();

//
//            subscriptionDao.addSubscription(subscription);
//
//            List<Subscription> list =  subscriptionDao.findSubscriptionsByUser(user.getUserId());
//            request.setAttribute("listOfSubscriptions", list);
//
//            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.MAIN_PAGE_PATH);


//            subscription.setPublication(publication);

//            publisher.setMoney(publisher.getMoney().add(cost));
//            subscriber.setMoney(subscriber.getMoney().subtract(cost));
//
//            subscription.setUpdated(false);
//            subscription.setLastAvailableEntryDate(LocalDateTime.now());
//            subscriptionDao.update(subscription);
//        }
            else {
                request.setAttribute("errorMessage", MessageManager.getInstance().getMessage(MessageManager.PAYMENT_ERROR_MESSAGE));
                page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
            }

            return page;
        }
    }
