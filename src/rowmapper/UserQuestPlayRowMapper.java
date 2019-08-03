package rowmapper;

import java.sql.ResultSet;

import jdbcUtil.RowMapper;
import relation.UserPostLikeVO;
import relation.UserQuestPlayVO;

public class UserQuestPlayRowMapper implements RowMapper<UserQuestPlayVO>{
    @Override
    public UserQuestPlayVO mapRow(ResultSet rs) throws Exception {
    	UserQuestPlayVO vo = new UserQuestPlayVO();
    	vo.setQuest_id(rs.getLong("quest_id"));
    	vo.setUser_id(rs.getLong("user_id"));
    	return vo;
    }
}