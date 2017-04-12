package myapp.services.utils;

import myapp.persistence.dao.ObjectDao;
import myapp.persistence.entities.ObjectEntity;
import myapp.services.convertors.ObjectConverter;
import myapp.views.ObjectView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ejb.NoSuchEntityException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 12.04.2017.
 */
public class ObjectServiceImpl implements  ObjectService {
    @Autowired
    ObjectDao objectDao;

    @Autowired
    ObjectConverter objectConverter;

    @Override
    public ObjectEntity getObjectById(int id_object) {
        ObjectEntity objectEntity= objectDao.getById(id_object);
        return objectEntity;
    }

    @Override
    public Map<String, Object> getObjectByIdMap(int id_object, Set<String> fields) throws NoSuchEntityException {
        return objectConverter.convert(getObjectById(id_object),fields);
    }

    @Override
    public List<ObjectEntity> getAllObjects(int offset, int limits) {
        List<ObjectEntity> objectEntities=objectDao.getAllObjects();
        return objectEntities;
    }

    @Override
    public List<Map<String, Object>> getAllObjectsMap(int offset, int limits, Set<String> fields) {
        return objectConverter.convert(getAllObjects(offset,limits),fields);
    }

    @Override
    public List<ObjectEntity> getAllObjectsByArchitector(int offset, int limits, int id_architector) {
        List<ObjectEntity> objectEntities=objectDao.getObjectByArchitector(id_architector);
        return objectEntities;
    }

    @Override
    public List<Map<String, Object>> getAllObjectsByArchitectorMap(int offset, int limits, int id_architector, Set<String> fields) {
        return objectConverter.convert(getAllObjectsByArchitector(offset,limits,id_architector),fields);
    }

    @Override
    public int create(ObjectView objectView) {
        ObjectEntity objectEntity=viewToEntity(objectView);
        objectDao.insert(objectEntity);
        return objectEntity.getId_object();
    }

    @Override
    public ObjectEntity update(ObjectEntity objectEntity) {
        ObjectEntity updatedEntity=new ObjectEntity();
        updatedEntity.setId_object(objectEntity.getId_object());
        updatedEntity.setId_architector(objectEntity.getId_architector());
        updatedEntity.setStatus(objectEntity.isStatus());
        updatedEntity.setDetalisation(objectEntity.getDetalisation());
        updatedEntity.setSoftware(objectEntity.getSoftware());
        updatedEntity.setHours(objectEntity.getHours());
        objectDao.update(updatedEntity);
        return updatedEntity;
    }

    @Override
    public ObjectEntity update(ObjectView objectView) {
        return update(viewToEntity(objectView));
    }

    @Override
    public void remove(ObjectEntity objectEntity) {

    }

    @Override
    public ObjectEntity viewToEntity(ObjectView objectView) {
        ObjectEntity objectEntity=new ObjectEntity();
        objectEntity.setId_object(objectView.getId_object());
        objectEntity.setId_architector(objectView.getId_architector());
        objectEntity.setStatus(objectView.isStatus());
        objectEntity.setDetalisation(objectView.getDetalisation());
        objectEntity.setSoftware(objectView.getSoftware());
        objectEntity.setHours(objectView.getHours());
        return objectEntity;
    }

}
