package myapp.services.utils;

import myapp.persistence.dao.ObjectDao;
import myapp.persistence.entities.ObjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by PANNA on 12.04.2017.
 */
public class ObjectDaoImpl implements ObjectDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String GET="SELECT * FROM objects WHERE id_object=?;";
    private final String GETALL="SELECT * FROM objects";
    private final String GETALLBYARCHITECTOR="SELECT * FROM objects WHERE Architectors_id_architector=?;";
    private final String INSERT="INSERT INTO objects (status,detalisation,software,hours) VALUES (?,?,?,?);";
    private final String UPDATEARCHITECTOR="UPDATE objects SET  Architectors_id_architector=?";
    private final String UPDATE="UPDATE objects SET status=?, detalisation=?, software=?, hours=? WHERE id_object=?";
    private final String REMOVE=" DELETE objects,orders_has_objects FROM orders_has_objects INNER JOIN objects WHERE id_object=1 AND objects.id_object=Orders_has_objects.Objects_id_object ;";

    public RowMapper<ObjectEntity> mapper = new RowMapper<ObjectEntity>() {
        public ObjectEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            ObjectEntity objectEntity = new ObjectEntity();
            objectEntity.setId_object(rs.getInt("id_object"));
            objectEntity.setId_architector(rs.getInt("Architectors_id_architector"));
            objectEntity.setStatus(rs.getBoolean("status"));
            objectEntity.setDetalisation(rs.getInt("detalisation"));
            objectEntity.setSoftware(rs.getString("software"));
            objectEntity.setHours(rs.getInt("hours"));
            return objectEntity;
        }
    };

    @Override
    public ObjectEntity getById(int id_object) {
        return jdbcTemplate.queryForObject(GET,mapper, id_object);
    }

    @Override
    public List<ObjectEntity> getAllObjects() {
        return jdbcTemplate.query(GETALL,mapper);
    }

    @Override
    public List<ObjectEntity> getObjectByArchitector(int id_architector) {
        return jdbcTemplate.query(GETALLBYARCHITECTOR,mapper);
    }

    @Override
    public int insert(ObjectEntity objectEntity) {
        return jdbcTemplate.update(INSERT, mapper, objectEntity.isStatus(), objectEntity.getDetalisation(), objectEntity.getSoftware(), objectEntity.getHours());
    }

    @Override
    public void remove(ObjectEntity objectEntity) {
            jdbcTemplate.update(REMOVE, mapper, objectEntity.getId_object());
    }

    @Override
    public void update(ObjectEntity objectEntity) {
        jdbcTemplate.update(UPDATE,objectEntity.isStatus(),objectEntity.getDetalisation(),objectEntity.getSoftware(), objectEntity.getHours(),objectEntity.getId_object());
    }
}
