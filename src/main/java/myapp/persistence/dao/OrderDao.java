package myapp.persistence.dao;

import myapp.persistence.entities.OrderEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by PANNA on 13.04.2017.
 */
public interface OrderDao {

    OrderEntity getById(int id_order);
    List<OrderEntity> getAllObjects(int id_orderer);
    int insert(OrderEntity objectEntity);
    void remove(OrderEntity objectEntity);
    int update(OrderEntity objectEntity);
}
