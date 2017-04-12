package myapp.persistence.entities;

import java.util.List;

/**
 * Created by PANNA on 09.04.2017.
 */
public class OrdererEntity {
    private int id_orderer;
    private int id_user;
    private int id_department;
    List<Integer> id_orders;
    private String pib;
    private String company_name;
    private String phone_number;
    private String passport_data;
    private String email;
    private String address;
    DepartmentEntity departmentEntity;
    UserEntity userEntity;
    List<OrderEntity> orderEntities;

    @Override
    public String toString() {
        return "OrdererEntity{" +
                "id_orderer=" + id_orderer +
                ", id_user=" + id_user +
                ", id_department=" + id_department +
                ", id_orders=" + id_orders +
                ", pib='" + pib + '\'' +
                ", company_name='" + company_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", passport_data='" + passport_data + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", departmentEntity=" + departmentEntity +
                ", userEntity=" + userEntity +
                ", orderEntities=" + orderEntities +
                '}';
    }

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public List<OrderEntity> getOrderEntities() {
        return orderEntities;
    }

    public void setOrderEntities(List<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }

    public int getId_orderer() {
        return id_orderer;
    }

    public void setId_orderer(int id_orderer) {
        this.id_orderer = id_orderer;
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

    public List<Integer> getId_orders() {
        return id_orders;
    }

    public void setId_orders(List<Integer> id_orders) {
        this.id_orders = id_orders;
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

    public String getPassport_data() {
        return passport_data;
    }

    public void setPassport_data(String passport_data) {
        this.passport_data = passport_data;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdererEntity that = (OrdererEntity) o;

        if (id_orderer != that.id_orderer) return false;
        if (id_user != that.id_user) return false;
        if (id_department != that.id_department) return false;
        if (id_orders != null ? !id_orders.equals(that.id_orders) : that.id_orders != null) return false;
        if (pib != null ? !pib.equals(that.pib) : that.pib != null) return false;
        if (company_name != null ? !company_name.equals(that.company_name) : that.company_name != null) return false;
        if (phone_number != null ? !phone_number.equals(that.phone_number) : that.phone_number != null) return false;
        if (passport_data != null ? !passport_data.equals(that.passport_data) : that.passport_data != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (departmentEntity != null ? !departmentEntity.equals(that.departmentEntity) : that.departmentEntity != null)
            return false;
        if (userEntity != null ? !userEntity.equals(that.userEntity) : that.userEntity != null) return false;
        return orderEntities != null ? orderEntities.equals(that.orderEntities) : that.orderEntities == null;
    }

    @Override
    public int hashCode() {
        int result = id_orderer;
        result = 31 * result + id_user;
        result = 31 * result + id_department;
        result = 31 * result + (id_orders != null ? id_orders.hashCode() : 0);
        result = 31 * result + (pib != null ? pib.hashCode() : 0);
        result = 31 * result + (company_name != null ? company_name.hashCode() : 0);
        result = 31 * result + (phone_number != null ? phone_number.hashCode() : 0);
        result = 31 * result + (passport_data != null ? passport_data.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (departmentEntity != null ? departmentEntity.hashCode() : 0);
        result = 31 * result + (userEntity != null ? userEntity.hashCode() : 0);
        result = 31 * result + (orderEntities != null ? orderEntities.hashCode() : 0);
        return result;
    }
}
