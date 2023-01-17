package solvd.laba.dao.mysql;

import org.apache.commons.dbcp2.BasicDataSource;
import solvd.laba.dao.IEquipmentDAO;
import solvd.laba.dao.mysql.MySQLDAO;
import solvd.laba.equipment.Equipment;

import java.sql.*;
import java.util.ArrayList;

public class EquipmentDAO extends MySQLDAO implements IEquipmentDAO {
    private static BasicDataSource dataSource = null;
    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/laboratorydb?useSSL=false");
        dataSource.setUsername("Ramiro");
        dataSource.setPassword("xqnncpcplpm337");

        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxTotal(12);

    }
    private final static String GETEQUIPMENT = "SELECT * FROM Equipment WHERE id=?";

    @Override
    public Equipment getEntityById(int id) throws InterruptedException, SQLException {
//        Connection c = dataSource.getConnection();
//        Statement statement = null;
//        ResultSet resultSet = null;
//        //ResultSet rs = null;
//        try (PreparedStatement ps = c.prepareStatement(GETEQUIPMENT)) {
//            ps.setInt(1, id);
//            //rs = ps.executeQuery();
//            statement = c.createStatement();
//            resultSet = statement.executeQuery("select * from equipment");
//            while (resultSet.next()) {
//                System.out.println("name:" + resultSet.getInt("name"));
//                System.out.println("working:" + resultSet.getBoolean("working"));
//            };
//            return null;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            //rs.close();
//            //resultSet.close();
//            c.close();
//        }
        return null;
    }

    @Override
    public ArrayList<Equipment> getAllEntities() throws SQLException {

        Connection c = dataSource.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        //ResultSet rs = null;
        try (PreparedStatement ps = c.prepareStatement(GETEQUIPMENT)) {
            //rs = ps.executeQuery();
            statement = c.createStatement();
            resultSet = statement.executeQuery("select * from equipment");
            while (resultSet.next()) {
                System.out.println("id:" + resultSet.getInt("id"));
                System.out.println("name:" + resultSet.getString("name"));
                System.out.println("working:" + resultSet.getBoolean("working"));
            };
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //rs.close();
            //resultSet.close();
            c.close();
        }
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

    public static void main(String[] args) throws SQLException, InterruptedException {
        EquipmentDAO eDAO = new EquipmentDAO();
        System.out.println(eDAO.getAllEntities());
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
