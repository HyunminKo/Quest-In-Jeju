package rowmapper;

import jdbcUtil.RowMapper;
import relation.UserPostLikeVO;

import java.sql.ResultSet;

public class UserPostLikeRowMapper implements RowMapper<UserPostLikeVO> {
    @Override
    public UserPostLikeVO mapRow(ResultSet rs) throws Exception {
        UserPostLikeVO vo = new UserPostLikeVO();
        vo.setPost_id(rs.getLong("post_id"));
        vo.setUser_id(rs.getLong("user_id"));
        return vo;
    }
}
