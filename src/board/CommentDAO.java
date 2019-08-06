package board;

import java.util.List;

import jdbcUtil.JdbcTemplate;
import rowmapper.CommentRowMapper;

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
}
