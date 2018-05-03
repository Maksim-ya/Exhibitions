package com.maksim.model.dao;

import com.maksim.domain.Ticket;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public interface TicketDao {
    List<Ticket> findTicketsByUser(int userId);
    boolean addTicket(Ticket ticket, Connection connection);
}
