package solvd.laba.mybatis.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.IAssistantDAO;
import solvd.laba.dao.ILabDAO;
import solvd.laba.dao.IScientistDAO;
import solvd.laba.entities.facilities.Lab;
import solvd.laba.entities.members.Assistant;
import solvd.laba.entities.members.Scientist;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;

public class AssistantService {
    private final static Logger LOGGER = LogManager.getLogger(AssistantService.class);
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatisConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void printAllScientists() throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAssistantDAO assistantDAO = session.getMapper(IAssistantDAO.class);
            ArrayList<Assistant> allAssistant = assistantDAO.getAllEntities();
            allAssistant.forEach(LOGGER::info);
            LOGGER.info("All Assistants printed successfully");
        } catch (Exception e) {
            LOGGER.info("Something went wrong wile printing all Assistants");
        }
    }

    public ArrayList<Assistant> getAllEntities() {
        ArrayList<Assistant> list = new ArrayList<Assistant>();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAssistantDAO assistantDAO = session.getMapper(IAssistantDAO.class);
            list = assistantDAO.getAllEntities();
            LOGGER.info("Get all Assistants finish successfully");
        } catch (SQLException e) {
            LOGGER.info("SQLException trying to get all Assistants");
        }
        return list;
    }
}
