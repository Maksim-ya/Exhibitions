package com.maksim.model.dao;

import com.maksim.domain.Exposition;
import com.maksim.domain.Payment;
import com.maksim.domain.Ticket;
import com.maksim.domain.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public interface PaymentDao {
    boolean addPayment(User user, List<Ticket> ticketList, BigDecimal totalPrice);

    Payment findPaymentById(int paymentId);

    void deletePayment(Payment payment);
}
