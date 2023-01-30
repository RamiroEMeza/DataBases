package solvd.laba.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.ILabDAO;
import solvd.laba.entities.facilities.Lab;
import solvd.laba.mybatis.impl.LabService;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;

public class Runner {
    private final static Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
        Lab labToUpdate = LabService.getLab(6);
        LOGGER.info(labToUpdate);
        labToUpdate.setCapacity(9);
        labToUpdate.setComplexity(9);
        LabService.updateLab(labToUpdate);
        //LabService.deleteLab(7);
        LabService.printAllLabs();
        LabService.insertLab(new Lab(1, 1));
        ArrayList<Lab> labsList = LabService.getAllLabs();
        labsList.forEach(LOGGER::info);
    }

}
