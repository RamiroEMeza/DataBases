package solvd.laba;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.mysql.AssistantDAO;
import solvd.laba.dao.mysql.EquipmentDAO;
import solvd.laba.dao.mysql.LabDAO;
import solvd.laba.dao.mysql.ScientistDAO;
import solvd.laba.dao.services.ScientistServiceDAO;
import solvd.laba.dao.services.ResearchServiceDAO;
import solvd.laba.entities.members.Assistant;
import solvd.laba.entities.members.Scientist;
import solvd.laba.entities.research.Research;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws SQLException, InterruptedException {
        EquipmentDAO eDAO = new EquipmentDAO();
        LabDAO labDAO = new LabDAO();
        ScientistDAO scientistDAO = new ScientistDAO();
        AssistantDAO assistantDAO = new AssistantDAO();
        ResearchServiceDAO researchServiceDAO = new ResearchServiceDAO();
        ScientistServiceDAO scientistServiceDAO = new ScientistServiceDAO();

        ArrayList<Scientist> allScientist = scientistServiceDAO.getAllEntities();
        allScientist.forEach(LOGGER::info);
        LOGGER.info("\n");
        ArrayList<Assistant> allAssistant = assistantDAO.getAllEntities();
        allAssistant.forEach(LOGGER::info);


    }
}
