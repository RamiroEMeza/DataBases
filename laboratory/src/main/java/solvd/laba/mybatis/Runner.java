package solvd.laba.mybatis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.entities.facilities.Lab;
import solvd.laba.mybatis.impl.LabService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Runner {
    private final static Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
        //ILabDAO is the interface that is implemented by MyBatis
        //LabService is a class that allows me to use the MyBatis implementation and have a clean Runner main

        LabService labService = new LabService();
        Lab labToUpdate = labService.getEntityById(6);
        LOGGER.info(labToUpdate);
        labToUpdate.setCapacity(9);
        labToUpdate.setComplexity(9);
        labService.updateEntity(labToUpdate);
        //LabService.deleteLab(8);
        ArrayList<Lab> labsList = labService.getAllEntities();
        labsList.forEach(LOGGER::info);
        labService.createEntity(new Lab(1, 1));
        labsList = labService.getAllEntities();
        labsList.forEach(LOGGER::info);
    }

}
