package solvd.laba.dao.jdbc.impl;

import solvd.laba.dao.ISubjectDAO;
import solvd.laba.entities.facilities.Lab;
import solvd.laba.entities.research.Research;
import solvd.laba.entities.test.subjects.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectDAO extends MySQLDAO implements ISubjectDAO {
    private final static String GET_SUBJECT_BY_RESEARCH_ID = "SELECT t.id, t.species, t.age, t.sex, t.weight, t.Researchs_id" +
            " FROM  Test_Subjects ts LEFT JOIN Researchs r " +
            "ON r.id=ts.Researchs_id " +
            "WHERE r.id=?";

    private final static String GET_SUBJECT = "SELECT t.id, t.species, t.age, t.sex, t.weight, t.Researchs_id " +
            "FROM Test_Subjects t WHERE id=?";

    private final static String GET_ALL_SUBJECTS = "SELECT t.id, t.species, t.age, t.sex, t.weight, t.Researchs_id" +
            " FROM Test_Subjects";

    private final static String CREATE_SUBJECT_WITHOUT_RESEARCH = "INSERT INTO Test_Subjects " +
            "(species, age, sex, weight)" +
            " VALUES (?, ?, ?, ?)";

    private final static String CREATE_SUBJECT_WITH_RESEARCH = "INSERT INTO Test_Subjects " +
            "(species, age, sex, weight, Research_id)" +
            " VALUES (?, ?, ?, ?, ?)";

    private final static String UPDATE_SUBJECT_WITHOUT_RESEARCH = "UPDATE Test_Subjects SET " +
            "(species=?, age=?, sex=?, weight=?) " +
            "WHERE id=?";

    private final static String UPDATE_SUBJECT_WITH_RESEARCH = "UPDATE Test_Subjects SET " +
            "(species=?, age=?, sex=?, weight=?, Rersearchs_id=?) " +
            "WHERE id=?";

    private final static String DELETE_SUBJECT = "DELETE FROM Test_Subjects WHERE id=?";

    @Override
    public Subject getEntityById(int id) throws InterruptedException, SQLException {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(GET_SUBJECT)) {
            ResultSet resultSet = null;
            ps.setInt(1, id);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return new Subject(resultSet.getString("species"),
                        resultSet.getInt("age"),
                        (resultSet.getInt("sex") == 1),
                        resultSet.getInt("weight"));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Subject> getEntitiesByResearchId(int id) {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(GET_SUBJECT_BY_RESEARCH_ID)) {
            ResultSet resultSet = null;
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            ArrayList<Subject> result = new ArrayList<Subject>();
            while (resultSet.next()) {
                Subject entity = new Subject();
                entity.setSpecies(resultSet.getString("species"));
                entity.setAge(resultSet.getInt("age"));
                entity.setSex((resultSet.getInt("sex")) == 1);
                entity.setWeight(resultSet.getInt("weight"));
                result.add(entity);
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Subject> getAllEntities() throws SQLException {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(GET_ALL_SUBJECTS)) {
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            ArrayList<Subject> result = new ArrayList<Subject>();
            while (resultSet.next()) {
                result.add(new Subject(resultSet.getString("species"),
                        resultSet.getInt("age"),
                        (resultSet.getInt("sex") == 1),
                        resultSet.getInt("weight")));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(Subject entity) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(UPDATE_SUBJECT_WITHOUT_RESEARCH)) {
            ps.setString(1, entity.getSpecies());
            ps.setInt(2, entity.getAge());
            ps.setInt(3, entity.getSex());
            ps.setInt(4, (int) entity.getWeight());
            ps.setInt(5, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createEntity(Subject entity) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(CREATE_SUBJECT_WITHOUT_RESEARCH)) {
            ps.setString(1, entity.getSpecies());
            ps.setInt(2, entity.getAge());
            ps.setInt(3, entity.getSex());
            ps.setInt(4, (int) entity.getWeight());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createEntitySetingResearch(Subject entity, Research assignedResearch) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(CREATE_SUBJECT_WITH_RESEARCH)) {
            ps.setString(1, entity.getSpecies());
            ps.setInt(2, entity.getAge());
            ps.setInt(3, entity.getSex());
            ps.setInt(4, (int) entity.getWeight());
            ps.setInt(3, assignedResearch.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntitySetingResearch(Subject entity, Research assignedResearch) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(UPDATE_SUBJECT_WITH_RESEARCH)) {
            ps.setString(1, entity.getSpecies());
            ps.setInt(2, entity.getAge());
            ps.setInt(3, entity.getSex());
            ps.setInt(4, (int) entity.getWeight());
            ps.setInt(6, assignedResearch.getId());
            ps.setInt(6, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeEntity(int id) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(DELETE_SUBJECT)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
