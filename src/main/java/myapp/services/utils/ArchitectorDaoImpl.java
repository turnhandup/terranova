package myapp.services.utils;

import myapp.persistence.dao.ArchitectorDao;
import myapp.persistence.entities.ArchitectorEntity;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by PANNA on 01.04.2017.
 */
public class ArchitectorDaoImpl implements ArchitectorDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String GET="SELECT * FROM department WHERE id=?";
    private static final String INSERT = "INSERT INTO department (address, e-mail, phonenumber) VALUES  (?,?,?);";
    private static final String UPDATE="UPDATE department SET address=?, e-mail=?, phonenumber=? WHERE id=?";
    private static final String DELETE="DELETE FROM department WHERE id=?";
    private BasicDataSource dataSource;
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void setDataSource(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }
    public BasicDataSource getDataSource() {
        return dataSource;
    }
    public RowMapper<ArchitectorEntity> mapper = new RowMapper<ArchitectorEntity>() {
        public ArchitectorEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            ArchitectorEntity architector = new ArchitectorEntity();

            return architector;
        }
    };
    public ArchitectorEntity get(int id_architector) {
        return null;
    }

    public int insert(ArchitectorEntity architector) {
        return 0;
    }

    public void update(ArchitectorEntity architector) {

    }

    public void remove(ArchitectorEntity architector) {

    }
}
