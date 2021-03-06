package board;

import java.util.List;

import jdbcUtil.JdbcTemplate;
import rowmapper.CommentRowMapper;
import rowmapper.UserRowMapper;
import user.UserVO;

public class CommentDAO {
	
    JdbcTemplate jdbc = new JdbcTemplate();
    
    public void insert( CommentVO vo ) {
        String sql = "insert into comment"
        		+ "( contents , date , post_id , user_id ) "
        		+ "values( ? , now() , ? , ? )";
        try {
            jdbc.update(sql , vo.getContents() , vo.getPost_id(), vo.getUser_id() );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<CommentVO> findAll() {
        List<CommentVO> ls = null;
        String sql = "select * from comment";
        try {
            ls = jdbc.query(sql,new CommentRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    public String findNameByUserId( String id ) {
    	UserVO vo = null;
    	String sql = "select * from user where id = ?";
    	try {
    		vo = jdbc.queryForObject( sql, new UserRowMapper() , id );
    	} catch ( Exception e ) {
    		e.printStackTrace();
    	}
    	return vo.getName();
    }
    public List<CommentVO> findAllByPostId( String c ) {
    	List<CommentVO> ls = null;
    	String sql = "select * from comment where post_id = ?";
    	Integer t = Integer.parseInt(c);
    	try {
    		ls = jdbc.query( sql , new CommentRowMapper() , t );
    	} catch( Exception e ) {
    		e.printStackTrace();
    	}
    	return ls;
    }
}
