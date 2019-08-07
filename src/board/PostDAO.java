package board;

import java.util.List;

import jdbcUtil.JdbcTemplate;
import rowmapper.PostRowMapper;
import rowmapper.UserRowMapper;
import user.UserVO;

public class PostDAO {

    JdbcTemplate jdbc = new JdbcTemplate();

    public void insert( PostVO vo ){
        String sql = "insert into post"
        		+ "( like_count , contents, date, user_id, category,originalfilename,filesystemname) "
        		+ "values(?,?, now(),?,?,?,?)";
        try {
            jdbc.update(sql,vo.getLike_count(),vo.getContents(), vo.getUser_id(),vo.getCategory(),vo.getOriginalfilename(),vo.getFilesystemname());
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
}
