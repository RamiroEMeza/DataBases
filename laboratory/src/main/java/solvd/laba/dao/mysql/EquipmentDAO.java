package solvd.laba.dao.mysql;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.IEquipmentDAO;
import solvd.laba.dao.mysql.MySQLDAO;
import solvd.laba.equipment.Equipment;

import java.sql.*;
import java.util.ArrayList;

public class EquipmentDAO extends MySQLDAO implements IEquipmentDAO {
    private final static Logger LOGGER = LogManager.getLogger(EquipmentDAO.class);

    private final static String GET_EQUIPMENT = "SELECT * FROM Equipment WHERE id=?";
    private final static String GET_ALL_EQUIPMENT = "SELECT * FROM Equipment";
    private final static String CREATE_EQUIPMENT = "INSERT INTO equipment (name, working) VALUES (?, ?)";
    private final static String UPDATE_EQUIPMENT = "UPDATE equipment SET (name=?, working=?) WHERE id=?";
    private final static String DELETE_EQUIPMENT = "DELETE FROM equipment WHERE id=?";

    @Override
    public Equipment getEntityById(int idS) {
        try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(GET_EQUIPMENT)) {
            ResultSet resultSet = null;
            ps.setInt(1, idS);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return new Equipment(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getBoolean("working"));
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Equipment> getAllEntities() {
        try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(GET_ALL_EQUIPMENT)) {
            ResultSet resultSet = null;
            resultSet = ps.executeQuery();
            ArrayList<Equipment> result = new ArrayList<Equipment>();
            while (resultSet.next()) {
                result.add(new Equipment(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getBoolean("working")));
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEntity(Equipment entity) {
        try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(UPDATE_EQUIPMENT)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getIsWorking());
            ps.setInt(3, entity.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createEntity(Equipment entity) {
        try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(CREATE_EQUIPMENT)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getIsWorking());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeEntity(int id) {
        try (Connection c = MySQLDAO.getConnection(); PreparedStatement ps = c.prepareStatement(DELETE_EQUIPMENT)) {
            ps.setInt(1, 4);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException, InterruptedException {
        EquipmentDAO eDAO = new EquipmentDAO();
        Equipment equipment = eDAO.getEntityById(2);
        LOGGER.info(equipment);
        eDAO.getAllEntities().forEach(LOGGER::info);

        //eDAO.updateEntity(new Equipment(2, "Scale", false)); //WORKS
        //eDAO.getAllEntities().forEach(LOGGER::info);

        //eDAO.createEntity(new Equipment("Caliper", true));
        //eDAO.getAllEntities().forEach(LOGGER::info);

        //eDAO.removeEntity(4);
        //eDAO.getAllEntities().forEach(LOGGER::info);
    }

}
