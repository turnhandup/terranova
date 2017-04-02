package myapp.persistence.dao;

import myapp.persistence.entities.DepartmentEntity;

/**
 * Created by PANNA on 01.04.2017.
 */
public interface DepartmentDao {
    DepartmentEntity get(int id_department);
    int insert(DepartmentEntity department);
    void update(DepartmentEntity department);
    void remove(DepartmentEntity department);
}
