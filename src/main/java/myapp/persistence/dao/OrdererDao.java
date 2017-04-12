package myapp.persistence.dao;

import myapp.persistence.entities.OrdererEntity;

import java.util.List;

/**
 * Created by PANNA on 09.04.2017.
 */
public interface OrdererDao {
    OrdererEntity get(int id_orderer);
    List<OrdererEntity> getAll();
    List<OrdererEntity> getAllByDepartment(int id_department);
    int insert(OrdererEntity ordererEntity);
    void remove(OrdererEntity ordererEntity);
    void update(OrdererEntity ordererEntity);

}
