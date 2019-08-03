package rowmapper;

import jdbcUtil.RowMapper;
import quest.QuestLogVO;

import java.sql.ResultSet;

public class QuestLogRowMapper implements RowMapper<QuestLogVO> {

    @Override
    public QuestLogVO mapRow(ResultSet rs) throws Exception {
        QuestLogVO vo = new QuestLogVO();
        vo.setUser_id(rs.getLong("user_id"));
        vo.setItem_id(rs.getLong("item_id"));
        vo.setQuest_id(rs.getLong("quest_id"));
        return null;
    }
}
