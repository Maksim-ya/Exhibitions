package com.maksim.model.impl;

import com.maksim.domain.User;
import com.maksim.model.dao.UserDao;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public void updateUser(User user, Connection connection) {

    }

    @Override
    public void removeUser(int id) {

    }

    @Override
    public User findUserByLogin(String UserName) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public User findUserById(int userId) {
        return null;
    }

    @Override
    public User checkLoginAndPassword(String login, String password) {
        return null;
    }
}
