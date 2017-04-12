package myapp.services.utils;

import myapp.persistence.dao.DirectorDao;
import myapp.persistence.entities.DirectorEntity;
import myapp.persistence.entities.OrdererEntity;
import myapp.persistence.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by PANNA on 10.04.2017.
 */
@Component
public class DirectorServiceImpl implements DirectorService {
    @Autowired
    DirectorDao directorDao;
    @Override
    public DirectorEntity getDirectorById(int id) {
        DirectorEntity directorEntity=directorDao.get(id);
        return  directorEntity;
    }

    @Override
    public List<DirectorEntity> getAllDirectors() {
        List<DirectorEntity> list=directorDao.getAll();
        return list;
    }

    @Override
    public DirectorEntity update(DirectorEntity directorEntity) {
        DirectorEntity updatedDirector=directorDao.get(directorEntity.getId_director());
        updatedDirector.setId_director(directorEntity.getId_director());
        updatedDirector.setId_user(directorEntity.getId_user());
        updatedDirector.setId_department(directorEntity.getId_department());
        updatedDirector.setPib(directorEntity.getPib());
        updatedDirector.setAddress(directorEntity.getAddress());
        updatedDirector.setMarital_status(directorEntity.getMarital_status());
        updatedDirector.setWork_experience(directorEntity.getWork_experience());
        UserEntity userEntity=new UserEntity();
        userEntity.setLogin(directorEntity.getUserEntity().getLogin());
        userEntity.setPassword(directorEntity.getUserEntity().getPassword());
        updatedDirector.setUserEntity(userEntity);
        directorDao.update(updatedDirector);
        return updatedDirector;
    }

    @Override
    public void remove(DirectorEntity directorEntity) {
        directorDao.remove(directorEntity);
    }
}
