package rowmapper;

import jdbcUtil.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public class QuestItemIdsRowMapper implements RowMapper<Long> {
    @Override
    public Long mapRow(ResultSet rs) throws Exception {
        return rs.getLong("id");
    }
}
