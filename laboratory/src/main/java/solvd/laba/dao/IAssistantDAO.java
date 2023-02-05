package solvd.laba.dao;

import solvd.laba.entities.members.Assistant;
import solvd.laba.entities.members.Scientist;

import java.util.ArrayList;

public interface IAssistantDAO extends IBaseDAO<Assistant> {
    public ArrayList<Assistant> getEntityByScientistId(int id);

    public void createEntity(Assistant entity, Scientist assignedScientist);

    public void updateEntity(Assistant entity, Scientist assignedScientist);
}
