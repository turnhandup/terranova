package myapp.views;

/**
 * Created by PANNA on 12.04.2017.
 */
public class ObjectView {
    private int id_object;
    private int id_architector;
    private boolean status;
    private int detalisation;
    private String software;
    private int hours;

    @Override
    public String toString() {
        return "ObjectView{" +
                "id_object=" + id_object +
                ", id_architector=" + id_architector +
                ", status=" + status +
                ", detalisation=" + detalisation +
                ", software='" + software + '\'' +
                ", hours=" + hours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjectView)) return false;

        ObjectView that = (ObjectView) o;

        if (getId_object() != that.getId_object()) return false;
        if (getId_architector() != that.getId_architector()) return false;
        if (isStatus() != that.isStatus()) return false;
        if (getDetalisation() != that.getDetalisation()) return false;
        if (getHours() != that.getHours()) return false;
        return getSoftware() != null ? getSoftware().equals(that.getSoftware()) : that.getSoftware() == null;
    }

    @Override
    public int hashCode() {
        int result = getId_object();
        result = 31 * result + getId_architector();
        result = 31 * result + (isStatus() ? 1 : 0);
        result = 31 * result + getDetalisation();
        result = 31 * result + (getSoftware() != null ? getSoftware().hashCode() : 0);
        result = 31 * result + getHours();
        return result;
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
