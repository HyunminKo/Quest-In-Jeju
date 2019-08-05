package quest;

import java.util.List;

import jdbcUtil.JdbcTemplate;
import relation.UserQuestPlayVO;
import rowmapper.QuestItemRowMapper;
import rowmapper.UserQuestPlayRowMapper;
//이름만 넣어보기 
public class QuestItemDAOTest {

    JdbcTemplate jdbc = new JdbcTemplate();
    public void insert(){
    	
    	String[] name = {"새별오름", "거문오름", "노로오름", "노꼬메오름"};
    	
    	for(int i=0;i<5;i++){
	        String sql = "insert into quest_item (name) values (?)";
	        try {
	            jdbc.update(sql,name[i]);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
    	}//end for 
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