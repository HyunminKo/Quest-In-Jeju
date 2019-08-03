package rowmapper;

import java.sql.ResultSet;
import jdbcUtil.RowMapper;
import user.UserVO;
import board.CommentVO;

public class CommentRowMapper implements RowMapper<CommentVO> {
	@Override
    public CommentVO mapRow(ResultSet rs) throws Exception {
        CommentVO vo = new CommentVO();
        vo.setId(rs.getLong("id"));
        vo.setContents(rs.getString("contents"));
        vo.setDate(rs.getString("date"));
        vo.setPost_id(rs.getLong("post_id"));
        vo.setUser_id(rs.getLong("user_id"));
        return vo;
    }
}
