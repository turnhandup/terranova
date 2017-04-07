package myapp.services.utils;

import myapp.persistence.dao.ArchitectorDao;
import myapp.persistence.entities.ArchitectorEntity;
import myapp.persistence.entities.UserEntity;
import myapp.services.convertors.ArchitectorConverter;
import org.springframework.transaction.annotation.Transactional;
import javax.ejb.NoSuchEntityException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 06.04.2017.
 */
public class ArchitectorServiceImpl implements ArchitectorService{
    private ArchitectorDao architectorDao;
    private ArchitectorConverter architectorConverter;
    public ArchitectorDao getArchitectorDao() {

        return architectorDao;
    }
    @Transactional
    public void setArchitectorDao(ArchitectorDao architectorDao) {
        this.architectorDao = architectorDao;
    }
    public ArchitectorEntity getArchitectorById(int id) {
        ArchitectorEntity architector=architectorDao.get(id);
        if(architector==null){
            throw new NoSuchEntityException();
        }
        return architector;
    }
    @Transactional
    public Map<String, Object> getArchitectorByIdMap(int id, Set<String> fields) throws NoSuchEntityException {
        return architectorConverter.convert(getArchitectorById(id),fields);
    }

    public List<ArchitectorEntity> getAllArchitectors() {
        List<ArchitectorEntity> list=architectorDao.findAll();
        if(list==null||list.isEmpty()){
            throw new NoSuchEntityException();
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getAllArchitectorsMap(int offset, int limit, Set<String> fields) throws NoSuchEntityException {
        return architectorConverter.convert(getAllArchitectors(),fields);
    }

    public void removeArchitector(ArchitectorEntity architector) {
        architectorDao.remove(architector);
    }
    public void updateArchitector(ArchitectorEntity architector) {
        architectorDao.update(architector);
    }
}
