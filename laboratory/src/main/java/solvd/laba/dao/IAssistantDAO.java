package solvd.laba.dao;

import solvd.laba.entities.members.Assistant;
import solvd.laba.entities.members.Scientist;

import java.util.ArrayList;

public interface IAssistantDAO extends IBaseDAO<Assistant> {
    public ArrayList<Assistant> getEntityByScientistId(int id);

    public void createEntitySetingScientist(Assistant entity, Scientist assignedScientist);

    public void updateEntitySetingScientist(Assistant entity, Scientist assignedScientist);
}
