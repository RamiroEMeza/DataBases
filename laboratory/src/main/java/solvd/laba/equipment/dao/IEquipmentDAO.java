package solvd.laba.equipment.dao;

import solvd.laba.data.base.IBaseDAO;
import solvd.laba.equipment.Equipment;

import java.util.ArrayList;

public interface IEquipmentDAO extends IBaseDAO<Equipment> {
    public ArrayList<Equipment> getAllByScientistId(int scientistId);

//    public ArrayList<Equipment> getAllEquipment();
//    public Equipment getEquipment(int id);
//    public void updateEquipment(Equipment equipment);
//    public void deleteEquipment(Equipment equipment);
//    public void createEquipment(Equipment equipment);
}
