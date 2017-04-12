package myapp.persistence.dao;

import myapp.persistence.entities.ObjectEntity;

import java.util.List;

/**
 * Created by PANNA on 12.04.2017.
 */
public interface ObjectDao {
    ObjectEntity getById(int id_object);
    List<ObjectEntity> getAllObjects();
    List<ObjectEntity> getObjectByArchitector(int id_architector);
    int insert(ObjectEntity objectEntity);
    void remove(ObjectEntity objectEntity);
    void update(ObjectEntity objectEntity);
}
