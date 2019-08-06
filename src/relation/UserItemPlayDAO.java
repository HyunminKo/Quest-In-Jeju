package relation;

import jdbcUtil.JdbcTemplate;
import jdbcUtil.RowMapper;
import rowmapper.UserQuestPlayRowMapper;

import java.util.List;

public class UserItemPlayDAO {

    JdbcTemplate jdbc = new JdbcTemplate();

    public <UserItemPlay> T queryForObject(String sql, RowMapper<UserItemPlayVO> vo, Object...args) throws Exception {
        T vo = null;


    public void insert(UserItemPlayVO vo){
        String sql = "insert into user_item_play(user_id,item_id,is_completed) values(?,?,?)";
        try {
            jdbc.update(sql,vo.getUser_id(),vo.getItem_id(),vo.getIs_completed());
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