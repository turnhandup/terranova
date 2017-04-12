package myapp.services.convertors;

import myapp.persistence.entities.OrdererEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static myapp.services.convertors.Fields.Orderer.*;

/**
 * Created by PANNA on 09.04.2017.
 */
@Component
public class OrdererConverter extends Converter<OrdererEntity>  {
    @Override
    public Map<String, Object> convert(OrdererEntity object, Set<String> fields) {
            Map<String, Object> map = new HashMap<>();
            if(fields.contains(ID))
                map.put(ID, object.getId_orderer());
            if(fields.contains(IDUSER))
                map.put(IDUSER,object.getId_user());
            if(fields.contains(IDDEPARTMENT))
                map.put(IDDEPARTMENT,object.getId_department());
            if(fields.contains(PIB))
                map.put(PIB, object.getPib());
            if(fields.contains(COMPANY_NAME))
                map.put(COMPANY_NAME,object.getCompany_name());
             if(fields.contains(EMAIL))
            map.put(EMAIL, object.getEmail());
            if(fields.contains(PASSPORT_DATA))
                map.put(PASSPORT_DATA, object.getPassport_data());
            if(fields.contains(PHONE_NUMBER))
                map.put(PHONE_NUMBER, object.getPhone_number());
            if(fields.contains(ADDRESS))
                map.put(ADDRESS, object.getAddress());
            if(fields.contains(LOGIN)){
                map.put(LOGIN, object.getUserEntity().getLogin());
            }
            if (fields.contains(PASSWORD)) {
               map.put(PASSWORD,object.getUserEntity().getPassword());
            }
            if(fields.contains(ENABLED)){
                map.put(ENABLED, object.getUserEntity().getEnabled());
                System.out.println(object.getUserEntity().getEnabled());
            }
            if(fields.contains(DEPARTMENTADDRESS)){
                map.put(DEPARTMENTADDRESS, object.getDepartmentEntity().getAddress());
                System.out.println(object.getDepartmentEntity().getAddress());
            }
            if(fields.contains(DEPARTMENTPHONE)){
                map.put(DEPARTMENTPHONE,object.getDepartmentEntity().getPhonenumber());
            }
            if(fields.contains(DEPARTMENTEMAIL)){
                map.put(DEPARTMENTEMAIL,object.getDepartmentEntity().getEmail());
            }
            return map;
    }
}
