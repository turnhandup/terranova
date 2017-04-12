package myapp.services.utils;

import myapp.persistence.entities.ArchitectorEntity;
import myapp.persistence.entities.OrdererEntity;
import myapp.views.ArchitectorView;
import myapp.views.OrdererView;

import javax.ejb.NoSuchEntityException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 09.04.2017.
 */
public interface OrdererService {
    OrdererEntity getOrdererById(int id);
    Map<String, Object> getOrdererById(int id, Set<String> fields) throws NoSuchEntityException;
    List<OrdererEntity> getAllOrderers(int offset, int limit);
    List<Map<String, Object>> getAllOrderersMap(int offset, int limit, Set<String> fields) throws NoSuchEntityException;
    List<OrdererEntity> getAllOrderersByDep(int offset, int limit,int id);
    List<Map<String, Object>> getAllOrderersByDepMap(int offset, int limit, int id, Set<String> fields) throws NoSuchEntityException;
    void removeOrderer(OrdererEntity orderer);
    int create(OrdererView ordererView);
    OrdererEntity updateOrderer(OrdererEntity orderer);
    OrdererEntity updateOrderer(OrdererView ordererView);
    OrdererEntity viewToEntity(OrdererView view);
}
