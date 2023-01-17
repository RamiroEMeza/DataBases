package solvd.laba.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBaseDAO<T> {
    public T getEntityById(int id) throws InterruptedException, SQLException;
    public ArrayList<T> getAllEntities();
    public void updateEntity(T entity);
    public T createEntity(T entity);
    public void removeEntity(int id);
}
