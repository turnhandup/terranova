package myapp.services.convertors;

/**
 * Created by PANNA on 06.04.2017.
 */
public class Fields {
    public static class Architector {
        public static final String ID = "id_architector";
        public static final String EMAIL = "email";
        public static final String PIB = "pib";
        public static final String HOURS = "hours";
        public static final String WORK_EXPERIENCE = "work_experience";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String USERSID="Users_id_user";
        public static final String DEFAULT="id_architector";
        public static final String LOGIN="login";
        public static final String PASSWORD="password";
        public static final String ENABLED="enabled";
    }

    public static class Orderer{
        public static final String ID="id_orderer";
        public static final String IDUSER="id_user";
        public static final String LOGIN="login";
        public static final String PASSWORD="password";
        public static final String ENABLED="enabled";
        public static final String DEPARTMENTADDRESS="departmentaddress";
        public static final String DEPARTMENTPHONE="departmentphonenumber";
        public static final String DEPARTMENTEMAIL="departmentemail";
        public static final String IDDEPARTMENT="id_department";
        public static final String PIB="pib";
        public static final String COMPANY_NAME="company_name";
        public static final String PHONE_NUMBER="phone_number";
        public static final String PASSPORT_DATA="passport_data";
        public static final String EMAIL="email";
        public static final String ADDRESS="address";
        public static final String DEFAULT="id_orderer";
    }
    public static class Object{
        public static final String ID="id_object";
        public static final String STATUS="status";
        public static final String DETALISATION="detalisation";
        public static final String SOFTWARE="software";
        public static final String HOURS="hours";
        public static final String IDARCHITECTOR="id_architector";
        public static final String DEFAULT="id_object";
    }

    public static class Order{
        public static final String ID="id_order";
        public static final String HOURS ="hours";
        public static final String OBJECTS="objects";
        public static final String WORKERS="workers";
        public static final String SALARY="salary";
        public static final String IDORDERER="id_orderer";
        public static final String IDORDERERDEPARTMENT="orderer_id_department";
        public static final String DEFAULT="id_order";
    }
}
