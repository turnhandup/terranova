package myapp.services.convertors;

import myapp.persistence.entities.ObjectEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Component;

import static myapp.services.convertors.Fields.Object.*;

/**
 * Created by PANNA on 12.04.2017.
 */
@Component
public class ObjectConverter extends Converter<ObjectEntity> {

    @Override
    public Map<String, Object> convert(ObjectEntity object, Set<String> fields) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(fields.toString());
        if(fields.contains(ID)) {
            map.put(ID, object.getId_object());
        }
        if(fields.contains(STATUS)) {
            map.put(STATUS, object.isStatus());
        }
        if(fields.contains(DETALISATION)) {
            map.put(DETALISATION, object.getDetalisation());
        }
        if(fields.contains(SOFTWARE)) {
            map.put(SOFTWARE, object.getSoftware());
        }
        if(fields.contains(HOURS)){
            map.put(HOURS,object.getHours());
        }
        if(fields.contains(IDARCHITECTOR)){
            map.put(IDARCHITECTOR, object.getId_architector());
        }
        return map;
    }
}
