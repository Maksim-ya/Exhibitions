package com.maksim.model.impl;

import com.maksim.domain.Exposition;
import com.maksim.domain.Payment;
import com.maksim.domain.Ticket;
import com.maksim.domain.User;
import com.maksim.model.connection.DBConnection;
import com.maksim.model.dao.PaymentDao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public class PaymentDaoImpl implements PaymentDao {
    @Override
    public boolean addPayment(User user, List<Exposition> expositionList, BigDecimal totalPrice) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Payment payment = new Payment();
        int userId;
        try {
            connection = DBConnection.getConnection();
//            connection.setTransactionIsolation(1);
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO payments (userId, totalPrice, dateTime) VALUES (?,?,?)");
            userId = user.getUserId();
            preparedStatement.setInt(1, userId);
//            BigDecimal totalPrice = payment.getTotalPrice();
            preparedStatement.setBigDecimal(2, totalPrice);
            Date date = new Date();
            Timestamp dateTime = new Timestamp(date.getTime());
            System.out.println(dateTime);
            dateTime.setNanos(0);
            System.out.println(dateTime);
            preparedStatement.setTimestamp(3, dateTime);
            preparedStatement.executeUpdate();
//            connection.commit();
//            System.out.println(dateTime.getNanos());
//            if (dateTime.getNanos()>499999999)
//                dateTime.setNanos(0);
//            else {dateTime.setSeconds(dateTime.getSeconds()+1);}

            payment = new PaymentDaoImpl().findPaymentByPaymentInfo(userId, totalPrice, dateTime);
//             payment=new PaymentDaoImpl().exper(1);

            System.out.println(payment);

//        try {
//            connection =  DBConnection.getConnection();
//            connection.setAutoCommit(false);
            connection.setAutoCommit(false);
            for (int i = 0; i < expositionList.size(); i++) {
                Ticket ticket = new Ticket();
                ticket.setPayment(payment);
                ticket.setExposition(expositionList.get(i));
//                new SubscriptionDaoImpl().addSubscription(ticket);
                preparedStatement = connection.prepareStatement(
                        "INSERT INTO tickets (paymentId,expositionId,eventDate) VALUES (?,?,?)");
                preparedStatement.setInt(1, ticket.getPayment().getPaymentId());
                preparedStatement.setInt(2, ticket.getExposition().getExpositionId());
                preparedStatement.setTimestamp(3, ticket.getEventDate());
                preparedStatement.executeUpdate();
            }
            BigDecimal priceUpdate = user.getAccount().subtract(totalPrice);
            user.setAccount(priceUpdate);
//            new UserDaoImpl().updateUser(user);
            preparedStatement = connection.prepareStatement(
                    "UPDATE USERS  SET LOGIN = ?, PASSWORD = ?, FULLNAME = ?, ADDRESS = ?, ACCOUNT= ? WHERE USERID = ? ");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setBigDecimal(5, user.getAccount());
            preparedStatement.setInt(6, user.getUserId());
            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
//            System.out.println("eeeeeeerrrr");
            new PaymentDaoImpl().deletePayment(payment);
            return false;

        } finally {
            DBConnection.close(connection, preparedStatement);
        }
    }

    public Payment findPaymentByPaymentInfo(int userId, BigDecimal totalPrice, Timestamp dateTime) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM PAYMENTS WHERE USERID = ? AND TOTALPRICE=? AND DATETIME =?");
            preparedStatement.setInt(1, userId);
            preparedStatement.setBigDecimal(2, totalPrice);
            preparedStatement.setTimestamp(3, dateTime);
            resultSet = preparedStatement.executeQuery();
            return createPaymentFromResult(resultSet);
        } catch (SQLException e) {
//            LOGGER.error(e.getMessage());
        } finally {
            DBConnection.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public Payment findPaymentById(int paymentId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM PAYMENTS WHERE PAYMENTID = ?");
            preparedStatement.setInt(1, paymentId);
            resultSet = preparedStatement.executeQuery();
            return createPaymentFromResult(resultSet);
        } catch (SQLException e) {
//            LOGGER.error(e.getMessage());
        } finally {
            DBConnection.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public void deletePayment(Payment payment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM payments WHERE paymentId=?");
            preparedStatement.setInt(1, payment.getPaymentId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        } finally {
            DBConnection.close(connection, preparedStatement);
        }
    }
    private Payment createPaymentFromResult(ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst()) resultSet.next();

        int paymentId = resultSet.getInt(1);
        int userId = resultSet.getInt(2);
        User user = new UserDaoImpl().findUserById(userId);
        BigDecimal totalPrice = resultSet.getBigDecimal(3);
        Timestamp dateTime = resultSet.getTimestamp(4);
        Payment payment = new Payment(paymentId, user, totalPrice, dateTime);
//        System.out.println(payment);
        return payment;
    }
}
