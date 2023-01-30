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

public class LabService implements ILabDAO {
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

    @Override
    public void removeEntity(int id) {
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

    @Override
    public void updateEntity(Lab lab) {
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
    }

    public void printAllLabs() throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILabDAO labDAO = session.getMapper(ILabDAO.class);
            ArrayList<Lab> allLabs = labDAO.getAllEntities();
            allLabs.forEach(LOGGER::info);
        }
    }

    @Override
    public void createEntity(Lab lab) {
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
    }

    @Override
    public Lab getEntityById(int id) {
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

    @Override
    public ArrayList<Lab> getAllEntities() {
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

    @Override
    public Lab getEntityByResearchId(int id) {
        return null;
    }
}
