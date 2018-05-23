package com.maksim.model.service;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class UserServiceTest {
    @Test
    public void encryptPassword(){
        UserService userService = UserService.getService().getService();
        String password= new String("helloworld");
        password = userService.encryptPassword(password);
        String password2 =new String("helloworld");
        password2= userService.encryptPassword(password2);

        Assert.assertEquals(password,password2);
    }
}
