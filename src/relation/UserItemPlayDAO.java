package relation;

import jdbcUtil.JdbcTemplate;
import rowmapper.UserItemPlayRowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserItemPlayDAO {


    JdbcTemplate jdbc = new JdbcTemplate();

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

    public int update(Long user_id, Long item_id) {
        int rc = 0;
        String sql = "update user_quest_play set is_completed = ? where user_id = ? and item_id = ?";
        try {
            rc = jdbc.update(sql, 1, user_id, item_id);
            if (rc != 0) {
                System.out.println("성공");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rc;
    }
}
