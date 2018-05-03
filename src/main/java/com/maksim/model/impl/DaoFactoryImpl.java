package com.maksim.model.impl;

import com.maksim.model.dao.DaoFactory;
import com.maksim.model.dao.ExpositionDao;
import com.maksim.model.dao.TicketDao;
import com.maksim.model.dao.UserDao;

/**
 * Created by Максим on 03/May/18.
 */
public class DaoFactoryImpl implements DaoFactory {
    private static final DaoFactoryImpl FACTORY = new DaoFactoryImpl();

    public DaoFactoryImpl() {
    }
    public static DaoFactoryImpl getInstance() {
        return FACTORY;
    }

    @Override
    public UserDao getUserDao() {
        return null;
    }

    @Override
    public ExpositionDao getExpositionDao() {
        return null;
    }

    @Override
    public TicketDao getTicketDao() {
        return null;
    }
}
