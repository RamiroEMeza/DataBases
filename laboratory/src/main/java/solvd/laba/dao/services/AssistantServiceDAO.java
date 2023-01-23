package solvd.laba.dao.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.IAssistantDAO;
import solvd.laba.dao.mysql.AssistantDAO;
import solvd.laba.dao.mysql.ScientistDAO;
import solvd.laba.entities.members.Assistant;
import solvd.laba.entities.research.Research;

import java.sql.SQLException;
import java.util.ArrayList;

public class AssistantServiceDAO implements IAssistantDAO {
    private final static Logger LOGGER = LogManager.getLogger(AssistantServiceDAO.class);
    private AssistantDAO assistantDAO = new AssistantDAO();
    private ScientistDAO scientistDAO = new ScientistDAO();

    @Override
    public Assistant getEntityById(int id) throws InterruptedException, SQLException {
        Assistant result;
        result = assistantDAO.getEntityById(id);
        result.setScientist(scientistDAO.getEntityById(result.getScientist().getId()));
        return result;
    }

    @Override
    public ArrayList<Assistant> getAllEntities() throws SQLException {
        ArrayList<Assistant> result = assistantDAO.getAllEntities();
        result.forEach(e -> {
            e.setScientist(scientistDAO.getEntityById(e.getScientist().getId()));
        });
        return result;
    }

    @Override
    public void updateEntity(Assistant entity) {
        assistantDAO.updateEntity(entity);
    }

    @Override
    public void createEntity(Assistant entity) {
        assistantDAO.createEntity(entity);
    }

    @Override
    public void removeEntity(int id) {
        assistantDAO.removeEntity(id);
    }
}
