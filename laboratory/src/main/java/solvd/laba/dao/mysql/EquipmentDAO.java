package solvd.laba.dao.mysql;

import solvd.laba.dao.IEquipmentDAO;
import solvd.laba.dao.mysql.MySQLDAO;
import solvd.laba.equipment.Equipment;

import java.util.ArrayList;

public class EquipmentDAO extends MySQLDAO implements IEquipmentDAO {
    @Override
    public Equipment getEntity(int id) {
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
