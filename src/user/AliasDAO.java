package user;

import java.util.List;

import jdbcUtil.JdbcTemplate;
import rowmapper.AliasRowMapper;

public class AliasDAO {
	
    JdbcTemplate jdbc = new JdbcTemplate();
    public void insert(AliasVO vo){
        //String name = "DBTest";
        String sql = "insert into alias (name) values(?)";
        try {
            jdbc.update(sql,vo.getName());
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
