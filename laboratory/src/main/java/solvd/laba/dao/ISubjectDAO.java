package solvd.laba.dao;

import solvd.laba.entities.test.subjects.Subject;

import java.util.ArrayList;

public interface ISubjectDAO extends IBaseDAO<Subject> {
    public ArrayList<Subject> getEntitiesByResearchId(int id);
}
