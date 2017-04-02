package myapp.persistence.dao;

import myapp.persistence.entities.DirectorEntity;

/**
 * Created by PANNA on 01.04.2017.
 */
public interface DirectorDao {
    DirectorEntity get(int id_director);
    int insert(DirectorEntity director);
    void update(DirectorEntity director);
    void remove(DirectorEntity director);
}
