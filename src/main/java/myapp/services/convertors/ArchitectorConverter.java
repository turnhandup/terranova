package myapp.services.convertors;

import myapp.persistence.entities.ArchitectorEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import myapp.services.convertors.Fields.Architector.*;
import org.springframework.stereotype.Component;

import static myapp.services.convertors.Fields.Architector.*;

/**
 * Created by PANNA on 06.04.2017.
 */
@Component
public class ArchitectorConverter extends Converter<ArchitectorEntity> {
    public Map<String, Object> convert(ArchitectorEntity object, Set<String> fields) {
        Map<String, Object> map = new HashMap<>();
        if(fields.contains(ID)) {
            map.put(ID, object.getId_architector());
            System.out.println(object.getId_architector());
        }
        if(fields.contains(EMAIL))
            map.put(EMAIL, object.getEmail());
        if(fields.contains(PIB))
            map.put(PIB, object.getPib());
        if(fields.contains(HOURS))
            map.put(HOURS, object.getHours());
        if(fields.contains(PHONE_NUMBER))
            map.put(PHONE_NUMBER, object.getPhone_number());
        if(fields.contains(WORK_EXPERIENCE))
            map.put(WORK_EXPERIENCE, object.getWork_experience());
        if(fields.contains(USERSID))
            map.put(USERSID, object.getId_user());
        return map;
    }
}