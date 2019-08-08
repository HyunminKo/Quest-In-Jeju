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
    public List<UserPostLikeVO> findAllPostId( Long user_id ) {
    	List<UserPostLikeVO> ls = null;
    	String sql = "select * from user_post_like where user_id = ?";
    	try {
    		ls = jdbc.query( sql , new UserPostLikeRowMapper() , user_id );
    	} catch( Exception e ) {
    		e.printStackTrace();
    	}
    	return ls;
    }
	public void delete(long postId, long userId) {
		String sql = "delete from user_;post_like where user_id=? and post_id=?";
		
		try {
			jdbc.update(sql, userId,postId);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}