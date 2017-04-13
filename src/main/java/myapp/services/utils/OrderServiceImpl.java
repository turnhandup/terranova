package myapp.services.utils;

import myapp.persistence.dao.OrderDao;
import myapp.persistence.dao.OrdererDao;
import myapp.persistence.entities.OrderEntity;
import myapp.persistence.entities.OrdererEntity;
import myapp.persistence.entities.UserEntity;
import myapp.services.convertors.OrderConverter;
import myapp.services.convertors.OrdererConverter;
import myapp.views.OrderView;
import myapp.views.OrdererView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ejb.NoSuchEntityException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 13.04.2017.
 */
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    OrdererDao ordererDao;
    @Override
    public OrderEntity getOrderById(int id_order) {
        return orderDao.getById(id_order);
    }
    @Autowired
    private OrderConverter orderConverter;

    @Override
    public Map<String, Object> getOrderById(int id, Set<String> fields) throws NoSuchEntityException {
        return orderConverter.convert(getOrderById(id),fields);
    }

    @Override
    public List<OrderEntity> getAllOrders(int id_orderer) {
        return orderDao.getAllObjects(id_orderer);
    }

    @Override
    public List<Map<String, Object>> getAllOrdersMap( int id_orderer,Set<String> fields) throws NoSuchEntityException {
        return orderConverter.convert(getAllOrders(id_orderer), fields);
    }


    @Override
    public int addOrder(OrderView orderView) {
        return orderDao.insert(viewToEntity(orderView));
    }

    @Override
    public OrderEntity updateOrder(OrderView orderView) {
        orderDao.update(viewToEntity(orderView));
        return viewToEntity(orderView);
    }

    @Override
    public OrderEntity viewToEntity(OrderView view) {
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setId_order(view.getId_order());
        orderEntity.setHours(view.getHours());
        orderEntity.setObjects(view.getObjects());
        orderEntity.setWorkers(view.getWorkers());
        orderEntity.setSalary(view.getSalary());
        orderEntity.setId_orderer(view.getId_orderer());
        OrdererEntity orderer = ordererDao.get(view.getId_orderer());
        orderEntity.setOrderer_id_department(orderer.getId_department());
        return orderEntity;
    }
}
