package solvd.laba;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.IBaseDAO;
import solvd.laba.dao.services.ScientistService;
import solvd.laba.entities.members.Assistant;
import solvd.laba.entities.members.Scientist;
import solvd.laba.enums.DAOs;
import solvd.laba.factorys.BasicDAOsFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);


    public static void main(String[] args) throws SQLException, InterruptedException {
        ScientistService ScientistService = new ScientistService();

        ArrayList<Scientist> allScientist = ScientistService.getAllEntities();
        allScientist.forEach(LOGGER::info);
        LOGGER.info("\n");
        IBaseDAO<Assistant> assistantsProduct = BasicDAOsFactory.getDAO(DAOs.ASSISTANT);
        if (assistantsProduct != null){
            assistantsProduct.getAllEntities().forEach(LOGGER::info);
        }



    }
}
