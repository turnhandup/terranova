package myapp.services.utils;

import myapp.persistence.dao.ObjectDao;
import myapp.persistence.entities.ObjectEntity;
import myapp.views.ObjectView;

import javax.ejb.NoSuchEntityException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 12.04.2017.
 */
public interface ObjectService {
    ObjectEntity getObjectById(int id_object);
    Map<String,Object> getObjectByIdMap(int id_object, Set<String> fields) throws NoSuchEntityException;
    List<ObjectEntity> getAllObjects(int offset,int limits);
    List<Map<String,Object>> getAllObjectsMap(int offset,int limits, Set<String> fields);
    List<ObjectEntity> getAllObjectsByArchitector(int offset,int limits, int id_architector);
    List<Map<String,Object>> getAllObjectsByArchitectorMap(int offset,int limits, int id_architector, Set<String> fields);
    int create(ObjectView objectView);
    ObjectEntity update(ObjectEntity objectEntity);
    ObjectEntity update(ObjectView objectView);
    void remove(ObjectEntity objectEntity);
    ObjectEntity viewToEntity(ObjectView objectView);
}
