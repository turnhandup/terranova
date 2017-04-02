package myapp.services.utils;

import javafx.scene.chart.PieChart;
import myapp.persistence.dao.UserDao;
import myapp.persistence.entities.UserEntity;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by PANNA on 01.04.2017.
 */
@Repository("users")
@Cacheable("users")
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String GET="SELECT * FROM users WHERE login=?";
    private static final String INSERT = "INSERT INTO users (login, password, role, active) VALUES  (?,?,?,?);";
    private static final String UPDATE="UPDATE users SET password=?, role=?, active=? WHERE login=?";
    private static final String DELETE="DELETE FROM users WHERE login=?";
    private BasicDataSource dataSource;

    public UserEntity get(String login) {
        System.out.println(GET);
     return jdbcTemplate.queryForObject(GET, mapper, login);
    }

    public int insert(UserEntity user) {
        System.out.println(user.getLogin());
        return this.jdbcTemplate.update(INSERT,user.getLogin(),user.getPassword(),user.getRole(),user.getActive());
    }

    public void update(UserEntity user) {
        jdbcTemplate.update(UPDATE,user.getLogin(), user.getActive(),user.getPassword(),user.getRole());
    }

    public void remove(UserEntity user) {
        jdbcTemplate.update(DELETE, user.getLogin());
    }

    public RowMapper<UserEntity> mapper = new RowMapper<UserEntity>() {
        public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserEntity user = new UserEntity();
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setActive((rs.getInt("active")));
            user.setRole(rs.getInt("role"));
            return user;
        }
    };

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
}
