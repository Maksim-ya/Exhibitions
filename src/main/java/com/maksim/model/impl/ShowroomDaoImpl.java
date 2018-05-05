package com.maksim.model.impl;

import com.maksim.domain.Exposition;
import com.maksim.domain.Showroom;
import com.maksim.model.connection.DBConnection;
import com.maksim.model.dao.ShowroomDao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by Максим on 03/May/18.
 */
public class ShowroomDaoImpl implements ShowroomDao {

    @Override
    public Showroom findById(int showroomId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement(
                    "SELECT * FROM showrooms WHERE showroomId = ?");
            statement.setInt(1,showroomId);
            resultSet = statement.executeQuery();
            return createShowroomFromResult(resultSet);
        } catch (SQLException e) {
//            LOGGER.error(e.getMessage());
        } finally {
            DBConnection.close(connection, statement, resultSet);
        }
        return null;
    }

    private Showroom createShowroomFromResult(ResultSet resultSet) throws SQLException {
        if (resultSet.isBeforeFirst()) resultSet.next();

        int showroomId = resultSet.getInt(1);
        String showroomTitle = resultSet.getString(2);
        String showroomAddress = resultSet.getString(3);
        LocalTime openingTime = LocalTime.parse(resultSet.getString(4));
        LocalTime closingTime = LocalTime.parse(resultSet.getString(5));
        return new Showroom(showroomId, showroomTitle, showroomAddress, openingTime,closingTime);
    }
}
