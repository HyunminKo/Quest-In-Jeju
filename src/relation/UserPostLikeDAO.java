package relation;

import java.util.List;

import jdbcUtil.JdbcTemplate;
import rowmapper.UserPostLikeRowMapper;

public class UserPostLikeDAO {
	
	JdbcTemplate jdbc = new JdbcTemplate();

    public void insert( UserPostLikeVO vo ){
        String sql = "insert into UserPostLike"
        		+ "( user_id , post_id ) "
        		+ "values( ? , ? )";
        try {
            jdbc.update(sql, vo.getUser_id() , vo.getPost_id() );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<UserPostLikeVO> findAll() {
        List<UserPostLikeVO> ls = null;
        String sql = "select * from user_post_like";
        try {
            ls = jdbc.query( sql , new UserPostLikeRowMapper() );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    public String checkPostLike( UserPostLikeVO vo ) {
    	List<UserPostLikeVO> ls = null;
    	String sql = "select post_id from user_post_like where user_id = ?";
    	String check = "";
    	try {
    		ls = jdbc.query( sql ,  new UserPostLikeRowMapper() , vo.getUser_id() );
    	} catch( Exception e ) {
    		e.printStackTrace();
    	}
    	for( UserPostLikeVO lvo : ls ) {
    		if( lvo.getPost_id() == vo.getPost_id() ) {
    			check = "likedButton";
    			break;
    		}
    	}
    	return check;
    }
}