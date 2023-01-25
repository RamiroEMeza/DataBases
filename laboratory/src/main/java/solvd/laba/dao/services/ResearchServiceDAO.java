package solvd.laba.dao.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.IResearchDAO;
import solvd.laba.dao.mysql.LabDAO;
import solvd.laba.dao.mysql.ResearchDAO;
import solvd.laba.dao.mysql.SubjectDAO;
import solvd.laba.entities.research.Research;

import java.sql.SQLException;
import java.util.ArrayList;

public class ResearchServiceDAO implements IResearchDAO {
    private final static Logger LOGGER = LogManager.getLogger(ResearchServiceDAO.class);
    private LabDAO labDAO = new LabDAO();
    private ScientistServiceDAO scientistServiceDAO = new ScientistServiceDAO();
    private ResearchDAO researchDAO = new ResearchDAO();
    private SubjectDAO subjectDAO = new SubjectDAO();

    @Override
    public Research getEntityById(int id) {
        Research result;
        result = researchDAO.getEntityById(id);
        result.setLab(labDAO.getEntityByResearchId(id));
        result.setScientist(scientistServiceDAO.getEntityByResearchId(id));
        result.setTestSubjects(subjectDAO.getEntitiesByResearchId(id));
        return result;
    }

    @Override
    public ArrayList<Research> getAllEntities() throws SQLException {
        ArrayList<Research> result = researchDAO.getAllEntities();
        result.forEach(e -> {
            e.setLab(labDAO.getEntityByResearchId(e.getId()));
            e.setScientist(scientistServiceDAO.getEntityByResearchId(e.getId()));
            e.setTestSubjects(subjectDAO.getEntitiesByResearchId(e.getId()));
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
