package com.maksim.controller.manager;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Максим on 03/May/18.
 */
public class MessageManager {
    private static MessageManager instance;
//    private ResourceBundle resourceBundle;
    //класс извлекает информацию из файла messages. properties
    private static final String BUNDLE_NAME = "messages";
    public static final String LOGIN_ERROR_MESSAGE = "LOGIN_ERROR_MESSAGE";
    public static final String LOGIN_NOT_UNIQUE_MESSAGE = "LOGIN_NOT_UNIQUE_MESSAGE";
    public static final String PAYMENT_ERROR_MESSAGE = "PAYMENT_ERROR_MESSAGE";
    public static final String SERVLET_EXCEPTION_ERROR_MESSAGE = "SERVLET_EXCEPTION_ERROR_MESSAGE";
    public static final String IO_EXCEPTION_ERROR_MESSAGE = "IO_EXCEPTION_ERROR_MESSAGE";
    public static final String SUCCESS_LOGOUT_MESSAGE = "SUCCESS_LOGOUT_MESSAGE";
    public static final String SUCCESS_REGISTRATION_MESSAGE = "SUCCESS_REGISTRATION_MESSAGE";
    public static final String SERVER_ERROR_MESSAGE = "SERVER_ERROR_MESSAGE";
    public static final String REQUIRED_FIELD_MESSAGE = "REQUIRED_FIELD_MESSAGE";
    public static final String PASSWORDS_DO_NOT_MATCH_ERROR_MESSAGE = "PASSWORDS_DO_NOT_MATCH_ERROR_MESSAGE";
    public static final String INVALID_EMAIL_ERROR_MESSAGE = "INVALID_EMAIL_ERROR_MESSAGE";
    public static final String REPLENISH_AN_ACCOUNT = "REPLENISH_AN_ACCOUNT";
    public static final String BACK_TO_BASKET = "BACK_TO_BASKET";
    public static final String SUCCESS_REPLENISH_MESSAGE = "SUCCESS_REPLENISH_MESSAGE";
    public static final String TO_LOGIN_PAGE = "TO_LOGIN_PAGE";



    public static final String BUY = "BUY";
    public static final String VIEW_ALL_TOPICS = "VIEW_ALL_TOPICS";

    public static final Locale RUSSIAN = new Locale("ru");
    public static final Locale ENGLISH  = new Locale("en");

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
    public static void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
    }

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
