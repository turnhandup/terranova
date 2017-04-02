package myapp.services.utils;

import myapp.persistence.dao.DepartmentDao;
import myapp.persistence.entities.DepartmentEntity;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.Cacheable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by PANNA on 01.04.2017.
 */
@Repository("department")

public class DepartmentDaoImpl implements DepartmentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String GET="SELECT * FROM department WHERE id=?";
    private static final String INSERT = "INSERT INTO department (address, email, phonenumber) VALUES  (?,?,?);";
    private static final String UPDATE="UPDATE department SET address=?, email=?, phonenumber=? WHERE id=?";
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
    public RowMapper<DepartmentEntity> mapper = new RowMapper<DepartmentEntity>() {
        public DepartmentEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            DepartmentEntity department = new DepartmentEntity();
            department.setId_department(rs.getInt("id_department"));
            department.setAddress(rs.getString("address"));
            department.setEmail(rs.getString("email"));
            department.setPhonenumber(rs.getString("phonenumber"));
            return department;
        }
    };
    public DepartmentEntity get(int id_department) {
        return jdbcTemplate.queryForObject(GET, mapper, id_department);    }

    public int insert(DepartmentEntity department) {
        return this.jdbcTemplate.update(INSERT,department.getAddress(),department.getEmail(),department.getPhonenumber());
    }

    public void update(DepartmentEntity department) {
        jdbcTemplate.update(UPDATE, department.getId_department(),department.getAddress(),department.getEmail(),department.getPhonenumber());
    }

    public void remove(DepartmentEntity department) {
        jdbcTemplate.update(DELETE, department.getId_department());
    }
}
