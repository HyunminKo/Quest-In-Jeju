package relation;

import jdbcUtil.JdbcTemplate;
import quest.QuestItemVO;
import rowmapper.QuestItemRowMapper;
import rowmapper.UserItemPlayRowMapper;

import java.util.List;

public class UserItemPlayDAO {
    JdbcTemplate jdbc = new JdbcTemplate();

    public void insert(UserItemPlayVO vo) {
        String sql = "insert into user_item_play(user_id,item_id,is_completed) values(?,?,?)";
        try {
            jdbc.update(sql, vo.getUser_id(), vo.getItem_id(), vo.getIs_completed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<UserItemPlayVO> findAll() {
        List<UserItemPlayVO> ls = null;
        String sql = "select * from user_item_play";
        try {
            ls = jdbc.query(sql, new UserItemPlayRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public List<QuestItemVO> getPlayingQuestItemsByUserId(long id) {
        List<QuestItemVO> ls = null;
        String sql = "select * from quest_item where id in " +
                "(select item_id from user_item_play where user_id=?)";
        try {
            ls = jdbc.query(sql, new QuestItemRowMapper(), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public List<UserItemPlayVO> getPlayingItemInfoByUserId(long id) {
        List<UserItemPlayVO> ls = null;
        String sql = "select * from user_item_play where user_id = ?";
        try {
            ls = jdbc.query(sql, new UserItemPlayRowMapper(), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public int update(Long user_id, Long item_id) {
        int rc = 0;
        String sql = "update user_item_play set is_completed = 1 where user_id = ? and item_id = ?";
        try {
            rc = jdbc.update(sql,user_id, item_id);
            if (rc != 0) {
                System.out.println("성공");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rc;
    }
    public UserItemPlayVO queryForObject(Long user_id, Long item_id){
        String sql = "select user_id, item_id from user_item_play where user_id=? and item_id=?";
        UserItemPlayVO vo = new UserItemPlayVO();
        UserItemPlayRowMapper rowMapper = new UserItemPlayRowMapper();
        try {
            vo = jdbc.queryForObject(sql, rowMapper, user_id, item_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }
}