package myapp.persistence.dao;

import myapp.persistence.entities.CustomQueriesEntities.*;

import java.util.List;

/**
 * Created by PANNA on 13.04.2017.
 */
public interface CustomQueriesDao {
//кількість пропрацьованих архітекторами годин
    List<WorkDone> workDone();
}
