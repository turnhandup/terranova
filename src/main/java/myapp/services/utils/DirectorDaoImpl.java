package myapp.services.utils;

import myapp.persistence.dao.DirectorDao;
import myapp.persistence.entities.DirectorEntity;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by PANNA on 01.04.2017.
 */
public class DirectorDaoImpl implements DirectorDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String GET="SELECT * FROM director WHERE id_director=?";
    private static final String INSERT = "INSERT INTO director (id_director,Users_id_user, Department_id_department,pib,address,marital_status, work_experience) VALUES  (?,?,?,?,?,?,?);";
    private static final String UPDATE="UPDATE director SET Users_id_user=?, Department_id_department=?, pib=?, address=?, marital_status=?, work_experience=? WHERE id_director=?";
    private static final String DELETE="DELETE FROM director WHERE id_director=?";
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
    public RowMapper<DirectorEntity> mapper = new RowMapper<DirectorEntity>() {
        public DirectorEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            DirectorEntity director = new DirectorEntity();
            director.setId_director(rs.getInt("id_director"));
            director.setId_user(rs.getInt("Users_id_user"));
            director.setId_department(rs.getInt("Department_id_department"));
            director.setPib(rs.getString("pib"));
            director.setAddress(rs.getString("address"));
            director.setMarital_status(rs.getString("marital_status"));
            director.setWork_experience(rs.getDouble("work_experience"));
            return director;
        }
    };
    public DirectorEntity get(int id_director) {

        return jdbcTemplate.queryForObject(GET,mapper,id_director);
    }

    public int insert(DirectorEntity director) {
        return jdbcTemplate.update(INSERT, director.getId_director(),director.getId_user(),director.getId_department(),director.getPib(),director.getAddress(),director.getMarital_status(),director.getWork_experience());
    }

    public void update(DirectorEntity director) {
         jdbcTemplate.update(UPDATE, director.getId_director(),director.getId_user(),director.getId_department(),director.getPib(),director.getAddress(),director.getMarital_status(),director.getWork_experience());

    }

    public void remove(DirectorEntity director) {
        jdbcTemplate.update(DELETE, director.getId_director());
    }
}
