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
    
    public UserVO findPwByEmail( String email ) {
    	UserVO vo = null;
    	String sql = "select * from user where email = ?";
    	try {
    		vo = jdbc.queryForObject(sql, new UserRowMapper(), email );
    	}
    	catch ( Exception e ) {
    		 e.printStackTrace();
    	}
    	return vo;
    }
    public Long findIdByEmail(String email) {
    	UserVO vo = null;
    	String sql = "select id from user where email=?";
    	try {
    		vo = jdbc.queryForObject(sql, new UserRowMapper(), email);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return vo.getId();
    }
    
    public List<UserVO> findAllEmail() {
    	List<UserVO> ls = null;
    	String sql = "select email from user";
    	try {
    		ls = jdbc.query(sql, new UserRowMapper());
       	}
    	catch ( Exception e ) {
   		 e.printStackTrace();
   	}
   	return ls;
    }
    public boolean isExistByEmail(String email) {
    	String sql = "select email from user where email=?";
    	try {
    		UserVO vo = jdbc.queryForObject(sql,new UserRowMapper(),email);
    		if(vo!=null) {
    			return true;
    		}else {
    			return false;
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return true;
    	}
    }
}
