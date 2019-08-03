package rowmapper;

import java.sql.ResultSet;
import jdbcUtil.RowMapper;
import relation.UserItemPlayVO;

public class UserItemPlayRowMapper implements RowMapper<UserItemPlayVO> {
	@Override
    public UserItemPlayVO mapRow(ResultSet rs) throws Exception {
		UserItemPlayVO vo = new UserItemPlayVO();
        vo.setUser_id(rs.getLong("user_id"));
        vo.setItem_id(rs.getLong("item_id"));
        vo.setIs_completed(rs.getInt("is_completed"));
        return vo;
    }
}
