package solvd.laba.mybatis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.entities.facilities.Lab;
import solvd.laba.entities.members.Assistant;
import solvd.laba.entities.members.Scientist;
import solvd.laba.mybatis.impl.AssistantService;
import solvd.laba.mybatis.impl.LabService;
import solvd.laba.mybatis.impl.ScientistService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Runner {
    private final static Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
        //ILabDAO is the interface that is implemented by MyBatis
        //LabService is a class that allows me to use the MyBatis implementation and have a clean Runner main
//        LabService labService = new LabService();
//        //UPDATE AN Entity--------------------
//        Lab labToUpdate = labService.getEntityById(6);
//        LOGGER.info(labToUpdate);
//        labToUpdate.setCapacity(9);
//        labToUpdate.setComplexity(9);
//        labService.updateEntity(labToUpdate);
//        //UPDATE AN Entity--------------------
//
//        //DELETE AN Entity-------------------
////        //LabService.deleteLab(8);
//        //DELETE AN Entity-------------------
//
//        //Show all labs--------------------
//        ArrayList<Lab> labsList = labService.getAllEntities();
//        labsList.forEach(LOGGER::info);
//        //Show all labs--------------------
//
//        //CREATING AN Entity--------------------
//        labService.createEntity(new Lab(1, 1));
//        labsList = labService.getAllEntities();
//        labsList.forEach(LOGGER::info);
//        //CREATING AN Entity--------------------

        ScientistService scientistService = new ScientistService();
//        ArrayList<Scientist> scientistArrayList = scientistService.getAllEntities();
//        scientistArrayList.forEach(LOGGER::info);

        Scientist scientist = scientistService.getEntityById(1);
        LOGGER.info(scientist);

//        AssistantService assistantService = new AssistantService();
//        ArrayList<Assistant> assistantList = assistantService.getAllEntities();
//        LOGGER.info("All Assistants:");
//        assistantList.forEach(LOGGER::info);
//        assistantList = assistantService.getEntityByScientistId(1);
//        LOGGER.info("Assistants of Scientist with id=1:");
//        assistantList.forEach(LOGGER::info);

    }

}
