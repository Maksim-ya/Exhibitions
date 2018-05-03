package com.maksim.domain;

import java.sql.Timestamp;

/**
 * Created by Максим on 03/May/18.
 */
public class Showroom {
    private int id;
    private String title;
    private String address;
    private Timestamp openingTime;
    private Timestamp closingTime;

    public Showroom() {
    }

    public Showroom(int id, String title, String address, Timestamp openingTime, Timestamp closingTime) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Showroom showroom = (Showroom) o;

        if (id != showroom.id) return false;
        if (title != null ? !title.equals(showroom.title) : showroom.title != null) return false;
        if (address != null ? !address.equals(showroom.address) : showroom.address != null) return false;
        if (openingTime != null ? !openingTime.equals(showroom.openingTime) : showroom.openingTime != null)
            return false;
        return closingTime != null ? closingTime.equals(showroom.closingTime) : showroom.closingTime == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (openingTime != null ? openingTime.hashCode() : 0);
        result = 31 * result + (closingTime != null ? closingTime.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Timestamp openingTime) {
        this.openingTime = openingTime;
    }

    public Timestamp getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Timestamp closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public String toString() {
        return "Showroom{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                '}';
    }
}
