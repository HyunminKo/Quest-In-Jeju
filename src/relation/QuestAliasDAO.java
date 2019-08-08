package relation;

import jdbcUtil.JdbcTemplate;
import relation.QuestAliasVO;

public class QuestAliasDAO {
    JdbcTemplate jdbc = new JdbcTemplate();
    public void insert(QuestAliasVO vo){
        String sql = "insert into quest_alias (name) values(?)";
        try {
            jdbc.update(sql, vo.getAlias_id(), vo.getQuest_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
