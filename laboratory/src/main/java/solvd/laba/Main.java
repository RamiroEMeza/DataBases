package solvd.laba;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.mysql.EquipmentDAO;
import solvd.laba.dao.mysql.LabDAO;
import solvd.laba.dao.mysql.ScientistDAO;
import solvd.laba.entities.equipment.Equipment;

import java.sql.SQLException;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        EquipmentDAO eDAO = new EquipmentDAO();
        LabDAO labDAO = new LabDAO();
        ScientistDAO scientistDAO = new ScientistDAO();

        //labDAO.getAllEntities().forEach(System.out::println);

        scientistDAO.getAllEntities().forEach(System.out::println);

        //eDAO.getAllEntities().forEach(LOGGER::info);

        //Equipment equipment = eDAO.getEntityById(2);
        //LOGGER.info(equipment);

        //eDAO.updateEntity(new Equipment(2, "Scale", false)); //WORKS
        //eDAO.getAllEntities().forEach(LOGGER::info);

        //eDAO.createEntity(new Equipment("Caliper", true));
        //eDAO.getAllEntities().forEach(LOGGER::info);

        //eDAO.removeEntity(4);
        //eDAO.getAllEntities().forEach(LOGGER::info);
    }
}
