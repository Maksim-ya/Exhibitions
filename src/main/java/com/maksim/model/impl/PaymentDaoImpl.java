package com.maksim.model.impl;

import com.maksim.domain.Exposition;
import com.maksim.domain.Payment;
import com.maksim.domain.User;
import com.maksim.model.dao.PaymentDao;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public class PaymentDaoImpl implements PaymentDao {
    @Override
    public boolean addPayment(User user, List<Exposition> expositionList, BigDecimal totalPrice) {
        return false;
    }

    @Override
    public Payment findPaymentById(int paymentId) {
        return null;
    }

    @Override
    public void deletePayment(Payment payment) {

    }
}
