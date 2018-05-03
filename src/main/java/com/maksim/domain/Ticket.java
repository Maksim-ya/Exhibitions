package com.maksim.domain;

import java.sql.Timestamp;

/**
 * Created by Максим on 03/May/18.
 */
public class Ticket {
    private int id;
    private Payment payment;
    private Exposition exposition;
    private Timestamp eventDate;

    public Ticket() {
    }

    public Ticket(int id, Payment payment, Exposition exposition, Timestamp eventDate) {
        this.id = id;
        this.payment = payment;
        this.exposition = exposition;
        this.eventDate = eventDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (payment != null ? !payment.equals(ticket.payment) : ticket.payment != null) return false;
        if (exposition != null ? !exposition.equals(ticket.exposition) : ticket.exposition != null) return false;
        return eventDate != null ? eventDate.equals(ticket.eventDate) : ticket.eventDate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + (exposition != null ? exposition.hashCode() : 0);
        result = 31 * result + (eventDate != null ? eventDate.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Exposition getExposition() {
        return exposition;
    }

    public void setExposition(Exposition exposition) {
        this.exposition = exposition;
    }

    public Timestamp getEventDate() {
        return eventDate;
    }

    public void setEventDate(Timestamp eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", payment=" + payment +
                ", exposition=" + exposition +
                ", eventDate=" + eventDate +
                '}';
    }
}
