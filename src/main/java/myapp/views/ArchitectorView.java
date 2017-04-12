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
    private UserView user;

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
                ", user=" + user +
                '}';
    }

    public UserView getUser() {
        return user;
    }

    public void setUser(UserView user) {
        this.user = user;
    }

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
        if (!(o instanceof ArchitectorView)) return false;

        ArchitectorView that = (ArchitectorView) o;

        if (getId_architector() != that.getId_architector()) return false;
        if (getId_user() != that.getId_user()) return false;
        if (getHours() != that.getHours()) return false;
        if (getWork_experience() != that.getWork_experience()) return false;
        if (!getPib().equals(that.getPib())) return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getPhone_number() != null ? !getPhone_number().equals(that.getPhone_number()) : that.getPhone_number() != null)
            return false;
        return getUser().equals(that.getUser());
    }

    @Override
    public int hashCode() {
        int result = getId_architector();
        result = 31 * result + getId_user();
        result = 31 * result + getPib().hashCode();
        result = 31 * result + getHours();
        result = 31 * result + getWork_experience();
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPhone_number() != null ? getPhone_number().hashCode() : 0);
        result = 31 * result + getUser().hashCode();
        return result;
    }
}
