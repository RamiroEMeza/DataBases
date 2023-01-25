package solvd.laba.dao.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.IResearchDAO;
import solvd.laba.entities.facilities.Lab;
import solvd.laba.entities.members.Scientist;
import solvd.laba.entities.research.Research;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ResearchDAO extends MySQLDAO implements IResearchDAO {
    private final static Logger LOGGER = LogManager.getLogger(ResearchDAO.class);

    private final static String GET_RESEARCH = "SELECT * FROM researchs WHERE id=?";
    private final static String GET_RESEARCH_COMPLETE = "SELECT * FROM researchs r LEFT JOIN scientists s " +
            "ON r.Scientists_id=s.id " +
            "LEFT JOIN labs l" +
            "ON r.Labs_id=l.id";
    private final static String GET_ALL_RESEARCH = "SELECT * FROM researchs";
    private final static String CREATE_RESEARCH = "INSERT INTO researchs " +
            "(name, start, budget, complete, lab, scientist) " + "VALUES (?, ?, ?, ?, ?, ?)";

    private final static String UPDATE_RESEARCH = "UPDATE researchs SET " +
            "(name=?, start=?, budget=?, complete=?, lab=?, scientist=?) " + "WHERE id=?";

    private final static String DELETE_RESEARCH = "DELETE FROM researchs WHERE id=?";

    @Override
    public Research getEntityById(int id) {
        try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(GET_RESEARCH)) {
            ResultSet resultSet = null;
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                Research response = new Research();
                response.setId(resultSet.getInt("id"));
                response.setName(resultSet.getString("name"));
                response.setStart(LocalDate.parse(resultSet.getString("start")));
                response.setBudget(resultSet.getInt("budget"));
                response.setComplete((resultSet.getInt("complete") == 1));
                return response;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Research> getAllEntities() {
        try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(GET_ALL_RESEARCH)) {
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            ArrayList<Research> result = new ArrayList<Research>();
            while (resultSet.next()) {
                Research entity = new Research();
                entity.setName(resultSet.getString("name"));
                entity.setStart(LocalDate.parse(resultSet.getString("start")));
                entity.setBudget(resultSet.getInt("budget"));
                entity.setComplete((resultSet.getInt("complete") == 1));
                entity.setLab(new Lab(resultSet.getInt("Labs_id")));
                entity.setScientist(new Scientist(resultSet.getInt("Scientists_id")));
                result.add(entity);
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(Research entity) {
        if (entity.getId() > 0) {
            try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(UPDATE_RESEARCH)) {
                ps.setString(1, entity.getName());
                ps.setString(2, String.valueOf(entity.getStart()));
                ps.setInt(3, entity.getBudget());
                ps.setInt(4, entity.isComplete() ? 1 : 0);
                ps.setInt(5, Math.max(entity.getLab().getId(), 0));
                ps.setInt(6, Math.max(entity.getScientist().getId(), 0));
                ps.setInt(7, entity.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void createEntity(Research entity) {
        try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(CREATE_RESEARCH)) {
            ps.setString(1, entity.getName());
            ps.setString(2, String.valueOf(entity.getStart()));
            ps.setInt(3, entity.getBudget());
            ps.setInt(4, entity.isComplete() ? 1 : 0);
            ps.setInt(5, Math.max(entity.getLab().getId(), 0));
            ps.setInt(6, Math.max(entity.getScientist().getId(), 0));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeEntity(int id) {
        try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(DELETE_RESEARCH)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
