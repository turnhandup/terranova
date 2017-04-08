package myapp.services.utils;

import myapp.persistence.dao.ArchitectorDao;
import myapp.persistence.entities.ArchitectorEntity;
import myapp.persistence.entities.UserEntity;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by PANNA on 01.04.2017.
 */
@Repository("architectors")
public class ArchitectorDaoImpl implements ArchitectorDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String GET="SELECT * FROM architectors WHERE id_architector=?";
    private static final String INSERT = "INSERT INTO architectors (id_architector,Users_id_user,pib,hours,work_experience,email, phone_number) VALUES  (?,?,?,?" +
            ",?,?,?);";
    private static final String UPDATE="UPDATE architectors SET pib=?, hours=?, work_experience=?, email=?, phone_number=? WHERE id_architector=?";
    private static final String DELETE="DELETE FROM achitectors WHERE id_architector=?";
    private static final String FINDALL="SELECT * FROM architectors GROUP BY id_architector";
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
            return architector;
        }
    };
    public ArchitectorEntity get(int id_architector) {
        return jdbcTemplate.queryForObject(GET,mapper,id_architector);
    }

    public int insert(ArchitectorEntity architector) {
        return jdbcTemplate.update(INSERT, architector.getId_architector(),architector.getId_user(),architector.getPib(),architector.getHours(),architector.getWork_experience(),architector.getEmail(),architector.getPhone_number());
    }

    public void update(ArchitectorEntity architector) {
        System.out.println(architector.getEmail());
         jdbcTemplate.update(UPDATE,architector.getPib(),architector.getHours(),architector.getWork_experience(),architector.getEmail(),architector.getPhone_number(),architector.getId_architector());
        System.out.println();
    }

    public void remove(ArchitectorEntity architector) {
        jdbcTemplate.update(DELETE,architector.getId_architector());
    }

    public List<ArchitectorEntity> findAll() {
        List<ArchitectorEntity> findall1=jdbcTemplate.query(FINDALL,mapper);
        for(ArchitectorEntity l:findall1){
            System.out.println(l.toString());
        }
        return jdbcTemplate.query(FINDALL,mapper);
    }


}
