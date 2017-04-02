package myapp.persistence.dao;

import myapp.persistence.entities.ArchitectorEntity;

/**
 * Created by PANNA on 01.04.2017.
 */
public interface ArchitectorDao {
    ArchitectorEntity get(int id_architector);
    int insert(ArchitectorEntity architector);
    void update(ArchitectorEntity architector);
    void remove(ArchitectorEntity architector);
}
