package myapp.services.utils;

import myapp.persistence.entities.ArchitectorEntity;
import myapp.views.ArchitectorView;

import javax.ejb.NoSuchEntityException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 06.04.2017.
 */
public interface ArchitectorService {
    ArchitectorEntity getArchitectorById(int id);
    Map<String, Object> getArchitectorByIdMap(int id, Set<String> fields) throws NoSuchEntityException;
    List<ArchitectorEntity> getAllArchitectors(int offset,int limit);
    List<Map<String, Object>> getAllArchitectorsMap(int offset, int limit, Set<String> fields) throws NoSuchEntityException;
    void removeArchitector(ArchitectorEntity architector);
    ArchitectorEntity updateArchitector(ArchitectorEntity user);
    ArchitectorEntity updateArchitector(ArchitectorView architectorView);
    ArchitectorEntity viewToEntity(ArchitectorView view);
}
