package solvd.laba.factorys;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.IBaseDAO;
import solvd.laba.dao.jdbc.impl.*;
import solvd.laba.enums.DAOs;

import java.sql.SQLException;

public class BasicDAOsFactory {

    private final static Logger LOGGER = LogManager.getLogger(BasicDAOsFactory.class);

    public static IBaseDAO getDAO(DAOs dao) {
        switch (dao) {
            case ASSISTANT -> {
                return new AssistantDAO();
            }
            case LAB -> {
                return new LabDAO();
            }
            case SUBJECT -> {
                return new SubjectDAO();
            }
            case TECHNICAL_SUPPORT -> {
                return new TechnicalSupportDAO();
            }
            case EQUIPMENT -> {
                return new EquipmentDAO();
            }
            default -> LOGGER.info("Returning null");
        }
        return null;
    }
}
