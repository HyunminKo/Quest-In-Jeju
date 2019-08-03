package rowmapper;

import java.sql.ResultSet;

import board.PostVO;
import jdbcUtil.RowMapper;

public class PostRowMapper implements RowMapper<PostVO> {
    @Override
    public PostVO mapRow(ResultSet rs) throws Exception {
        PostVO vo = new PostVO();
        
        vo.setId(rs.getLong("id"));
        vo.setLike_count(rs.getInt("like_count"));
        vo.setContents(rs.getString("contents"));
        vo.setDate(rs.getString("date"));
        vo.setUser_id(rs.getLong("user_id"));
        vo.setSrc(rs.getString("src"));
        vo.setCategory(rs.getInt("category"));
        return vo;
    }
}
