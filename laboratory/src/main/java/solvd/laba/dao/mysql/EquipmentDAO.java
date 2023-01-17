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
        Connection c = dataSource.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        //ResultSet rs = null;
        try (PreparedStatement ps = c.prepareStatement(GETEQUIPMENT)) {
            ps.setInt(1, id);
            //rs = ps.executeQuery();
            statement = c.createStatement();
            resultSet = statement.executeQuery("select * from equipment where id=?");

            LOGGER.info("id:" + resultSet.getInt("id"));
            LOGGER.info("name:" + resultSet.getString("name"));
            LOGGER.info("working:" + resultSet.getBoolean("working"));

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
                LOGGER.info("id:" + resultSet.getInt("id"));
                LOGGER.info("name:" + resultSet.getString("name"));
                LOGGER.info("working:" + resultSet.getBoolean("working"));
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
        eDAO.getEntityById(2);
        eDAO.getAllEntities();
    }

}
