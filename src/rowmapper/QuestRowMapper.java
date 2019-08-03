package rowmapper;

import jdbcUtil.RowMapper;
import quest.QuestVO;

import java.sql.ResultSet;

public class QuestRowMapper implements RowMapper<QuestVO> {
    @Override
    public QuestVO mapRow(ResultSet rs) throws Exception {
        QuestVO vo = new QuestVO();
        vo.setId(rs.getLong("id"));
        vo.setName(rs.getString("name"));
        vo.setItem_count(rs.getInt("item_count"));
        return vo;
    }
}
