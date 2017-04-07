package myapp.services.utils;

import myapp.persistence.entities.ArchitectorEntity;
import myapp.persistence.entities.UserEntity;

import javax.ejb.NoSuchEntityException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 06.04.2017.
 */
public interface ArchitectorService {
    public ArchitectorEntity getArchitectorById(int id);
    Map<String, Object> getArchitectorByIdMap(int id, Set<String> fields) throws NoSuchEntityException;
    public List<ArchitectorEntity> getAllArchitectors();
    public List<Map<String, Object>> getAllArchitectorsMap(int offset, int limit, Set<String> fields) throws NoSuchEntityException;
    public void removeArchitector(ArchitectorEntity architector);
    public void updateArchitector(ArchitectorEntity user);
}
