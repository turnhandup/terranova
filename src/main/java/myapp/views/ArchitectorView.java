package myapp.views;

/**
 * Created by PANNA on 08.04.2017.
 */
public class ArchitectorView {
    private int id_architector;
    private int id_user;
    private String pib;
    private int hours;
    private int work_experience;
    private String email;
    private String phone_number;

    public int getId_architector() {
        return id_architector;
    }

    public void setId_architector(int id_architector) {
        this.id_architector = id_architector;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getWork_experience() {
        return work_experience;
    }

    public void setWork_experience(int work_experience) {
        this.work_experience = work_experience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArchitectorView that = (ArchitectorView) o;

        if (id_architector != that.id_architector) return false;
        if (id_user != that.id_user) return false;
        if (hours != that.hours) return false;
        if (work_experience != that.work_experience) return false;
        if (pib != null ? !pib.equals(that.pib) : that.pib != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return phone_number != null ? phone_number.equals(that.phone_number) : that.phone_number == null;
    }

    @Override
    public int hashCode() {
        int result = id_architector;
        result = 31 * result + id_user;
        result = 31 * result + (pib != null ? pib.hashCode() : 0);
        result = 31 * result + hours;
        result = 31 * result + work_experience;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone_number != null ? phone_number.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ArchitectorView{" +
                "id_architector=" + id_architector +
                ", id_user=" + id_user +
                ", pib='" + pib + '\'' +
                ", hours=" + hours +
                ", work_experience=" + work_experience +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
