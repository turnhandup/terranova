package myapp.persistence.dao;

import myapp.persistence.entities.DirectorEntity;

import java.util.List;

/**
 * Created by PANNA on 01.04.2017.
 */
public interface DirectorDao {
    DirectorEntity get(int id_director);
    List<DirectorEntity> getAll();
    int insert(DirectorEntity director);
    void insertDirector(DirectorEntity directorEntity);
    void update(DirectorEntity director);
    void remove(DirectorEntity director);

}
