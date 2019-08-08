package relation;

import java.util.List;

import board.PostVO;
import jdbcUtil.JdbcTemplate;
import rowmapper.PostRowMapper;
import rowmapper.UserRowMapper;
import rowmapper.UserPostLikeRowMapper;
import user.UserVO;

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
}
