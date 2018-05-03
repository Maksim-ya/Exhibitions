package com.maksim.controller.manager;

import java.util.ResourceBundle;

/**
 * Created by Максим on 03/May/18.
 */
public class MessageManager {
    private static MessageManager instance;
    private ResourceBundle resourceBundle;
    //класс извлекает информацию из файла messages. properties
    private static final String BUNDLE_NAME = "messages";
    public static final String LOGIN_ERROR_MESSAGE = "LOGIN_ERROR_MESSAGE";
    public static final String PAYMENT_ERROR_MESSAGE = "PAYMENT_ERROR_MESSAGE";
    public static final String SERVLET_EXCEPTION_ERROR_MESSAGE = "SERVLET_EXCEPTION_ERROR_MESSAGE";
    public static final String IO_EXCEPTION_ERROR_MESSAGE = "IO_EXCEPTION_ERROR_MESSAGE";
    public static final String SUCCESS_LOGOUT_MESSAGE = "SUCCESS_LOGOUT_MESSAGE";
    public static final String SUCCESS_REGISTRATION_MESSAGE = "SUCCESS_REGISTRATION_MESSAGE";
    public static final String SERVER_ERROR_MESSAGE = "SERVER_ERROR_MESSAGE";


    public static MessageManager getInstance() {

        if (instance == null) {
            instance = new MessageManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getMessage(String key) {
        return (String) resourceBundle.getObject(key);
    }
}
