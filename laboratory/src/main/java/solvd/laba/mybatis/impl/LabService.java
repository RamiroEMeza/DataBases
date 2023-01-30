package solvd.laba.mybatis.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.ILabDAO;
import solvd.laba.entities.facilities.Lab;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;

public class LabService {
    private final static Logger LOGGER = LogManager.getLogger(LabService.class);
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatisConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteLab(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            if (id > 0) {
                ILabDAO labDAO = session.getMapper(ILabDAO.class);
                labDAO.removeEntity(id);
                LOGGER.info("Lab Deleting finish successfully");
                session.commit();
            }
        } catch (Exception e) {
            LOGGER.info("Error Deleting Lab");
        }
    }

    public static void updateLab(Lab lab) {
        //UPDATE ENTITY EXAMPLE--------------------
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILabDAO labDAO = session.getMapper(ILabDAO.class);
            try {
                labDAO.updateEntity(lab);
                session.commit();
                LOGGER.info("Lab Updating finish successfully");
            } catch (Exception e) {
                LOGGER.info("Error Updating and insert lab");
                session.rollback();
                LOGGER.info("Session rollback");
            }
        }
        //UPDATE ENTITY EXAMPLE--------------------
    }

    public static void printAllLabs() throws SQLException {
        //SELECT ALL ENTITY EXAMPLE--------------------
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILabDAO labDAO = session.getMapper(ILabDAO.class);
            ArrayList<Lab> allLabs = labDAO.getAllEntities();
            allLabs.forEach(LOGGER::info);
        }
        //SELECT ALL ENTITY EXAMPLE--------------------
    }

    public static void insertLab(Lab lab) {
        //INSERT ENTITY EXAMPLE--------------------
        LOGGER.info("Create and insert lab");
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILabDAO labDAO = session.getMapper(ILabDAO.class);
            try {
                labDAO.createEntity(lab);
                session.commit();
                LOGGER.info("Lab insertion finish successfully");
            } catch (Exception e) {
                LOGGER.info("Error Creating and insert lab");
                session.rollback();
                LOGGER.info("Session rollback");
            }
        }
        //INSERT ENTITY EXAMPLE--------------------
    }

    public static Lab getLab(int id) {
        Lab response = new Lab();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILabDAO labDAO = session.getMapper(ILabDAO.class);
            response = labDAO.getEntityById(id);
            LOGGER.info("Get lab finish successfully");
        } catch (SQLException e) {
            LOGGER.info("SQLException trying to get a lab");
        } catch (InterruptedException e) {
            LOGGER.info("InterruptedException trying to get a lab");
        }
        return response;
    }

    public static ArrayList<Lab> getAllLabs() {
        ArrayList<Lab> list = new ArrayList<Lab>();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILabDAO labDAO = session.getMapper(ILabDAO.class);
            list = labDAO.getAllEntities();
            LOGGER.info("Get all labs finish successfully");
        } catch (SQLException e) {
            LOGGER.info("SQLException trying to get all labs");
        }
        return list;
    }
}
