package myapp.views;

/**
 * Created by PANNA on 13.04.2017.
 */
public class OrderView {
    private int id_order;
    private int hours;
    private int objects;
    private int workers;
    private double salary;
    private int id_orderer;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderView)) return false;

        OrderView orderView = (OrderView) o;

        if (getId_order() != orderView.getId_order()) return false;
        if (getHours() != orderView.getHours()) return false;
        if (getObjects() != orderView.getObjects()) return false;
        if (getWorkers() != orderView.getWorkers()) return false;
        if (Double.compare(orderView.getSalary(), getSalary()) != 0) return false;
        return getId_orderer() == orderView.getId_orderer();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId_order();
        result = 31 * result + getHours();
        result = 31 * result + getObjects();
        result = 31 * result + getWorkers();
        temp = Double.doubleToLongBits(getSalary());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getId_orderer();
        return result;
    }

    @Override
    public String toString() {
        return "OrderView{" +
                "id_order=" + id_order +
                ", hours=" + hours +
                ", objects=" + objects +
                ", workers=" + workers +
                ", salary=" + salary +
                ", id_orderer=" + id_orderer +
                '}';
    }
}
