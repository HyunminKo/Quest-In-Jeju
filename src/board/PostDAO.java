package board;

import java.util.List;

import jdbcUtil.JdbcTemplate;
import rowmapper.PostRowMapper;

public class PostDAO {

    JdbcTemplate jdbc = new JdbcTemplate();
    
<<<<<<< HEAD

=======
>>>>>>> 628b80b9ae9496d9d7b40180f47e80fc838055aa
    public void insert( PostVO vo ){
        Integer like_count = vo.getLike_count();
        String contents = vo.getContents();
        String date = vo.getDate();
        Long user_id = vo.getUser_id();
        String src = vo.getSrc();
        Integer category = vo.getCategory();
<<<<<<< HEAD

=======
        
>>>>>>> 628b80b9ae9496d9d7b40180f47e80fc838055aa
        String sql = "insert into post"
        		+ "(like_count, contents, date, user_id, src, category) "
        		+ "values(?,?, now(),?,?,?)";
        try {
            jdbc.update(sql,like_count,contents, date, user_id, src, category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<PostVO> findAll() {
        List<PostVO> ls = null;
        String sql = "select * from post";
        try {
            ls = jdbc.query(sql,new PostRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
	
	
	
}
