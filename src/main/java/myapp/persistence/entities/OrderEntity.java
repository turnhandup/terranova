package myapp.persistence.entities;

/**
 * Created by PANNA on 09.04.2017.
 */
public class OrderEntity {
    private int id_order;
    private int hours;
    private int objects;
    private int workers;
    private double salary;
    private int id_orderer;
    private int orderer_id_department;

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getObjects() {
        return objects;
    }

    public void setObjects(int objects) {
        this.objects = objects;
    }

    public int getWorkers() {
        return workers;
    }

    public void setWorkers(int workers) {
        this.workers = workers;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId_orderer() {
        return id_orderer;
    }

    public void setId_orderer(int id_orderer) {
        this.id_orderer = id_orderer;
    }

    public int getOrderer_id_department() {
        return orderer_id_department;
    }

    public void setOrderer_id_department(int orderer_id_department) {
        this.orderer_id_department = orderer_id_department;
    }


    @Override
    public String toString() {
        return "OrderEntity{" +
                "id_order=" + id_order +
                ", hours=" + hours +
                ", objects=" + objects +
                ", workers=" + workers +
                ", salary=" + salary +
                ", id_orderer=" + id_orderer +
                ", orderer_id_department=" + orderer_id_department +
                '}';
    }

    //    List<Integer> id_orders_has_objects;
//    List<Integer> id_objects;
    //List<OrdersHasObjectsEntity> ordersHasObjectsEntityList;
    //List<ObjectEntity> objectEntityList;
}
