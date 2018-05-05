package com.maksim.model.impl;

import com.maksim.domain.Exposition;
import com.maksim.domain.Showroom;
import com.maksim.model.connection.DBConnection;
import com.maksim.model.dao.ExpositionDao;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public class ExpositionDaoImpl implements ExpositionDao {

    private final static ExpositionDaoImpl expositionDaoImpl = new ExpositionDaoImpl();

    public ExpositionDaoImpl() {
    }

    static ExpositionDaoImpl getInstance() {
        return expositionDaoImpl;
    }

    @Override
    public List<Integer> findAllId() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(
                    "SELECT expositionId FROM expositions");
            resultSet = statement.executeQuery();
            return resultToListId(resultSet);
        } catch (SQLException e) {
//            LOGGER.error(e.getMessage());
        } finally {
            DBConnection.close(connection, statement, resultSet);
        }
        return null;
    }

    @Override
    public List<Exposition> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM expositions");
            resultSet = statement.executeQuery();
            return resultToList(resultSet);
        } catch (SQLException e) {
//            LOGGER.error(e.getMessage());
        } finally {
            DBConnection.close(connection, statement, resultSet);
        }
        return null;
    }

    @Override
    public Exposition findById(int expositionId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM expositions WHERE expositionId = ?");
            statement.setInt(1,expositionId);
            resultSet = statement.executeQuery();
            return createExpositionFromResult(resultSet);
        } catch (SQLException e) {
//            LOGGER.error(e.getMessage());
        } finally {
            DBConnection.close(connection, statement, resultSet);
        }
        return null;
    }

    @Override
    public Exposition findByTitle(String title) {
        return null;
    }

    @Override
    public boolean addExposition(Exposition exposition) {
        return false;
    }

    private List<Integer> resultToListId(ResultSet resultSet) throws SQLException {
        List<Integer> list = new ArrayList<Integer>();
        while (resultSet.next()) {
            int publicationId = createIdFromResult(resultSet);
            list.add(publicationId);
        }
        return list;
    }
    private Integer createIdFromResult(ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst()) resultSet.next();

        int publicationId = resultSet.getInt(1);
        return publicationId;
    }
    private List<Exposition> resultToList(ResultSet resultSet) throws SQLException {
        List<Exposition> list = new ArrayList<Exposition>();
        while (resultSet.next()) {
            Exposition exposition = createExpositionFromResult(resultSet);
            list.add(exposition);
        }
        return list;
    }
    private Exposition createExpositionFromResult(ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst()) resultSet.next();

        int expositionId = resultSet.getInt(1);
        String expositionTitle = resultSet.getString(2);
        BigDecimal expositionPrice = resultSet.getBigDecimal(3);
        String topic = resultSet.getString(4);
        int showroomId = resultSet.getInt(5);
        LocalDate startDate = LocalDate.parse(resultSet.getString(6));
        LocalDate finishDate = LocalDate.parse(resultSet.getString(7));
        Showroom showroom = new ShowroomDaoImpl().getInstance().findById(showroomId);
        return new Exposition (expositionId, expositionTitle, expositionPrice, topic, showroom, startDate,finishDate);
    }
}
