package solvd.laba.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBaseDAO<T> {
    public T getEntityById(int id) throws InterruptedException, SQLException;

    public ArrayList<T> getAllEntities() throws SQLException;

    public void updateEntity(T entity);

    public void createEntity(T entity);

    public void removeEntity(int id);
}
