package com.maksim.controller.manager;

import java.util.ResourceBundle;

/**
 * Created by Максим on 03/May/18.
 */
public class ConfigurationManager {
    private static ConfigurationManager instance;
    private ResourceBundle resourceBundle;
    //    класс извлекает информацию из файла pages.properties
    private static final String BUNDLE_NAME = "pages";

    public static final String ERROR_PAGE_PATH = "ERROR_PAGE_PATH";
    public static final String LOGIN_PAGE_PATH = "LOGIN_PAGE_PATH";
    public static final String MAIN_PAGE_PATH = "MAIN_PAGE_PATH";
    public static final String REGISTRATION_PAGE_PATH = "REGISTRATION_PAGE_PATH";
    public static final String ALL_EXPOSITIONS_PAGE_PATH = "ALL_EXPOSITIONS_PAGE_PATH";
    public static final String BUY_PAGE_PATH = "BUY_PAGE_PATH";
    public static final String INDEX_PAGE_PATH = "INDEX_PAGE_PATH";
    public static final String REPLENISH_AN_ACCOUNT_PAGE_PATH = "REPLENISH_AN_ACCOUNT_PAGE_PATH";


    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getPage(String key) {
        return (String) resourceBundle.getObject(key);
    }
}
