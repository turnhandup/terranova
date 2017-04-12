package myapp.services.utils;

import myapp.persistence.dao.OrdererDao;
import myapp.persistence.entities.DepartmentEntity;
import myapp.persistence.entities.OrdererEntity;
import myapp.persistence.entities.UserEntity;
import myapp.services.convertors.OrdererConverter;
import myapp.views.OrdererView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ejb.NoSuchEntityException;
import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 09.04.2017.
 */
public class OrdererServiceImpl implements  OrdererService {
    @Autowired
    private OrdererDao ordererDao;

    @Autowired
    private OrdererConverter ordererConverter;
    @Override
    public OrdererEntity getOrdererById(int id) {
        OrdererEntity orderer=ordererDao.get(id);
        return orderer;
    }

    @Override
    public Map<String, Object> getOrdererById(int id, Set<String> fields) throws NoSuchEntityException {
        return ordererConverter.convert(getOrdererById(id),fields);
    }

    @Override
    public List<OrdererEntity> getAllOrderers(int offset, int limit) {
        List<OrdererEntity> list=ordererDao.getAll();
        return list;
    }

    @Override
    public List<Map<String, Object>> getAllOrderersMap(int offset, int limit, Set<String> fields) throws NoSuchEntityException {
        return ordererConverter.convert(getAllOrderers(offset, limit), fields);
    }

    @Override
    public List<OrdererEntity> getAllOrderersByDep(int offset, int limit,int id) {
        List<OrdererEntity> list=ordererDao.getAllByDepartment(id);
        return list;
    }

    @Override
    public List<Map<String, Object>> getAllOrderersByDepMap(int offset, int limit, int id, Set<String> fields) throws NoSuchEntityException {
        return ordererConverter.convert(getAllOrderersByDep(offset, limit, id), fields);    }

    @Override
    public void removeOrderer(OrdererEntity orderer) {

    }

    @Override
    public int create(OrdererView ordererView) {
//        try{
//            OrdererEntity ordererEntity = viewToEntity(ordererView);
//            ordererDao.insert(ordererEntity);
//            System.out.println(ordererEntity.getUserEntity().getId_user());
//            OrdererEntity ordererEntity1=getOrdererById(ordererEntity.getId_orderer());
//            throw new EntityExistsException();
//        } catch (NoSuchEntityException e) {
            OrdererEntity ordererEntity = viewToEntity(ordererView);
            ordererDao.insert(ordererEntity);
            return ordererEntity.getId_user();
        }
//    }

    @Override
    public OrdererEntity updateOrderer(OrdererEntity orderer) {
        OrdererEntity updatedOrderer = ordererDao.get(orderer.getId_orderer());
        if (updatedOrderer == null)
            throw new NoSuchEntityException();
        updatedOrderer.setId_orderer(orderer.getId_orderer());
        updatedOrderer.setId_user(orderer.getId_user());
        updatedOrderer.setId_department(orderer.getId_department());
        updatedOrderer.setEmail(orderer.getEmail());
        updatedOrderer.setPib(orderer.getPib());
        updatedOrderer.setCompany_name(orderer.getCompany_name());
        updatedOrderer.setPhone_number(orderer.getPhone_number());
        updatedOrderer.setPassport_data(orderer.getPassport_data());
        updatedOrderer.setAddress(orderer.getAddress());
        updatedOrderer.setUserEntity(orderer.getUserEntity());
        ordererDao.update(updatedOrderer);
        return updatedOrderer;    }

    @Override
    public OrdererEntity updateOrderer(OrdererView ordererView) {
        return updateOrderer(viewToEntity(ordererView));
    }

    @Override
    public OrdererEntity viewToEntity(OrdererView view) {
        OrdererEntity ordererEntity=new OrdererEntity();
        ordererEntity.setId_orderer(view.getId_orderer());
        ordererEntity.setId_department(view.getId_department());
        ordererEntity.setPib(view.getPib());
        ordererEntity.setCompany_name(view.getCompany_name());
        ordererEntity.setPhone_number(view.getPhone_number());
        ordererEntity.setPassport_data(view.getPassport_data());
        ordererEntity.setEmail(view.getEmail());
        ordererEntity.setAddress(view.getAddress());
        UserEntity user=new UserEntity();
        user.setLogin(view.getUser().getLogin());
        user.setPassword(view.getUser().getPassword());
        ordererEntity.setUserEntity(user);
        ordererEntity.setId_department(view.getId_department());
        System.out.println("VIEW TO ENTITY: "+ ordererEntity.toString());
        return ordererEntity;
    }
}
