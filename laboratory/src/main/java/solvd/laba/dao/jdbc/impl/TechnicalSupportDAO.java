package solvd.laba.dao.jdbc.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.ITechnicalSupport;
import solvd.laba.entities.facilities.Lab;
import solvd.laba.entities.members.TechnicalSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TechnicalSupportDAO extends MySQLDAO implements ITechnicalSupport {

    private final static Logger LOGGER = LogManager.getLogger(TechnicalSupportDAO.class);

    private final static String GET_TECHNICAL_SUP = "SELECT t.id, t.name, t.lastname " +
            "FROM Technical_Support t WHERE id=?";
    private final static String GET_ALL_TECHNICAL_SUP = "SELECT t.id, t.name, t.lastname FROM Technical_Support t";
    private final static String CREATE_TECHNICAL_SUP = "INSERT INTO Technical_Support (name, lastname) VALUES (?, ?)";
    private final static String UPDATE_TECHNICAL_SUP = "UPDATE Technical_Support SET (name=?, lastname=?) WHERE id=?";
    private final static String DELETE_TECHNICAL_SUP = "DELETE FROM Technical_Support WHERE id=?";

    @Override
    public TechnicalSupport getEntityById(int id) throws InterruptedException, SQLException {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(GET_TECHNICAL_SUP)) {
            ResultSet resultSet = null;
            ps.setInt(1, id);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return new TechnicalSupport(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"));
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<TechnicalSupport> getAllEntities() throws SQLException {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(GET_ALL_TECHNICAL_SUP)) {
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            ArrayList<TechnicalSupport> result = new ArrayList<TechnicalSupport>();
            while (resultSet.next()) {
                result.add(new TechnicalSupport(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname")));
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(TechnicalSupport entity) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(UPDATE_TECHNICAL_SUP)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLastName());
            ps.setInt(3, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createEntity(TechnicalSupport entity) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(CREATE_TECHNICAL_SUP)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLastName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeEntity(int id) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(DELETE_TECHNICAL_SUP)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
