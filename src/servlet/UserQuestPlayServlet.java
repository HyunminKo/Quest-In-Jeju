package servlet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import quest.QuestItemDAO;
import quest.QuestItemVO;
import relation.UserItemPlayDAO;
import relation.UserItemPlayVO;
import relation.UserQuestPlayDAO;
import relation.UserQuestPlayVO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserQuestPlayServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StringBuffer sb = new StringBuffer();
        String line = null;

        try {
            BufferedReader reader = request.getReader();
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(sb.toString());

            String method = (String) jsonObject.get("method");
            if("getUserQuestAndItemsPlayingByUserId".equals(method)){
                UserItemPlayDAO dao = new UserItemPlayDAO();
                //임시
                List<QuestItemVO> questItems = dao.getPlayingQuestItemsByUserId(1L);
                List<UserItemPlayVO> userItemsInfo = dao.getPlayingItemInfoByUserId(1L);
                Map<Long, Integer> userItemsInfoMap = new HashMap<>();
                for(UserItemPlayVO info : userItemsInfo){
                    userItemsInfoMap.put(info.getItem_id(),info.getIs_completed());
                }
                Map<Long, Map<String,Map<String,String>>> questMap = new HashMap<>();
                for(QuestItemVO vo : questItems){
                    Long quest_id = vo.getQuest_id();
                    if(!questMap.containsKey(quest_id)){
                        questMap.put(quest_id,new HashMap<>());
                    }
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

                JSONObject jsonMap = new JSONObject();
                jsonMap.putAll(questMap);

                response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType("application/json;charset=utf-8");
                response.setCharacterEncoding("utf-8");

                PrintWriter out = response.getWriter();
                out.print(jsonMap.toJSONString());
                out.flush();
            }else if("insert".equals(method)){
                Long quest_id = (Long) jsonObject.get("quest_id");
                UserQuestPlayDAO dao = new UserQuestPlayDAO();
                UserQuestPlayVO vo = new UserQuestPlayVO();
                //임시
                vo.setUser_id(1L);
                vo.setQuest_id(quest_id);
                dao.insert(vo); // user_quest_play에 추가

                QuestItemDAO questItemDAO = new QuestItemDAO();
                List<Long> idList = questItemDAO.findIdsByQuestId(quest_id);
                UserItemPlayDAO userItemPlayDAO = new UserItemPlayDAO();
                UserItemPlayVO userItemPlayVO = new UserItemPlayVO();
                userItemPlayVO.setIs_completed(0);
                userItemPlayVO.setUser_id(1L);
                for(Long id : idList){
                    userItemPlayVO.setItem_id(id);
                    userItemPlayDAO.insert(userItemPlayVO);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }


    }

}
