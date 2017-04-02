package myapp.persistence.entities;

import org.springframework.stereotype.Component;

/**
 * Created by PANNA on 01.04.2017.
 */
@Component
public class DepartmentEntity {
    private int id_department;
    private String address;
    private String email;
    private String phonenumber;

    public DepartmentEntity(int id_department, String address, String email, String phonenumber) {
        this.id_department = id_department;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
    }
    public DepartmentEntity(){}
    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "id_department=" + id_department +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }

    public int getId_department() {
        return id_department;
    }

    public void setId_department(int id_department) {
        this.id_department = id_department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }


}
