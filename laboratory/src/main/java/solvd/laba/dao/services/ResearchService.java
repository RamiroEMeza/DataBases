package solvd.laba.dao.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.laba.dao.IBaseDAO;
import solvd.laba.dao.IResearchDAO;
import solvd.laba.dao.jdbc.impl.EquipmentDAO;
import solvd.laba.dao.jdbc.impl.LabDAO;
import solvd.laba.dao.jdbc.impl.ResearchDAO;
import solvd.laba.dao.jdbc.impl.SubjectDAO;
import solvd.laba.entities.research.Research;

import java.sql.SQLException;
import java.util.ArrayList;

public class ResearchService implements IBaseDAO<Research> {
    private final static Logger LOGGER = LogManager.getLogger(ResearchService.class);
    private LabDAO labDAO = new LabDAO();
    private ScientistService scientistServiceDAO = new ScientistService();
    private ResearchDAO researchDAO = new ResearchDAO();
    private SubjectDAO subjectDAO = new SubjectDAO();
    private EquipmentDAO equipmentDAO = new EquipmentDAO();

    @Override
    public Research getEntityById(int id) {
        Research result;
        result = researchDAO.getEntityById(id);
        result.setLab(labDAO.getEntityByResearchId(id));
        result.setScientist(scientistServiceDAO.getEntityByResearchId(id));
        result.setTestSubjects(subjectDAO.getEntitiesByResearchId(id));
        result.setEquipments(equipmentDAO.getAssignedEquipmentByResearchId(id));
        return result;
    }

    @Override
    public ArrayList<Research> getAllEntities() throws SQLException {
        ArrayList<Research> result = researchDAO.getAllEntities();
        result.forEach(e -> {
            e.setLab(labDAO.getEntityByResearchId(e.getId()));
            e.setScientist(scientistServiceDAO.getEntityByResearchId(e.getId()));
            e.setTestSubjects(subjectDAO.getEntitiesByResearchId(e.getId()));
            e.setEquipments(equipmentDAO.getAssignedEquipmentByResearchId(e.getId()));
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
