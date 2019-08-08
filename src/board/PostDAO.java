package board;

import java.util.List;

import jdbcUtil.JdbcTemplate;
import rowmapper.PostRowMapper;
import rowmapper.UserRowMapper;
import user.UserVO;
import util.Utils;

import javax.servlet.http.HttpServletRequest;

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
    public List<PostVO> findAllDesc() {
    	List<PostVO> ls = null;
    	String sql = "select * from post order by id desc";
    	try {
            ls = jdbc.query(sql,new PostRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    public List<PostVO> findAllCategory( String lo ) {
    	List<PostVO> ls = null;
    	String sql = null;
    	if( lo.equals("1") ) sql = "select * from post order by id desc";
    	else if( lo.equals("2") ) sql = "select * from post where category = 1 order by id desc";
    	else if( lo.equals("3") ) sql = "select * from post where category = 2 order by id desc";
    	else if( lo.equals("4") ) sql = "select * from post where category = 3 order by id desc";
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

    public int findPostCountByUserId(HttpServletRequest request) {
        List<PostVO> ls = null;
        String sql = "select * from post where user_id = ?";
        Long user_id = Long.parseLong(Utils.getValueInCookie(request, "user_id"));
        try {
            if(user_id != null) {
                ls = jdbc.query(sql, new PostRowMapper(), user_id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls.size();
    }
    public int updateLikeCount(Long post_id,String num) {
    	int result = -1;
    	String sql = "update post set like_count = like_count ? where post_id = ?";
    	try {
			result = jdbc.update(sql,num,post_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return result;
    }
}
