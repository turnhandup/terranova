package myapp.persistence.dao;

import myapp.persistence.entities.ArchitectorEntity;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by PANNA on 01.04.2017.
 */
public interface ArchitectorDao {
    ArchitectorEntity get(int id_architector);
    int insert(ArchitectorEntity architector);
    void update(ArchitectorEntity architector);
    void remove(ArchitectorEntity architector);
    List<ArchitectorEntity> findAll();
}
