package solvd.laba.dao;

import solvd.laba.entities.equipment.Equipment;

import java.util.ArrayList;


public interface IEquipmentDAO extends IBaseDAO<Equipment> {
    public abstract ArrayList<Equipment> getAssignedEquipmentByResearchId(int id);
}
