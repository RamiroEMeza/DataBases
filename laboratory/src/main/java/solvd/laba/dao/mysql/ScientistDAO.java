package solvd.laba.dao.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.IScientistDAO;
import solvd.laba.entities.members.Scientist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScientistDAO extends MySQLDAO implements IScientistDAO {
    private final static Logger LOGGER = LogManager.getLogger(ScientistDAO.class);

    private final static String GET_SCIENTIST = "SELECT * FROM Scientists WHERE id=?";

    private final static String GET_SCIENTIST_BY_RESEARCH_ID = "SELECT * FROM  Scientists s LEFT JOIN Researchs r " +
            "ON s.id=r.Scientists_id " +
            "WHERE r.id=?";

    private final static String GET_ALL_SCIENTIST = "SELECT * FROM Scientists";
    private final static String CREATE_SCIENTIST = "INSERT INTO Scientists (name, lastname, nationality, age) " +
            "VALUES (?, ?, ?, ?)";
    private final static String UPDATE_SCIENTIST = "UPDATE Scientists SET (name=?, lastname=?, nationality=?, age=?) " +
            "WHERE id=?";
    private final static String DELETE_SCIENTIST = "DELETE FROM Scientists WHERE id=?";

    @Override
    public Scientist getEntityById(int id) {
        try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(GET_SCIENTIST)) {
            ResultSet resultSet = null;
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return new Scientist(resultSet.getString("name"), resultSet.getString("lastname")
                        , resultSet.getString("nationality"), resultSet.getInt("age"));
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Scientist> getAllEntities() {
        try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(GET_ALL_SCIENTIST)) {
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            ArrayList<Scientist> result = new ArrayList<Scientist>();
            while (resultSet.next()) {
                result.add(new Scientist(resultSet.getString("name")
                        , resultSet.getString("lastname")
                        , resultSet.getString("nationality")
                        , resultSet.getInt("age")
                        , resultSet.getInt("id")));
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(Scientist entity) {
        try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(UPDATE_SCIENTIST)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getNationality());
            ps.setInt(4, entity.getAge());
            ps.setInt(5, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createEntity(Scientist entity) {
        try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(CREATE_SCIENTIST)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getNationality());
            ps.setInt(4, entity.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeEntity(int id) {
        try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(DELETE_SCIENTIST)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Scientist getEntityByResearchId(int id) {
        try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(GET_SCIENTIST_BY_RESEARCH_ID)) {
            ResultSet resultSet = null;
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return new Scientist(resultSet.getString("name")
                        , resultSet.getString("lastname")
                        , resultSet.getString("nationality")
                        , resultSet.getInt("age")
                        , resultSet.getInt("id"));
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
