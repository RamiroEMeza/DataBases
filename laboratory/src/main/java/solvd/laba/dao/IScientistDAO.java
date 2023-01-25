package solvd.laba.dao;

import solvd.laba.entities.members.Scientist;

public interface IScientistDAO extends IBaseDAO<Scientist> {
    public Scientist getEntityByResearchId(int id);
}
