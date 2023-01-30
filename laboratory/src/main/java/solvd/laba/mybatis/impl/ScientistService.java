package solvd.laba.mybatis.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.ILabDAO;
import solvd.laba.dao.IScientistDAO;
import solvd.laba.entities.facilities.Lab;
import solvd.laba.entities.members.Scientist;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScientistService {

    private final static Logger LOGGER = LogManager.getLogger(ScientistService.class);
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
            IScientistDAO scientistDAO = session.getMapper(IScientistDAO.class);
            ArrayList<Scientist> allScientists = scientistDAO.getAllEntities();
            allScientists.forEach(LOGGER::info);
        }
    }


}
