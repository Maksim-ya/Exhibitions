package com.maksim.model.impl;

import com.maksim.domain.Ticket;
import com.maksim.model.dao.TicketDao;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public class TicketDaoImpl implements TicketDao {
    @Override
    public List<Ticket> findTicketsByUser(int userId) {
        return null;
    }

    @Override
    public boolean addTicket(Ticket ticket, Connection connection) {
        return false;
    }
}
