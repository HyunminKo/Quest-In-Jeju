package rowmapper;

import jdbcUtil.RowMapper;
import user.UserVO;

import java.sql.ResultSet;

public class UserRowMapper implements RowMapper<UserVO> {
    @Override
    public UserVO mapRow(ResultSet rs) throws Exception {
        UserVO vo = new UserVO();
        vo.setId(rs.getLong("id"));
        vo.setName(rs.getString("name"));
        vo.setPassword(rs.getString("password"));
        vo.setEmail(rs.getString("email"));
        return vo;
    }
}
