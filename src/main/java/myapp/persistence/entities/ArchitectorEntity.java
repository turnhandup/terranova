package myapp.persistence.entities;

import org.springframework.stereotype.Component;

/**
 * Created by PANNA on 01.04.2017.
 */
@Component
public class ArchitectorEntity {
    private int id_architector;
    private int id_user;
    private String pib;
    private int hours;
    private int work_experience;
    private String email;
    private String phone_number;

    public ArchitectorEntity(int id_architector, int id_user, String pib, int hours, int work_experience, String email, String phone_number) {
        this.id_architector = id_architector;
        this.id_user = id_user;
        this.pib = pib;
        this.hours = hours;
        this.work_experience = work_experience;
        this.email = email;
        this.phone_number = phone_number;
    }
    public ArchitectorEntity(){}
    @Override
    public String toString() {
        return "ArchitectorEntity{" +
                "id_architector=" + id_architector +
                ", id_user=" + id_user +
                ", pib='" + pib + '\'' +
                ", hours=" + hours +
                ", work_experience=" + work_experience +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
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
}
