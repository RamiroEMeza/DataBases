package solvd.laba.dao.jdbc.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.IAdministrativeDAO;
import solvd.laba.entities.members.Administrative;
import solvd.laba.entities.resource.Resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdministrativeDAO extends MySQLDAO implements IAdministrativeDAO {

    private final static Logger LOGGER = LogManager.getLogger(AdministrativeDAO.class);

    private final static String GET_ADMINISTRATIVE = "SELECT a.id, a.name, a.lastname " +
            "FROM Administratives a WHERE id=?";

    private final static String GET_ALL_ADMINISTRATIVES = "SELECT a.id, a.name, a.lastname FROM Administratives a";

    private final static String CREATE_ADMINISTRATIVE = "INSERT INTO Administratives (name, lastname, Resources_Stock_id) " +
            "VALUES (?, ?, ?)";

    private final static String UPDATE_ADMINISTRATIVE = "UPDATE Administratives SET (name=?, lastname=?, Resources_Stock_id=?) " +
            "WHERE id=?";

    private final static String DELETE_ADMINISTRATIVE = "DELETE FROM Administratives WHERE id=?";

    @Override
    public Administrative getEntityById(int id) throws InterruptedException, SQLException {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(GET_ADMINISTRATIVE)) {
            ResultSet resultSet = null;
            ps.setInt(1, id);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return new Administrative(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"));
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Administrative> getAllEntities() throws SQLException {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(GET_ALL_ADMINISTRATIVES)) {
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            ArrayList<Administrative> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Administrative(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname")));
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeEntity(int id) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(DELETE_ADMINISTRATIVE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createEntity(Administrative entity) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(CREATE_ADMINISTRATIVE)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLastName());
            ps.setInt(3, entity.getResource().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(Administrative entity) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(UPDATE_ADMINISTRATIVE)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLastName());
            ps.setInt(3, entity.getResource().getId());
            ps.setInt(4, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
