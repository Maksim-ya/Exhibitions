package com.maksim.service;

import com.maksim.controller.manager.Logs;
import com.maksim.domain.User;
import com.maksim.model.dao.UserDao;
import com.maksim.model.impl.DaoFactoryImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class);
    private static final UserDao userDao = DaoFactoryImpl.getInstance().getUserDao();
    private static final UserService USER_SERVICE = new UserService();

    private UserService() {}

    public static UserService getService() {
        return USER_SERVICE;
    }

    public static String md5Apache(String st) {
        String md5Hex = DigestUtils.md5Hex(st);

        return md5Hex;
    }

    public boolean addUser(User user) {
        logger.info(Logs.USER_REGISTER);
        user.setPassword(md5Apache(user.getPassword()));
        return userDao.addUser(user);
    }

    public User checkLoginAndPassword(String login, String password) {
        return  userDao.checkLoginAndPassword(login,md5Apache(password));
    }
}
