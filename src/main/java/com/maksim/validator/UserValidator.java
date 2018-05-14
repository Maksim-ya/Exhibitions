package com.maksim.validator;

import com.maksim.model.impl.DaoFactoryImpl;

public class UserValidator {
    public static boolean checkLogin(String login) {
//        if (login!=null)
            if (DaoFactoryImpl.getInstance().getUserDao().findUserByLogin(login) != null)
                return (DaoFactoryImpl.getInstance().getUserDao().findUserByLogin(login).getLogin().equalsIgnoreCase(login) ? true : false);
        else  return false;
    }
}
