package com.maksim.service;

import com.maksim.controller.manager.ConfigurationManager;
import com.maksim.controller.manager.MessageManager;
import com.maksim.controller.manager.UserSession;
import com.maksim.domain.Exposition;
import com.maksim.domain.Ticket;
import com.maksim.domain.User;
import com.maksim.model.connection.DBConnection;
import com.maksim.model.impl.DaoFactoryImpl;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Максим on 12/May/18.
 */
public class TicketService {
    private static final Logger logger = Logger.getLogger(TicketService.class);
    private static final TicketService TICKET_SERVICE = new TicketService();

    private TicketService() {}

    public static TicketService getService() {
        return TICKET_SERVICE;
    }

    public boolean ticketTransaction(User user, List<Ticket> ticketList, BigDecimal totalPrice) throws SQLException {
        Connection connection = DBConnection.getConnection();
        Ticket ticket;
        try {
            connection.setAutoCommit(false);
            int paymentId = DaoFactoryImpl.getInstance().getPaymentDao().addPayment(user, ticketList, totalPrice);

            for (int i = 0; i < ticketList.size(); i++) {
                ticket = ticketList.get(i);
                ticket.setPayment(DaoFactoryImpl.getInstance().getPaymentDao().findPaymentById(paymentId));
                DaoFactoryImpl.getInstance().getTicketDao().addTicket(ticket);
            }
            BigDecimal priceUpdate = user.getAccount().subtract(totalPrice);
            user.setAccount(priceUpdate);
            DaoFactoryImpl.getInstance().getUserDao().updateUser(user);
            connection.commit();
            return  true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            connection.rollback();
        }

//        if (paymentResult == true)
//            page = UserSession.loadUserDataToSession(request, user);
//        else {
//            request.setAttribute("errorMessage", MessageManager.getInstance().getMessage(MessageManager.SERVER_ERROR_MESSAGE));
//            page = ConfigurationManager.getInstance().getPage(ConfigurationManager.ERROR_PAGE_PATH);
//        }
        return false;
    }
}
