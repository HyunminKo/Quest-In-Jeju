package relation;

import java.util.List;

import jdbcUtil.JdbcTemplate;
import quest.QuestItemVO;
import rowmapper.AliasRowMapper;
import rowmapper.QuestItemRowMapper;
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

    public QuestItemVO findOne(Long item_id) {
        String sql = "select id from quest_item where id=?";
        QuestItemVO vo = new QuestItemVO();
        QuestItemRowMapper rowMapper = new QuestItemRowMapper();
        try {
            vo = jdbc.queryForObject(sql, rowMapper, item_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
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

    public List<UserQuestPlayVO> findPlayingQuestByUserId(Long userId) {
        List<UserQuestPlayVO> ls = null;
        String sql = "select * from user_quest_play where user_id=?";
        try{
            ls = jdbc.query(sql,new UserQuestPlayRowMapper(),userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ls;
    }
}