package solvd.laba.dao.jdbc.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.IAssistantDAO;
import solvd.laba.entities.members.Assistant;
import solvd.laba.entities.members.Scientist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AssistantDAO extends MySQLDAO implements IAssistantDAO {
    private final static Logger LOGGER = LogManager.getLogger(AssistantDAO.class);

    private final static String GET_ASSISTANT = "SELECT a.id, a.name, a.lastname, a.nationality, a.age " +
            "FROM Assistants a WHERE id=?";

    private final static String GET_ALL_ASSISTANT = "SELECT a.id, a.name, a.lastname, a.nationality, a.age" +
            " FROM Assistants a";

    private final static String GET_ALL_ASSISTANT_BY_SCIENTIST_ID = "SELECT a.id, a.name, a.lastname, a.nationality, a.age" +
            " FROM Assistants a WHERE Scientists_id=?";


    private final static String CREATE_ASSISTANT = "INSERT INTO Assistants " +
            "(name, lastname, nationality, age, Scientists_id) " + "VALUES (?, ?, ?, ?, ?)";

    private final static String UPDATE_ASSISTANT = "UPDATE Assistants SET " +
            "(name=?, lastname=?, nationality=?, age=?, Scientists_id=?) " + "WHERE id=?";

    private final static String UPDATE_ASSISTANT_WITHOUT_SCIENTIST = "UPDATE Assistants SET " +
            "(name=?, lastname=?, nationality=?, age=?) " + "WHERE id=?";

    private final static String DELETE_ASSISTANT = "DELETE FROM Assistants WHERE id=?";

    @Override
    public Assistant getEntityById(int id) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(GET_ASSISTANT)) {
            ResultSet resultSet = null;
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return new Assistant(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getString("nationality"),
                        resultSet.getInt("age"));
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Assistant> getAllEntities() {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(GET_ALL_ASSISTANT)) {
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            ArrayList<Assistant> result = new ArrayList<Assistant>();
            while (resultSet.next()) {
                Assistant entity = new Assistant(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getString("nationality"),
                        resultSet.getInt("age"));
                result.add(entity);
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Assistant> getEntityByScientistId(int id) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(GET_ALL_ASSISTANT_BY_SCIENTIST_ID)) {
            ResultSet resultSet = null;
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            ArrayList<Assistant> result = new ArrayList<Assistant>();
            while (resultSet.next()) {
                Assistant entity = new Assistant(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getString("nationality"),
                        resultSet.getInt("age"));
                result.add(entity);
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(Assistant entity) {
        if (entity.getId() > 0) {
            try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(UPDATE_ASSISTANT_WITHOUT_SCIENTIST)) {
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
    }

    @Override
    public void updateEntity(Assistant entity, Scientist assignedScientist) {
        if (entity.getId() > 0) {
            try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(UPDATE_ASSISTANT)) {
                ps.setString(1, entity.getName());
                ps.setString(2, entity.getLastName());
                ps.setString(3, entity.getNationality());
                ps.setInt(4, entity.getAge());
                ps.setInt(5, assignedScientist.getId());
                ps.setInt(6, entity.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void createEntity(Assistant entity) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(CREATE_ASSISTANT)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getNationality());
            ps.setInt(4, entity.getAge());
            ps.setInt(5, 0);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createEntity(Assistant entity, Scientist assignedScientist) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(CREATE_ASSISTANT)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getNationality());
            ps.setInt(4, entity.getAge());
            ps.setInt(5, assignedScientist.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeEntity(int id) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(DELETE_ASSISTANT)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
