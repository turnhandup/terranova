package myapp.services.convertors;

import myapp.persistence.entities.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static myapp.services.convertors.Fields.Order.*;


/**
 * Created by PANNA on 13.04.2017.
 */
@Component
public class OrderConverter extends Converter<OrderEntity> {
    @Override
    public Map<String, Object> convert(OrderEntity object, Set<String> fields) {
        Map<String, Object> map = new HashMap<>();
        if(fields.contains(ID))
            map.put(ID, object.getId_order());
        if(fields.contains(HOURS))
            map.put(HOURS,object.getHours());
        if(fields.contains(OBJECTS))
            map.put(OBJECTS,object.getObjects());
        if(fields.contains(WORKERS))
            map.put(WORKERS, object.getWorkers());
        if(fields.contains(SALARY))
            map.put(SALARY,object.getSalary());
        if(fields.contains(IDORDERER))
            map.put(IDORDERER, object.getId_orderer());
        if(fields.contains(IDORDERERDEPARTMENT))
            map.put(IDORDERERDEPARTMENT, object.getOrderer_id_department());
        return map;
    }
}
