package solvd.laba.dao.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.IScientistDAO;
import solvd.laba.dao.mysql.AssistantDAO;
import solvd.laba.dao.mysql.ScientistDAO;
import solvd.laba.entities.members.Scientist;

import java.util.ArrayList;

public class ScientistServiceDAO implements IScientistDAO {
    private final static Logger LOGGER = LogManager.getLogger(ScientistServiceDAO.class);
    private AssistantDAO assistantDAO = new AssistantDAO();
    private ScientistDAO scientistDAO = new ScientistDAO();

    @Override
    public Scientist getEntityById(int id) {
        Scientist result;
        result = scientistDAO.getEntityById(id);
        result.setAssistants(assistantDAO.getEntityByScientistId(result.getId()));
        return result;
    }

    @Override
    public ArrayList<Scientist> getAllEntities() {
        ArrayList<Scientist> result = scientistDAO.getAllEntities();
        result.forEach(e -> {
            e.setAssistants(assistantDAO.getEntityByScientistId(e.getId()));
        });
        return result;
    }

    @Override
    public void updateEntity(Scientist entity) {
        scientistDAO.updateEntity(entity);
    }

    @Override
    public void createEntity(Scientist entity) {
        scientistDAO.createEntity(entity);
    }

    @Override
    public void removeEntity(int id) {
        scientistDAO.removeEntity(id);
    }

    @Override
    public Scientist getEntityByResearchId(int id) {
        Scientist result;
        result = scientistDAO.getEntityByResearchId(id);
        result.setAssistants(assistantDAO.getEntityByScientistId(result.getId()));
        return result;
    }
}
