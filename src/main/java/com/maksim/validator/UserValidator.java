package com.maksim.validator;

import com.maksim.domain.User;
import com.maksim.model.impl.DaoFactoryImpl;

public class UserValidator {
    public static boolean checkLogin(String login) {
        User user = DaoFactoryImpl.getInstance().getUserDao().findUserByLogin(login);
        if (user!=null) {
            return user.getLogin().equalsIgnoreCase(login) ? true : false;
        } return false;
    }

    public static boolean checkPassword(String login, String confirmPassword) {
        return login.equals(confirmPassword)? false: true;
    }

    public static boolean checkEmail(String address) {
        return address.matches(("^[_A-Za-z0-9-\\+]+@[_A-Za-z0-9.-]+\\.[A-Z]{2,6}$"));
    }
}