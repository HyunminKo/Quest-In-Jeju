package quest;

import java.util.List;

import jdbcUtil.JdbcTemplate;
import relation.UserQuestPlayVO;
import rowmapper.QuestItemRowMapper;
import rowmapper.UserQuestPlayRowMapper;

public class QuestItemDAO {

    JdbcTemplate jdbc = new JdbcTemplate();
    public void insert(){
    	
    	String name = new String("이름일므");
    	Long quest_id = new Long(123);
    	String latitude = new String("33.1234");
    	String longitude = new String("33.14355667");
    	String description = new String("퀘스트 설명 description부분");
    	String addr = new String("주소");
    	String src = new String("이미지 주소..");
    	
        String sql = "insert into quest_item "
        		+ "(name) values (?)";
        try {
            jdbc.update(sql,name, quest_id, latitude, description, addr, src);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<QuestItemVO> findAll() {
    	List<QuestItemVO> ls = null;
        String sql = "select * from quest_item";
        try {
            ls = jdbc.query(sql,new QuestItemRowMapper());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
	
	
}