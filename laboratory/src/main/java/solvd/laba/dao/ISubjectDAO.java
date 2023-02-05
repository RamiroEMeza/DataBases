package solvd.laba.dao;

import solvd.laba.entities.research.Research;
import solvd.laba.entities.test.subjects.Subject;

import java.util.ArrayList;

public interface ISubjectDAO extends IBaseDAO<Subject> {
    public ArrayList<Subject> getEntitiesByResearchId(int id);

    public void createEntity(Subject entity, Research assignedResearch);

    public void updateEntity(Subject entity, Research assignedResearch);
}
