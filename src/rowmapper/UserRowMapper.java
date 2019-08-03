package rowmapper;

import jdbcUtil.RowMapper;
import user.UserVO;

import java.sql.ResultSet;

public class UserRowMapper implements RowMapper<UserVO> {
    @Override
    public UserVO mapRow(ResultSet rs) throws Exception {

        return null;
    }
}
