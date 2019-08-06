package relation;

import java.util.List;

import jdbcUtil.JdbcTemplate;
import rowmapper.AliasRowMapper;
import rowmapper.UserQuestPlayRowMapper;
import user.AliasVO;

public class UserQuestPlayDAO {

    JdbcTemplate jdbc = new JdbcTemplate();
    public void insert(UserQuestPlayVO vo){
        String sql = "insert into user_quest_play(user_id,quest_id) values(?,?)";
        try {
            jdbc.update(sql,vo.getUser_id(),vo.getQuest_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<UserQuestPlayVO> findAll() {
        List<UserQuestPlayVO> ls = null;
        String sql = "select * from user_quest_play";
        try {
            ls = jdbc.query(sql,new UserQuestPlayRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
}