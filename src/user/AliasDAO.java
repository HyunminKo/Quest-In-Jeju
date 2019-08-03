package user;

import java.util.List;

import jdbcUtil.JdbcTemplate;
import rowmapper.AliasRowMapper;
import rowmapper.UserRowMapper;

public class AliasDAO {
	
    JdbcTemplate jdbc = new JdbcTemplate();
    public void insert(){
        String name = "testtest";
        String sql = "insert into alias (name) values(?)";
        try {
            jdbc.update(sql,name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<AliasVO> findAll() {
        List<AliasVO> ls = null;
        String sql = "select * from alias";
        try {
            ls = jdbc.query(sql,new AliasRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
	

}
