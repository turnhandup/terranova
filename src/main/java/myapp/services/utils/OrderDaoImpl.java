package myapp.services.utils;

import myapp.persistence.dao.OrderDao;
import myapp.persistence.entities.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by PANNA on 13.04.2017.
 */
@Repository("orders")
public class OrderDaoImpl implements OrderDao {
    private static String GET="SELECT * FROM orders WHERE orders.id_order=? ";
    private static String GETALL ="SELECT id_order,hours,objects,workers,salary,orders.Orderer_id_orderer,orders.Orderer_Department_id_department FROM orders,orderer WHERE orderer.Users_id_user=? AND orderer.id_orderer=orders.Orderer_id_orderer";
    private static String INSERT="INSERT INTO orders (hours, objects, workers, salary, Orderer_id_orderer, Orderer_Department_id_department) VALUES (?, ?, ?, ?, ?, ?)";
    private static String UPDATE="UPDATE orders SET hours=?, objects=?, workers=?, salary=? WHERE orders.id_order=?";



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public OrderEntity getById(int id_order) {
        return jdbcTemplate.queryForObject(GET, mapper, id_order);
    }

    @Override
    public List<OrderEntity> getAllObjects(int id_orderer) {
        return jdbcTemplate.query(GETALL, mapper, id_orderer);
    }

    @Override
    public int insert(OrderEntity orderEntity) {
        //TODO тут повинен повертатися ідішнік створеного об'єкта але як це зробити з jdbcTemplate я не їбу тому тут повертається 1
        return jdbcTemplate.update(INSERT, orderEntity.getHours(), orderEntity.getObjects(), orderEntity.getWorkers(), orderEntity.getSalary(), orderEntity.getId_orderer(), orderEntity.getOrderer_id_department());
    }

    @Override
    public void remove(OrderEntity objectEntity) {
        System.out.println("Unsupported operation!");
    }

    @Override
    public int update(OrderEntity objectEntity) {
        return jdbcTemplate.update(UPDATE, objectEntity.getHours(), objectEntity.getObjects(), objectEntity.getWorkers(), objectEntity.getSalary(), objectEntity.getId_order());

    }

    public RowMapper<OrderEntity> mapper = new RowMapper<OrderEntity>() {
        public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            OrderEntity orderEntity=new OrderEntity();
            orderEntity.setId_order(rs.getInt("orders.id_order"));
            orderEntity.setHours(rs.getInt("orders.hours"));
            orderEntity.setObjects(rs.getInt("orders.objects"));
            orderEntity.setWorkers(rs.getInt("orders.workers"));
            orderEntity.setSalary(rs.getDouble("orders.salary"));
            orderEntity.setId_orderer(rs.getInt("orders.Orderer_id_orderer"));
            orderEntity.setOrderer_id_department(rs.getInt("orders.Orderer_Department_id_department"));
            return orderEntity;
        }
    };
}
