package rowmapper;

import jdbcUtil.RowMapper;
import quest.QuestItemVO;

import java.sql.ResultSet;

public class QuestItemRowMapper implements RowMapper<QuestItemVO> {
    @Override
    public QuestItemVO mapRow(ResultSet rs) throws Exception {
        QuestItemVO vo = new QuestItemVO();
        vo.setId(rs.getLong("id"));
        vo.setName(rs.getString("name"));
        vo.setQuest_id(rs.getLong("quest_id"));
        vo.setLatitude(rs.getString("latitude"));
        vo.setLongitude(rs.getString("longitude"));
        vo.setAddr(rs.getString("addr"));
        vo.setDescription(rs.getString("description"));
        vo.setOriginalFileName(rs.getString("originalfilename"));
        vo.setFileSystemName(rs.getString("filesystemname"));
        return vo;
    }
    }
}
