package solvd.laba.dao.jdbc.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.ILabDAO;
import solvd.laba.entities.facilities.Lab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LabDAO extends MySQLDAO implements ILabDAO {
    private final static Logger LOGGER = LogManager.getLogger(LabDAO.class);

    private final static String GET_LAB = "SELECT l.id, l.capacity, l.complexity " +
            "FROM Labs l WHERE id=?";
    private final static String GET_LAB_BY_RESEARCH_ID = "SELECT l.id, l.capacity, l.complexity FROM  Labs l LEFT JOIN Researchs r " +
            "ON l.id=r.Labs_id " +
            "WHERE r.id=?";
    private final static String GET_ALL_LAB = "SELECT l.id, l.capacity, l.complexity FROM Labs l";
    private final static String CREATE_LAB = "INSERT INTO Labs (capacity, complexity) VALUES (?, ?)";
    private final static String UPDATE_LAB = "UPDATE Labs SET (capacity=?, complexity=?) WHERE id=?";
    private final static String DELETE_LAB = "DELETE FROM Labs WHERE id=?";

    @Override
    public Lab getEntityById(int id) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(GET_LAB)) {
            ResultSet resultSet = null;
            ps.setInt(1, id);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return new Lab(resultSet.getInt("id"),
                        resultSet.getInt("capacity"),
                        resultSet.getInt("complexity"));
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Lab> getAllEntities() {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(GET_ALL_LAB)) {
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            ArrayList<Lab> result = new ArrayList<Lab>();
            while (resultSet.next()) {
                result.add(new Lab(resultSet.getInt("id"),
                        resultSet.getInt("capacity"),
                        resultSet.getInt("complexity")));
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(Lab entity) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(UPDATE_LAB)) {
            ps.setInt(1, entity.getCapacity());
            ps.setInt(2, entity.getComplexity());
            ps.setInt(3, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createEntity(Lab entity) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(CREATE_LAB)) {
            ps.setInt(1, entity.getCapacity());
            ps.setInt(2, entity.getComplexity());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeEntity(int id) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(DELETE_LAB)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Lab getEntityByResearchId(int id) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(GET_LAB_BY_RESEARCH_ID)) {
            ResultSet resultSet = null;
            ps.setInt(1, id);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return new Lab(resultSet.getInt("id"),
                        resultSet.getInt("capacity"),
                        resultSet.getInt("complexity"));
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
