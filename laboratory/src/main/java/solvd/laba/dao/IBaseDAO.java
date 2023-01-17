package solvd.laba.dao;

import java.util.ArrayList;

public interface IBaseDAO<T> {
    public T getEntityById(int id) throws InterruptedException;
    public ArrayList<T> getAllEntities();
    public void updateEntity(T entity);
    public T createEntity(T entity);
    public void removeEntity(int id);
}
