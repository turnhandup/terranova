package myapp.services.utils;

import myapp.persistence.dao.UserDao;
import myapp.persistence.entities.UserEntity;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
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

    private static final String GET="SELECT * FROM users WHERE login=?";
    private static final String INSERT = "INSERT INTO users (login, password, role, enabled) VALUES  (?,MD5(?),?,?);";
    private static final String UPDATE="UPDATE users SET password=?, role=?, enabled=? WHERE login=?";
    private static final String DELETE="DELETE FROM users WHERE login=?";
    private static final String VALIDATE="SELECT count(1) FROM users WHERE login=? AND password=?";
    private BasicDataSource dataSource;

    public UserEntity get(String login) {
     return jdbcTemplate.queryForObject(GET, mapper, login);
    }

    public int insert(UserEntity user) {
        return this.jdbcTemplate.update(INSERT,user.getLogin(),user.getPassword(),user.getRole(),user.getEnabled());
    }
    public void update(UserEntity user) {
        jdbcTemplate.update(UPDATE,user.getLogin(), user.getEnabled(),user.getPassword(),user.getRole());
    }

    public void remove(UserEntity user) {
        jdbcTemplate.update(DELETE, user.getLogin());
    }

    public boolean isValidUser(String login, String password) throws SQLException {
        PreparedStatement pstmt = dataSource.getConnection().prepareStatement(VALIDATE);
        pstmt.setString(1, login);
        pstmt.setString(2, password);
        ResultSet resultSet = pstmt.executeQuery();
        if(resultSet.next()) {
            System.out.println("yes");
            return (resultSet.getInt(1) > 0);
        }
        else
            return false;
    }

    public RowMapper<UserEntity> mapper = new RowMapper<UserEntity>() {
        public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserEntity user = new UserEntity();
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setEnabled((rs.getInt("enabled")));
            user.setRole(rs.getString("role"));
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
