package myapp.services.utils;

import myapp.persistence.entities.OrderEntity;
import myapp.views.OrderView;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 13.04.2017.
 */
public interface OrderService {
    OrderEntity getOrderById(int id_order);
    Map<String, Object> getOrderById(int id, Set<String> fields);
    List<OrderEntity> getAllOrders(int id_orderer);
    List<Map<String, Object>> getAllOrdersMap(int id_orderer, Set<String> fields);
    int addOrder(OrderView orderView);
    OrderEntity updateOrder(OrderView orderView);
    public OrderEntity viewToEntity(OrderView view);
}
