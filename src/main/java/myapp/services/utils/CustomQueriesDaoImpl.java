package myapp.services.utils;

import myapp.persistence.dao.CustomQueriesDao;
import myapp.persistence.entities.CustomQueriesEntities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by PANNA on 13.04.2017.
 */
public class CustomQueriesDaoImpl implements CustomQueriesDao {
    private static final String WORKDONE = "SELECT pib, SUM(o.hours) AS workDone FROM architectors a, objects o WHERE o.Architectors_id_architector=a.id_architector AND o.status=TRUE GROUP BY o.Architectors_id_architector";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CustomQueriesEntities.WorkDone> workDone() {
        return jdbcTemplate.query(WORKDONE, workDoneMapper);
    }


//  на кожний кастомний запит потібен кастомний мапер
    public RowMapper<CustomQueriesEntities.WorkDone> workDoneMapper = new RowMapper<CustomQueriesEntities.WorkDone>() {
        public CustomQueriesEntities.WorkDone mapRow(ResultSet rs, int rowNum) throws SQLException {
            CustomQueriesEntities.WorkDone wd = new CustomQueriesEntities.WorkDone();
            wd.setPib(rs.getString("pib"));
            wd.setHours(rs.getInt("workDone"));
            return wd;
        }
    };
}
