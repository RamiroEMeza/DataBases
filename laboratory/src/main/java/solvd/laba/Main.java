package solvd.laba;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.jdbc.impl.AssistantDAO;
import solvd.laba.dao.jdbc.impl.EquipmentDAO;
import solvd.laba.dao.jdbc.impl.LabDAO;
import solvd.laba.dao.jdbc.impl.ScientistDAO;
import solvd.laba.dao.services.ScientistService;
import solvd.laba.dao.services.ResearchService;
import solvd.laba.entities.members.Assistant;
import solvd.laba.entities.members.Scientist;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws SQLException, InterruptedException {
        EquipmentDAO eDAO = new EquipmentDAO();
        LabDAO labDAO = new LabDAO();
        ScientistDAO scientistDAO = new ScientistDAO();
        AssistantDAO assistantDAO = new AssistantDAO();
        ResearchService researchService = new ResearchService();
        ScientistService ScientistService = new ScientistService();

        ArrayList<Scientist> allScientist = ScientistService.getAllEntities();
        allScientist.forEach(LOGGER::info);
        LOGGER.info("\n");
        ArrayList<Assistant> allAssistant = assistantDAO.getAllEntities();
        allAssistant.forEach(LOGGER::info);


    }
}
