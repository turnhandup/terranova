package myapp.services.utils;

import javafx.scene.shape.Arc;
import myapp.persistence.dao.ArchitectorDao;
import myapp.persistence.entities.ArchitectorEntity;
import myapp.persistence.entities.UserEntity;
import myapp.services.convertors.ArchitectorConverter;
import myapp.services.convertors.Converter;
import myapp.views.ArchitectorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.ejb.NoSuchEntityException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 06.04.2017.
 */
public class ArchitectorServiceImpl implements ArchitectorService {
    @Autowired
    private ArchitectorDao architectorDao;

    @Autowired
    private ArchitectorConverter architectorConverter;

    public ArchitectorEntity getArchitectorById(int id) {
        ArchitectorEntity architector = architectorDao.get(id);
        if (architector == null) {
            throw new NoSuchEntityException();
        }
        return architector;
    }

    @Transactional
    public Map<String, Object> getArchitectorByIdMap(int id, Set<String> fields) throws NoSuchEntityException {
        return architectorConverter.convert(getArchitectorById(id), fields);
    }

    public List<ArchitectorEntity> getAllArchitectors(int offset, int limit) {
        List<ArchitectorEntity> list = architectorDao.findAll();
        for (ArchitectorEntity l : list) {
            System.out.println(l.toString());
        }
        if (list == null || list.isEmpty()) {
            throw new NoSuchEntityException();
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getAllArchitectorsMap(int offset, int limit, Set<String> fields) throws NoSuchEntityException {
        return architectorConverter.convert(getAllArchitectors(offset, limit), fields);
    }


    @Override
    @Transactional(rollbackFor=NoSuchEntityException.class)
    public ArchitectorEntity updateArchitector(ArchitectorEntity architectorData) throws NoSuchEntityException {
        ArchitectorEntity updatedArchitector = architectorDao.get(architectorData.getId_architector());
        if (updatedArchitector == null)
            throw new NoSuchEntityException();
        updatedArchitector.setId_architector(architectorData.getId_architector());
        updatedArchitector.setEmail(architectorData.getEmail());
        updatedArchitector.setPib(architectorData.getPib());
        updatedArchitector.setHours(architectorData.getHours());
        updatedArchitector.setWork_experience(architectorData.getWork_experience());
        updatedArchitector.setPhone_number(architectorData.getPhone_number());
        updatedArchitector.setId_user(architectorData.getId_user());
        architectorDao.update(updatedArchitector);
        return updatedArchitector;
    }

    @Override
    public ArchitectorEntity updateArchitector(ArchitectorView architectorView) {
        return updateArchitector(viewToEntity(architectorView));
    }



    public void removeArchitector(ArchitectorEntity architector) {
        architectorDao.remove(architector);
    }

    @Override
    public ArchitectorEntity viewToEntity(ArchitectorView view){
        ArchitectorEntity architectorEntity = new ArchitectorEntity();
        architectorEntity.setId_architector(view.getId_architector());
        architectorEntity.setId_user(view.getId_user());
        architectorEntity.setPib(view.getPib());
        architectorEntity.setEmail(view.getEmail());
        architectorEntity.setHours(view.getHours());
        architectorEntity.setWork_experience(view.getWork_experience());
        architectorEntity.setPhone_number(view.getPhone_number());
        return architectorEntity;
    }
}
