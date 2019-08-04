package user;

import jdbcUtil.JdbcTemplate;
import rowmapper.UserRowMapper;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    JdbcTemplate jdbc = new JdbcTemplate();
    
    public void insert(){
        String name = "testtest";
        String password = "testtest";
        String email = "testtest@testtest.org";
        String sql = "insert into user (email,name,password) values(?,?,?)";
        try {
            jdbc.update(sql,email,name,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
