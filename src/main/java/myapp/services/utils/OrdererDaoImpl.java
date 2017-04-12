package myapp.services.utils;

import com.mysql.jdbc.Statement;
import myapp.persistence.dao.OrdererDao;
import myapp.persistence.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by PANNA on 09.04.2017.
 */
public class OrdererDaoImpl implements OrdererDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String GET="SELECT * FROM users,orderer,department WHERE orderer.id_orderer=? AND users.id_user=orderer.Users_id_user  AND department.id_department=orderer.Department_id_department;";
    private static String GETALL="SELECT * FROM users,orderer,orders,department WHERE users.id_user=orderer.Users_id_user  AND department.id_department=orderer.Department_id_department;";
    private static String GETTBYDEPARTMENT=" SELECT * FROM users,orderer,orders,department WHERE users.id_user=orderer.Users_id_user  AND department.id_department=orderer.Department_id_department AND id_department=?";
    private static String INSERTORDERER="INSERT INTO orderer (pib,company_name,phone_number,passport_data,email,address,Department_id_department, Users_id_user) VALUES (?,?,?,?,?,?,?,?)";
    private static String INSERT="INSERT INTO users (login, password, role,enabled) VALUES (?,MD5(?),'USER', 1)";
    private static String UPDATE="UPDATE orderer, users SET users.login=?, users.password=MD5(?), orderer.pib=?,orderer.company_name=?, orderer.phone_number=?, orderer.passport_data=?, orderer.email=?, orderer.address=? WHERE users.id_user=orderer.Users_id_user AND orderer.id_orderer=?";
    private static final String DELETE="DELETE users,orderer FROM orderer INNER JOIN users WHERE users.id_user=orderer.Users_id_user  AND orderer.id_orderer=?";

    public RowMapper<OrdererEntity> mapper = new RowMapper<OrdererEntity>() {
        public OrdererEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
           OrdererEntity ordererEntity=new OrdererEntity();
           ordererEntity.setId_orderer(rs.getInt("orderer.id_orderer"));
           ordererEntity.setPib(rs.getString("orderer.pib"));
           ordererEntity.setCompany_name(rs.getString("orderer.company_name"));
           ordererEntity.setPhone_number(rs.getString("orderer.phone_number"));
           ordererEntity.setPassport_data(rs.getString("orderer.passport_data"));
           ordererEntity.setEmail(rs.getString("orderer.email"));
           ordererEntity.setAddress(rs.getString("orderer.address"));
           ordererEntity.setId_user(rs.getInt("orderer.Users_id_user"));
           ordererEntity.setId_department(rs.getInt("orderer.Department_id_department"));
           DepartmentEntity departmentEntity=new DepartmentEntity();
           departmentEntity.setId_department(rs.getInt("department.id_department"));
           departmentEntity.setEmail(rs.getString("department.email"));
           departmentEntity.setAddress(rs.getString("department.address"));
           departmentEntity.setPhonenumber(rs.getString("department.phonenumber"));
           ordererEntity.setDepartmentEntity(departmentEntity);
           UserEntity userEntity=new UserEntity();
           userEntity.setLogin(rs.getString("users.login"));
           userEntity.setRole("USER");
           userEntity.setPassword(rs.getString("users.password"));
           userEntity.setEnabled(rs.getInt("users.enabled"));
           ordererEntity.setUserEntity(userEntity);
           return ordererEntity;
        }
    };
    @Override
    public OrdererEntity get(int id_orderer) {
        return jdbcTemplate.queryForObject(GET,mapper,id_orderer);
    }

    @Override
    public List<OrdererEntity> getAll() {
//        List<OrdererEntity> findall1=jdbcTemplate.query(GETALL,mapper);
//        for(OrdererEntity l:findall1){
//            System.out.println(l.toString());
//        }
        return jdbcTemplate.query(GETALL,mapper);
    }

    @Override
    public List<OrdererEntity> getAllByDepartment(int id_department) {
        return jdbcTemplate.query(GETTBYDEPARTMENT,mapper);
    }

    @Override
    public int insert(final OrdererEntity orderer) {
        final PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
                final java.sql.PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
                UserEntity user=orderer.getUserEntity();
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
        orderer.setId_user(id_user);
        insertOrderer(orderer);
        return rowsAffected;
    }

    private void insertOrderer(final OrdererEntity ordererEntity){
        jdbcTemplate.batchUpdate(INSERTORDERER, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(java.sql.PreparedStatement ps, int i) throws SQLException {
                ps.setString(1,ordererEntity.getPib());
                ps.setString(2,ordererEntity.getCompany_name());
                ps.setString(3, ordererEntity.getPhone_number());
                ps.setString(4, ordererEntity.getPassport_data());
                ps.setString(5, ordererEntity.getEmail());
                ps.setString(6,ordererEntity.getAddress());
                ps.setInt(7,ordererEntity.getId_department());
                ps.setInt(8,ordererEntity.getId_user());
            }

            @Override
            public int getBatchSize() {
                return 1;
            }
        });
    }
    @Override
    public void remove(OrdererEntity ordererEntity) {
        jdbcTemplate.update(DELETE,ordererEntity.getId_orderer());
    }

    @Override
    public void update(OrdererEntity ordererEntity) {
        UserEntity user=ordererEntity.getUserEntity();
        System.out.println("ORDERER ENTITY   "+ordererEntity.toString());
        jdbcTemplate.update(UPDATE, user.getLogin(),user.getPassword(),ordererEntity.getPib(),ordererEntity.getCompany_name(),ordererEntity.getPhone_number(),ordererEntity.getPassport_data(),ordererEntity.getEmail(),ordererEntity.getAddress(),ordererEntity.getId_orderer());
    }
}
