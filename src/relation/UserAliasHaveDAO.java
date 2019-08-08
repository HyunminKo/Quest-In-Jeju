package relation;

import jdbcUtil.JdbcTemplate;
import rowmapper.UserAliasHaveRowMapper;
import util.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserAliasHaveDAO {

    JdbcTemplate jdbc = new JdbcTemplate();

    public int getAliasCountByUserId(Long userId) {
        return getAliasListByUserId(userId).size();
    }


    public List<UserAliasHaveVO> getAliasListByUserId(Long userId) {
        List<UserAliasHaveVO> ls = null;
        String sql = "select * from user_alias_have where user_id=?";
        try {
            ls = jdbc.query(sql, new UserAliasHaveRowMapper(), userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public void insert(UserAliasHaveVO vo){
        String sql = "insert into quest_alias values(?, ?)";
        try {
            jdbc.update(sql, vo.getUser_id(), vo.getAlias_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
