package solvd.laba.dao.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.IResearchDAO;
import solvd.laba.dao.mysql.LabDAO;
import solvd.laba.dao.mysql.ResearchDAO;
import solvd.laba.dao.mysql.ScientistDAO;
import solvd.laba.entities.research.Research;

import java.sql.SQLException;
import java.util.ArrayList;

public class ResearchServiceDAO implements IResearchDAO {
    private final static Logger LOGGER = LogManager.getLogger(ResearchServiceDAO.class);
    private LabDAO labDAO = new LabDAO();
    private ScientistDAO scientistDAO = new ScientistDAO();
    private ResearchDAO researchDAO = new ResearchDAO();

    @Override
    public Research getEntityById(int id) throws SQLException, InterruptedException {
        Research result;
        result = researchDAO.getEntityById(id);
        result.setLab(labDAO.getEntityById(result.getLab().getId()));
        result.setScientist(scientistDAO.getEntityById(result.getScientist().getId()));
        return result;
    }

    @Override
    public ArrayList<Research> getAllEntities() throws SQLException {
        ArrayList<Research> result = researchDAO.getAllEntities();
        result.forEach(e -> {
            e.setLab(labDAO.getEntityById(e.getLab().getId()));
            e.setScientist(scientistDAO.getEntityById(e.getScientist().getId()));
        });
        return result;
    }

    @Override
    public void updateEntity(Research entity) {
        researchDAO.updateEntity(entity);
    }

    @Override
    public void createEntity(Research entity) {
        researchDAO.createEntity(entity);
    }

    @Override
    public void removeEntity(int id) {
        researchDAO.removeEntity(id);
    }
}
