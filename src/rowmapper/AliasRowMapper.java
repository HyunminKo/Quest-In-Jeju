package rowmapper;

import java.sql.ResultSet;

import jdbcUtil.RowMapper;
import user.AliasVO;

public class AliasRowMapper implements RowMapper<AliasVO>{

    @Override
    public AliasVO mapRow(ResultSet rs) throws Exception {
    	
    	AliasVO vo = new AliasVO();
    	vo.setId(rs.getLong("id"));
    	vo.setName(rs.getString("name"));
    	
    	return vo;
    }
}