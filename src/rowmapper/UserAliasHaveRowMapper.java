package rowmapper;

import jdbcUtil.RowMapper;
import relation.UserAliasHaveVO;

import java.sql.ResultSet;

public class UserAliasHaveRowMapper implements RowMapper<UserAliasHaveVO> {
    @Override
    public UserAliasHaveVO mapRow(ResultSet rs) throws Exception {
        UserAliasHaveVO vo = new UserAliasHaveVO();
        vo.setAlias_id(rs.getLong("alias_id"));
        vo.setUser_id(rs.getLong("user_id"));
        return null;
    }
}
