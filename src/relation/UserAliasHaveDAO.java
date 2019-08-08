package relation;

import jdbcUtil.JdbcTemplate;
import rowmapper.UserAliasHaveRowMapper;
import util.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserAliasHaveDAO {

    JdbcTemplate jdbc = new JdbcTemplate();
    List<UserAliasHaveVO> ls = null;

    public int getAliasCountByUserId(HttpServletRequest request) {
        String sql = "select * from user_id";
        Long user_id = Long.parseLong(Utils.getValueInCookie(request, "user_id"));
        try {
            ls = jdbc.query(sql, new UserAliasHaveRowMapper(), user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls.size();
    }


    public List<UserAliasHaveVO> getAliasListByUserId(HttpServletRequest request) {
        String sql = "select * from user_id";
        List<UserAliasHaveVO> ls = null;
        Long user_id = Long.parseLong(Utils.getValueInCookie(request, "user_id"));
        try {
            ls = jdbc.query(sql, new UserAliasHaveRowMapper(), user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
}
