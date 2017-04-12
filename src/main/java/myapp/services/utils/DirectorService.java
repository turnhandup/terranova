package myapp.services.utils;

import myapp.persistence.entities.DirectorEntity;

import java.util.List;

/**
 * Created by PANNA on 10.04.2017.
 */
public interface DirectorService {
    DirectorEntity getDirectorById(int id);
    List<DirectorEntity> getAllDirectors();
    DirectorEntity update(DirectorEntity directorEntity);
    void remove(DirectorEntity directorEntity);

}
