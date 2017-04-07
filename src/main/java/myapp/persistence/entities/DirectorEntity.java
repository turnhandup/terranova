package myapp.persistence.entities;

import org.springframework.stereotype.Component;

/**
 * Created by PANNA on 01.04.2017.
 */
@Component
public class DirectorEntity {
    private int id_director;
    private int id_user;
    private int id_department;
    private String pib;
    private String address;
    private String marital_status;
    private double work_experience;

    public DirectorEntity(int id_director, int id_user, int id_department, String pib, String address, String marital_status, int work_experience) {
        this.id_director = id_director;
        this.id_user = id_user;
        this.id_department = id_department;
        this.pib = pib;
        this.address = address;
        this.marital_status = marital_status;
        this.work_experience = work_experience;
    }
    public DirectorEntity(){}
    @Override
    public String toString() {
        return "DirectorEntity{" +
                "id_director=" + id_director +
                ", id_user=" + id_user +
                ", id_department=" + id_department +
                ", pib='" + pib + '\'' +
                ", address='" + address + '\'' +
                ", marital_status='" + marital_status + '\'' +
                ", work_experience=" + work_experience +
                '}';
    }

    public int getId_director() {
        return id_director;
    }

    public void setId_director(int id_director) {
        this.id_director = id_director;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_department() {
        return id_department;
    }

    public void setId_department(int id_department) {
        this.id_department = id_department;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public double getWork_experience() {
        return work_experience;
    }

    public void setWork_experience(double work_experience) {
        this.work_experience = work_experience;
    }
}
