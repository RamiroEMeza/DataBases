package solvd.laba.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.IBaseDAO;
import solvd.laba.dao.ILabDAO;
import solvd.laba.entities.facilities.Lab;
import solvd.laba.mybatis.impl.LabDAO;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;

public class Runner {
    private final static Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
        //MYBATIS.ORG IMPLEMENTATION-----------------------
//        String resource = "src/main/resources/mybatisConfig.xml";
//        File f = new File(resource);
//        LOGGER.info("mybatisConfig found: " + f.exists());
//        LOGGER.info(f.getAbsolutePath());
//
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory2 =
//                new SqlSessionFactoryBuilder().build(inputStream);
//
//
//        try (SqlSession session = sqlSessionFactory2.openSession()) {
//            ILabDAO labDAO = session.getMapper(ILabDAO.class);
//
//            Lab l = labDAO.getEntityById(1);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        //MYBATIS.ORG IMPLEMENTATION-----------------------

        //DImitry IMPLEMENTATION
        SqlSessionFactory sqlSessionFactory = null;
        try {
            Reader reader = Resources.getResourceAsReader("mybatisConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info(sqlSessionFactory.toString());

        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILabDAO labDAO = session.getMapper(ILabDAO.class);
            Lab labToUpdate = labDAO.getEntityById(6);
            labToUpdate.setComplexity(4);
            labToUpdate.setCapacity(4);

            updateLab(labToUpdate, session, labDAO);
            printAllLabs(session, labDAO);

            //insertLab(9, 9, session, labDAO);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void updateLab(Lab lab, SqlSession session, ILabDAO labDAO) {
        //UPDATE ENTITY EXAMPLE--------------------
        try {
            labDAO.updateEntity(lab);
            session.commit();
            LOGGER.info("Lab Updating finish successfully");
        } catch (Exception e) {
            LOGGER.info("Error Updating and insert lab");
            session.rollback();
            LOGGER.info("Session rollback");
        }
        //UPDATE ENTITY EXAMPLE--------------------
    }

    private static void printAllLabs(SqlSession session, ILabDAO labDAO) throws SQLException {
        //SELECT ALL ENTITY EXAMPLE--------------------
        ArrayList<Lab> allLabs = labDAO.getAllEntities();
        allLabs.forEach(LOGGER::info);
        //SELECT ALL ENTITY EXAMPLE--------------------
    }

    private static void insertLab(int capacity, int complexity, SqlSession session, ILabDAO labDAO) {
        //INSERT ENTITY EXAMPLE--------------------
        LOGGER.info("Create and insert lab");
        try {
            Lab labFromJava = new Lab(9, 9);
            labDAO.createEntity(labFromJava);
            session.commit();
            LOGGER.info("Lab insertion finish successfully");
        } catch (Exception e) {
            LOGGER.info("Error Creating and insert lab");
            session.rollback();
            LOGGER.info("Session rollback");
        }
        //INSERT ENTITY EXAMPLE--------------------
    }
}
