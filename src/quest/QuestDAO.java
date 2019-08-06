package quest;

import jdbcUtil.JdbcTemplate;
import rowmapper.QuestRowMapper;

import java.util.List;

public class QuestDAO {

    JdbcTemplate jdbc = new JdbcTemplate();
    public int insert(QuestVO vo){
        //insert into quest (name, item_count, user_id) values (“오름 정복하기“,3,1);
        int rc = -1;

        String sql = "insert into quest (name, item_count, user_id) values (?,?,?)";
        try {
            rc = jdbc.update(sql,vo.getName(),vo.getItem_count(),vo.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rc;
    }
    public List<QuestVO> findAll() {
    	List<QuestVO> ls = null;
        String sql = "select * from quest";
        try {
            ls = jdbc.query(sql,new QuestRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
}