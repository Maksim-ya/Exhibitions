package com.maksim.model.impl;

import com.maksim.domain.User;
import com.maksim.model.connection.DBConnection;
import com.maksim.model.dao.UserDao;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public class UserDaoImpl implements UserDao {
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    private final static UserDaoImpl userDaoImpl = new UserDaoImpl();

    public UserDaoImpl() {
    }

    static UserDaoImpl getInstance() {
        return userDaoImpl;
    }
    @Override
    public boolean addUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection =  DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO users (login, password,fullName, address) VALUES (?,?,?,?)");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            DBConnection.close(connection, preparedStatement);
        }
        return false;
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
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM USERS WHERE USERID = ?");
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            return createUserFromResult(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            DBConnection.close(connection, statement, resultSet);
        }
        return null;
    }

    @Override
    public User checkLoginAndPassword(String login, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM USERS WHERE LOGIN = ? AND PASSWORD = ?");
            statement.setString(1, login);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            User user = createUserFromResult(resultSet);
            return user;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            DBConnection.close(connection, statement, resultSet);
        }
        return null;
    }

    private User createUserFromResult(ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst()) resultSet.next();

        int userId = resultSet.getInt(1);
        String login = resultSet.getString(2);
        String password = resultSet.getString(3);
        String fullName = resultSet.getString(4);
        String address = resultSet.getString(5);
        BigDecimal account = resultSet.getBigDecimal(6);
        return new User(userId, login, password, fullName, address, account);
    }

    public void updateUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(
                    "UPDATE USERS  SET LOGIN = ?, PASSWORD = ?, FULLNAME = ?, ADDRESS = ?, ACCOUNT= ? WHERE USERID = ? ");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setString(4, user.getAddress());
            statement.setBigDecimal(5, user.getAccount());
            statement.setInt(6, user.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            DBConnection.close(connection, statement, resultSet);
        }
    }
}
