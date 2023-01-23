package solvd.laba;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.mysql.EquipmentDAO;
import solvd.laba.dao.mysql.LabDAO;
import solvd.laba.dao.mysql.ResearchDAO;
import solvd.laba.dao.mysql.ScientistDAO;
import solvd.laba.dao.services.AssistantServiceDAO;
import solvd.laba.dao.services.ResearchServiceDAO;

import java.sql.SQLException;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws SQLException, InterruptedException {
        EquipmentDAO eDAO = new EquipmentDAO();
        LabDAO labDAO = new LabDAO();
        ScientistDAO scientistDAO = new ScientistDAO();
        ResearchServiceDAO researchServiceDAO = new ResearchServiceDAO();
        AssistantServiceDAO assistantService = new AssistantServiceDAO();
        //LOGGER.info(researchServiceDAO.getEntityById(1));
        //researchServiceDAO.getAllEntities().forEach(LOGGER::info);

        //labDAO.getAllEntities().forEach(LOGGER::info);

        //scientistDAO.getAllEntities().forEach(LOGGER::info);

        assistantService.getAllEntities().forEach(LOGGER::info);

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
