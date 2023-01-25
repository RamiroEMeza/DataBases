package solvd.laba.dao;

import solvd.laba.entities.members.Assistant;

import java.util.ArrayList;

public interface IAssistantDAO extends IBaseDAO<Assistant> {
    public ArrayList<Assistant> getEntityByScientistId(int id);
}
