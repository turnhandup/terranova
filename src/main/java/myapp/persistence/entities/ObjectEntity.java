package myapp.persistence.entities;

/**
 * Created by PANNA on 11.04.2017.
 */
public class ObjectEntity {
    private int id_object;
    private int id_architector;
    private boolean status;
    private int detalisation;
    private String software;
    private int hours;

    @Override
    public String toString() {
        return "ObjectEntity{" +
                "id_object=" + id_object +
                ", id_architector=" + id_architector +
                ", status=" + status +
                ", detalisation=" + detalisation +
                ", software='" + software + '\'' +
                ", hours=" + hours +
                '}';
    }

    public ObjectEntity() {
    }

    public int getId_object() {

        return id_object;
    }

    public void setId_object(int id_object) {
        this.id_object = id_object;
    }

    public int getId_architector() {
        return id_architector;
    }

    public void setId_architector(int id_architector) {
        this.id_architector = id_architector;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getDetalisation() {
        return detalisation;
    }

    public void setDetalisation(int detalisation) {
        this.detalisation = detalisation;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
