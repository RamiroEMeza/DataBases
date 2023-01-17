package solvd.laba.equipment.dao;

import solvd.laba.equipment.Equipment;

import java.util.ArrayList;

public interface IEquipmentDAO {
    public ArrayList<Equipment> getAllEquipment();
    public Equipment getEquipment(int id);
    public void updateEquipment(Equipment equipment);
    public void deleteEquipment(Equipment equipment);
}
