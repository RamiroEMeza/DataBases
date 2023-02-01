package solvd.laba.dao;

import solvd.laba.entities.members.Administrative;
import solvd.laba.entities.resource.Resource;
import solvd.laba.entities.test.subjects.Subject;

public interface IAdministrativeDAO extends IBaseDAO<Administrative> {
    public void createEntitySetingResource(Administrative entity, Resource resource);

    public void updateEntitySetingResource(Administrative entity, Resource resource);
}
