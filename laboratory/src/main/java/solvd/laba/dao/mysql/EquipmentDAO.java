package solvd.laba.dao.mysql;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
//import solvd.laba.connections.ConnectionPool;
import solvd.laba.connections.ConnectionPool;
import solvd.laba.dao.IEquipmentDAO;
import solvd.laba.dao.mysql.MySQLDAO;
import solvd.laba.equipment.Equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class EquipmentDAO extends MySQLDAO implements IEquipmentDAO {
    private final static String GETEQUIPMENT = "SELECT * FROM Equipment WHERE id=?";

    @Override
    public Equipment getEntityById(int id) throws InterruptedException {
        Connection c = (Connection) ConnectionPool.getInstance().connect();
        try (PreparedStatement ps = c.prepareStatement(GETEQUIPMENT)){
            ps.setInt(0, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public ArrayList<Equipment> getAllEntities() {
        return null;
    }

    @Override
    public ArrayList<Equipment> getAllByScientistId(int scientistId) {
        return null;
    }

    @Override
    public void updateEntity(Equipment entity) {

    }

    @Override
    public Equipment createEntity(Equipment entity) {
        return null;
    }

    @Override
    public void removeEntity(int id) {

    }




//    @Override
//    public ArrayList<Equipment> getAllEquipment() {
//        return null;
//    }
//
//    @Override
//    public Equipment getEquipment(int id) {
//        return null;
//    }
//
//    @Override
//    public void updateEquipment(Equipment equipment) {
//
//    }
//
//    @Override
//    public void deleteEquipment(Equipment equipment) {
//
//    }
//
//    @Override
//    public void createEquipment(Equipment equipment) {
//
//    }
}
