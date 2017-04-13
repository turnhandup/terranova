package myapp.services.utils;

import com.mysql.jdbc.Statement;
import myapp.persistence.dao.ArchitectorDao;
import myapp.persistence.entities.ArchitectorEntity;
import myapp.persistence.entities.UserEntity;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by PANNA on 01.04.2017.
 */
@Repository("architectors")
public class ArchitectorDaoImpl implements ArchitectorDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String GET="SELECT * FROM architectors,users  WHERE id_architector=? AND users.id_user=architectors.Users_id_user";
    private static final String INSERT = "INSERT INTO architectors (id_architector,Users_id_user,pib,hours,work_experience,email, phone_number) VALUES  (?,?,?,?" +
            ",?,?,?);";
    private static String INSERTUSER="INSERT INTO users (login, password, role,enabled) VALUES (?,MD5(?),'ARCHITECTOR', 1)";
    private static final String UPDATE="UPDATE architectors,users SET users.login=?,users.password=MD5(?),architectors.pib=?, architectors.hours=?,architectors.work_experience=?,architectors.email=?, architectors.phone_number=? WHERE id_architector=? AND users.id_user=architectors.Users_id_user";
    private static final String DELETE="DELETE users,architectors FROM architectors INNER JOIN users WHERE users.id_user=arhictectors.Users_id_user  AND architectors.id_architector=?";
    private static final String FINDALL="SELECT * FROM architectors,users WHERE users.id_user=architectors.Users_id_user  GROUP BY pib";
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
            architector.setId_architector(rs.getInt("id_architector"));
            architector.setId_user(rs.getInt("Users_id_user"));
            architector.setPib(rs.getString("pib"));
            architector.setHours(rs.getInt("hours"));
            architector.setWork_experience(rs.getInt("work_experience"));
            architector.setEmail(rs.getString("email"));
            architector.setPhone_number(rs.getString("phone_number"));
            UserEntity userEntity=new UserEntity();
            userEntity.setLogin(rs.getString("users.login"));
            userEntity.setRole("ARCHITECTOR");
            userEntity.setPassword(rs.getString("users.password"));
            userEntity.setEnabled(rs.getInt("users.enabled"));
            architector.setUserEntity(userEntity);
            return architector;
        }
    };
    public ArchitectorEntity get(int id_architector) {
        return jdbcTemplate.queryForObject(GET,mapper,id_architector);
    }
    public int insert(final ArchitectorEntity architectorEntity) {
        final PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
                final java.sql.PreparedStatement ps = connection.prepareStatement(INSERTUSER, Statement.RETURN_GENERATED_KEYS);
                UserEntity user=architectorEntity.getUserEntity();
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

         int id_user=Long.valueOf((Long) holder.getKeyList().get(0).get("GENERATED_KEY")).intValue();
        int id=((Long) holder.getKeyList().get(0).get("GENERATED_KEY")).intValue();
        architectorEntity.setId_user(id);
        insertArchitector(architectorEntity);
        return rowsAffected;
    }
    public void insertArchitector(final ArchitectorEntity architector) {
        jdbcTemplate.batchUpdate(INSERT, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(java.sql.PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1,architector.getId_architector());
                ps.setInt(2,architector.getId_user());
                ps.setString(3, architector.getPib());
                ps.setInt(4, architector.getHours());
                ps.setDouble(5, architector.getWork_experience());
                ps.setString(6,architector.getEmail());
                ps.setString(7,architector.getPhone_number());
            }

            @Override
            public int getBatchSize() {
                return 1;
            }


        });
    }

    public void update(ArchitectorEntity architector) {
        UserEntity user=architector.getUserEntity();
         jdbcTemplate.update(UPDATE,user.getLogin(),user.getPassword(),architector.getPib(),architector.getHours(),architector.getWork_experience(),architector.getEmail(),architector.getPhone_number(),architector.getId_architector());
    }

    public void remove(ArchitectorEntity architector) {
        jdbcTemplate.update(DELETE,architector.getId_architector());
    }

    public List<ArchitectorEntity> findAll() {
        return jdbcTemplate.query(FINDALL,mapper);
    }


}
