package com.maksim.model.dao;

import com.maksim.domain.Showroom;

import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public interface ShowroomDao {
    List<Integer> findAllId();
    List<Showroom> findAll();
    Showroom findById(int id);
    Showroom findByTitle(String title);
    boolean addShowroom(Showroom showroom);
}
