package myapp.views;

import myapp.persistence.entities.DepartmentEntity;
import myapp.persistence.entities.UserEntity;

/**
 * Created by PANNA on 09.04.2017.
 */
public class OrdererView {
    private int id_orderer;
    private int id_department;
    private String pib;
    private String company_name;
    private String phone_number;
    private String email;
    private String address;
    private String passport_data;
    private UserView user;

    public UserView getUser() {
        return user;
    }

    public void setUser(UserView user) {
        this.user = user;
    }

    public int getId_orderer() {
        return id_orderer;
    }

    public void setId_orderer(int id_orderer) {
        this.id_orderer = id_orderer;
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

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassport_data() {
        return passport_data;
    }

    public void setPassport_data(String passport_data) {
        this.passport_data = passport_data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrdererView)) return false;

        OrdererView that = (OrdererView) o;

        if (getId_orderer() != that.getId_orderer()) return false;
        if (getId_department() != that.getId_department()) return false;
        if (!getPib().equals(that.getPib())) return false;
        if (!getCompany_name().equals(that.getCompany_name())) return false;
        if (getPhone_number() != null ? !getPhone_number().equals(that.getPhone_number()) : that.getPhone_number() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getAddress() != null ? !getAddress().equals(that.getAddress()) : that.getAddress() != null) return false;
        if (getPassport_data() != null ? !getPassport_data().equals(that.getPassport_data()) : that.getPassport_data() != null)
            return false;
        return getUser() != null ? getUser().equals(that.getUser()) : that.getUser() == null;
    }

    @Override
    public int hashCode() {
        int result = getId_orderer();
        result = 31 * result + getId_department();
        result = 31 * result + getPib().hashCode();
        result = 31 * result + getCompany_name().hashCode();
        result = 31 * result + (getPhone_number() != null ? getPhone_number().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getPassport_data() != null ? getPassport_data().hashCode() : 0);
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        return result;
    }
}
