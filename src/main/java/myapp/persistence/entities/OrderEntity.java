package myapp.persistence.entities;

import java.util.List;

/**
 * Created by PANNA on 09.04.2017.
 */
public class OrderEntity {
    private int id_order;
    List<Integer> id_orders_has_objects;
    List<Integer> id_objects;
    private int hours;
    private int objects;
    private int workers;
    private double salary;
    //List<OrdersHasObjectsEntity> ordersHasObjectsEntityList;
    //List<ObjectEntity> objectEntityList;
}
