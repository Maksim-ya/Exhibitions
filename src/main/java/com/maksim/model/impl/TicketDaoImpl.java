package com.maksim.model.impl;

import com.maksim.domain.Exposition;
import com.maksim.domain.Payment;
import com.maksim.domain.Ticket;
import com.maksim.domain.User;
import com.maksim.model.connection.DBConnection;
import com.maksim.model.dao.TicketDao;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public class TicketDaoImpl implements TicketDao {
    private static final Logger logger = Logger.getLogger(TicketDaoImpl.class);

    private final static TicketDaoImpl ticketDaoImpl = new TicketDaoImpl();

    public TicketDaoImpl() {
    }

    static TicketDaoImpl getInstance() {
        return ticketDaoImpl;
    }
    @Override
    public List<Ticket> findTicketsByUser(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM tickets WHERE userId = ?");
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            List<Ticket> list =  resultToList(resultSet);
            return list;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            DBConnection.close(connection, statement, resultSet);
        }
        return null;
    }
    private List<Ticket> resultToList(ResultSet resultSet) throws SQLException {
        List<Ticket> list = new ArrayList<Ticket>();
        while (resultSet.next()) {
            Ticket ticket= createTicketFromResult(resultSet);
            list.add(ticket);
        }
        return list;
    }

    private Ticket createTicketFromResult(ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst()) resultSet.next();

        int ticketId = resultSet.getInt(1);
        int userId = resultSet.getInt(2);
        int paymentId = resultSet.getInt(3);
        int expositionId = resultSet.getInt(4);
        int numberOfPersons = resultSet.getInt(5);
        LocalDate eventDate = LocalDate.parse(resultSet.getString(6));
        User user = new UserDaoImpl().getInstance().findUserById(userId);
        Payment payment = new PaymentDaoImpl().getInstance().findPaymentById(paymentId);
        Exposition exposition = new ExpositionDaoImpl().getInstance().findById(expositionId);
        return new Ticket(ticketId, user, payment,exposition,numberOfPersons,eventDate );
    }

    @Override
    public boolean addTicket(Ticket ticket) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection =  DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO tickets (paymentId, expositionId,numberOfPersons, eventDate) VALUES (?,?,?,?)");
            preparedStatement.setInt(1, ticket.getPayment().getPaymentId());
            preparedStatement.setInt(2, ticket.getExposition().getExpositionId());
            preparedStatement.setInt(3, ticket.getNumberOfPersons());
            preparedStatement.setString(4, ticket.getEventDate().toString());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            DBConnection.close(connection, preparedStatement);
        }
        return false;
    }
}
