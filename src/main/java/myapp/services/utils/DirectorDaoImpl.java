package myapp.services.utils;

import com.mysql.jdbc.Statement;
import myapp.persistence.dao.DirectorDao;
import myapp.persistence.entities.DepartmentEntity;
import myapp.persistence.entities.DirectorEntity;
import myapp.persistence.entities.OrdererEntity;
import myapp.persistence.entities.UserEntity;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by PANNA on 01.04.2017.
 */
public class DirectorDaoImpl implements DirectorDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String GET="SELECT * FROM users,director,department WHERE director.id_director=? AND users.id_user=director.Users_id_user  AND department.id_department=director.Department_id_department;";
    private static final String GETALL="SELECT * FROM users,director,department WHERE users.id_user=director.Users_id_user  AND department.id_department=director.Department_id_department;";
    private static final String INSERT ="INSERT INTO users (login, password, role,enabled) VALUES (?,MD5(?),'ADMIN', 1)";
    private static final String INSERTDIRECTOR= "INSERT INTO director (pib,address, marital_status,work_experience,Department_id_department, Users_id_user) VALUES (?,?,?,?,?,?)";
    private static String UPDATE="UPDATE director, users SET users.login=?, users.password=MD5(?), director.pib=?,director.address=?, director.marital_status=?, director.work_experience=? WHERE users.id_user=director.Users_id_user AND director.id_director=?";
    private static final String DELETE="DELETE users,director FROM director INNER JOIN users WHERE users.id_user=director.Users_id_user  AND director.id_director=?";
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
            DepartmentEntity departmentEntity=new DepartmentEntity();
            departmentEntity.setId_department(rs.getInt("department.id_department"));
            departmentEntity.setEmail(rs.getString("department.email"));
            departmentEntity.setAddress(rs.getString("department.address"));
            departmentEntity.setPhonenumber(rs.getString("department.phonenumber"));
            UserEntity userEntity=new UserEntity();
            userEntity.setLogin(rs.getString("users.login"));
            userEntity.setRole("ADMIN");
            userEntity.setPassword(rs.getString("users.password"));
            userEntity.setEnabled(rs.getInt("users.enabled"));

            director.setDepartmentEntity(departmentEntity);
            director.setUserEntity(userEntity);
            return director;
        }
    };
    public DirectorEntity get(int id_director) {
        return jdbcTemplate.queryForObject(GET,mapper,id_director);
    }

    @Override
    public List<DirectorEntity> getAll() {
        return jdbcTemplate.query(GETALL,mapper);
    }
    @Override
    public int insert(final DirectorEntity director) {
        final PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
                final java.sql.PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
                UserEntity user=director.getUserEntity();
                ps.setString(1,user.getLogin());
                ps.setString(2,user.getPassword());
                return ps;
            }

        };
        final KeyHolder holder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(psc, holder);
//        List<Map<String, Object>> list=holder.getKeyList();
//        for(Map<String,Object> l:list){
//            System.out.println(l.entrySet().toString());
//        }
//        System.out.println(holder.getKeyList().get(0).values());
//        System.out.println(holder.getKeyList().get(0).get("GENERATED_KEY"));
//        System.out.println(holder.getKeyList().get(0).get("id"));

        int id_user=Long.valueOf((Long) holder.getKeyList().get(0).get("GENERATED_KEY")).intValue();
        director.setId_user(id_user);
        insertDirector(director);
        return rowsAffected;
    }

    @Override
    public void insertDirector(final DirectorEntity directorEntity) {
        jdbcTemplate.batchUpdate(INSERTDIRECTOR, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1,directorEntity.getPib());
                ps.setString(2,directorEntity.getAddress());
                ps.setString(3, directorEntity.getMarital_status());
                ps.setDouble(4, directorEntity.getWork_experience());
                ps.setInt(5,directorEntity.getId_department());
                ps.setInt(6,directorEntity.getId_user());
            }

            @Override
            public int getBatchSize() {
                return 1;
            }
        });
    }

    public void update(DirectorEntity director) {
        UserEntity userEntity=director.getUserEntity();
         jdbcTemplate.update(UPDATE,userEntity.getLogin(), userEntity.getPassword(),director.getPib(),director.getAddress(),director.getMarital_status(),director.getWork_experience(),director.getId_director());
    }

    public void remove(DirectorEntity director) {
        jdbcTemplate.update(DELETE, director.getId_director());
    }
}
