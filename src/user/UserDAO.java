package user;

import jdbcUtil.JdbcTemplate;
import rowmapper.UserRowMapper;

import java.util.List;

public class UserDAO {
    JdbcTemplate jdbc = new JdbcTemplate();
    
    public int insert(UserVO vo){
        int rc = -1;
        String sql = "insert into user (email,name,password) values(?,?,?)";
        try {
            rc = jdbc.update(sql,vo.getEmail(),vo.getName(),vo.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rc;
    }
    public List<UserVO> findAll() {
        List<UserVO> ls = null;
        String sql = "select * from user";
        try {
            ls = jdbc.query(sql,new UserRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public UserVO findPwByEmail( em ) {
    	UserVO vo = null;
    	String sql = "select password from user where email = ?";
    	try {
    		vo = jdbc.queryForObject(sql, new UserRowMapper(), email );
    	}
    	catch ( Exception e ) {
    		 e.printStackTrace();
    	}
    	return vo;
    }
}
