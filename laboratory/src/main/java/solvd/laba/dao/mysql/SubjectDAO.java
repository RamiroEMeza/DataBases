package solvd.laba.dao.mysql;

import solvd.laba.dao.ISubjectDAO;
import solvd.laba.entities.test.subjects.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectDAO extends MySQLDAO implements ISubjectDAO {
    private final static String GET_SUBJECT_BY_RESEARCH_ID = "SELECT * FROM  test_subjects ts LEFT JOIN researchs r " +
            "ON r.id=ts.Researchs_id " +
            "WHERE r.id=?";

    @Override
    public Subject getEntityById(int id) throws InterruptedException, SQLException {
        return null;
    }

    @Override
    public ArrayList<Subject> getAllEntities() throws SQLException {
        return null;
    }

    @Override
    public void updateEntity(Subject entity) {

    }

    @Override
    public void createEntity(Subject entity) {

    }

    @Override
    public void removeEntity(int id) {

    }


    @Override
    public ArrayList<Subject> getEntitiesByResearchId(int id) {
        try (Connection c = MySQLDAO.getConnection();
             PreparedStatement ps = c.prepareStatement(GET_SUBJECT_BY_RESEARCH_ID)) {
            ResultSet resultSet = null;
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            ArrayList<Subject> result = new ArrayList<Subject>();
            while (resultSet.next()) {
                Subject entity = new Subject();
                entity.setSpecies(resultSet.getString("species"));
                entity.setAge(resultSet.getInt("age"));
                entity.setSex(resultSet.getInt("sex"));
                entity.setWeight(resultSet.getInt("weight"));
                result.add(entity);
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
