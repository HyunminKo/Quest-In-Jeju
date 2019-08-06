package quest;

import jdbcUtil.JdbcTemplate;
import rowmapper.QuestItemRowMapper;

import java.util.List;

public class QuestItemDAO {

    JdbcTemplate jdbc = new JdbcTemplate();
    public int insert(QuestItemVO vo){
    	// insert into quest_item (name, quest_id, latitude, longitude, description, addr, originalfilename, filesystemname) values (“새별오름”,1, “33.3669846”, “126.3564604”, “이름에서부터 샛별이 보이는 새별오름(519m). 초저녁에 뜨는 샛별 같다고 이름 붙었단다. 새별오름의 새별은 샛별, 금성을 뜻하는데, 이른 아침 이 오름을 찾으면 금성의 빛을 만난다고 이런 이름이 붙었다는 얘기도 있다. 실제로 새별오름을 찾아가다 보면 허허벌판에 외롭게 서있는 그를 발견하게 된다. 예쁘면서 외로운 이름을 지닌 오름답게 가는 길은 조금 쓸쓸하지만 일단 오름에 올라서면 눈부신 억새들이 반겨준다. 이름도 이름이지만 새별오름이 우리들에게 다가온 것은 매년 정월대보름 열리는 들불 축제 공이 크다. 가을에는 억새축제도 진행되곤 했다. 굳이 축제일정을 기억하지 않아도 가을날의 새별오름은 억새꽃 춤사위가 끊이질 않는다.”, “제주특별자치도 제주시 애월읍 봉성리 주변”, “static/img/saebyul.jpeg”,”static/img/saebyul.jpeg”);
        int rc = -1;

        String sql = "insert into quest_item (name, quest_id, latitude, longitude, description, addr, originalfilename, filesystemname) values " +
                "(?,?,?,?,?,?,?,?)";
        try {
            rc = jdbc.update(sql,vo.getName(), vo.getQuest_id(), vo.getLatitude(), vo.getLongitude(),vo.getDescription(), vo.getAddr(), vo.getOriginalFileName(),vo.getFileSystemName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rc;
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