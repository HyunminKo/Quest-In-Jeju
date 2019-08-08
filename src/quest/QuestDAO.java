package quest;

import jdbcUtil.JdbcTemplate;
import relation.UserItemPlayDAO;
import relation.UserItemPlayVO;
import rowmapper.QuestRowMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

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
    public List<QuestItemVO> getPlayingUserQuest(HttpServletRequest request, Long userId){
        UserItemPlayDAO dao = new UserItemPlayDAO();
        Set<Long> questIdSet = new HashSet<>();
        List<QuestItemVO> questItems = dao.getPlayingQuestItemsByUserId(userId);
        List<UserItemPlayVO> userItemsInfo = dao.getPlayingItemInfoByUserId(userId);

        HttpSession session = request.getSession();

        Map<Long, Integer> userItemsInfoMap = new HashMap<>();
        for(UserItemPlayVO info : userItemsInfo){
            userItemsInfoMap.put(info.getItem_id(),info.getIs_completed());
        }

        session.setAttribute("userItemsInfoMap",userItemsInfoMap);

        Map<Long, Map<String,Map<String,String>>> questMap = new HashMap<>();
        Map<Long,List<QuestItemVO>> questList = new HashMap<>();
        for(QuestItemVO vo : questItems){
            Long quest_id = vo.getQuest_id();
            questIdSet.add(quest_id);
            if(!questMap.containsKey(quest_id)){
                questMap.put(quest_id,new HashMap<>());
            }
            if(!questList.containsKey(quest_id)){
                questList.put(quest_id,new ArrayList<>());
            }
            questList.get(quest_id).add(vo);
            Map<String,Map<String,String>> itemKeyMap =  questMap.get(quest_id);
            String itemKey = String.valueOf(vo.getId());
            HashMap<String,String> itemMap = new HashMap<>();
            itemMap.put("name",vo.getName());
            itemMap.put("description",vo.getDescription());
            itemMap.put("addr",vo.getAddr());
            itemMap.put("latitude",vo.getLatitude());
            itemMap.put("longitude",vo.getLongitude());
            itemMap.put("originalfilename",vo.getOriginalFileName());
            itemMap.put("filesystemname",vo.getFileSystemName());
            itemMap.put("isCompleted",String.valueOf(userItemsInfoMap.get(vo.getId())));
            itemKeyMap.put(itemKey,itemMap);
        }
        session.setAttribute("questIdSet",questIdSet);
        session.setAttribute("questMap",questMap);
        session.setAttribute("questList",questList);
        System.out.println(questIdSet);
        System.out.println(questMap);
        System.out.println(questList);
        return questItems;
    }

    public Map<Long, String> getQuestNameMap() {
        Map<Long, String> result = new HashMap<>();
        List<QuestVO> list = this.findAll();
        for(QuestVO vo : list){
            result.put(vo.getId(),vo.getName());
        }
        return result;
    }

//    public int getItemCount(Long quest_id) {
//        String sql = "select * from quest where id=?";
//        QuestVO vo = null;
//        try {
//            vo = jdbc.queryForObject(sql, new QuestRowMapper(), quest_id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return vo.getItem_count();
//    }
}