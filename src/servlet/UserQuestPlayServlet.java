package servlet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import quest.QuestItemDAO;
import quest.QuestItemVO;
import relation.UserItemPlayDAO;
import relation.UserItemPlayVO;
import relation.UserQuestPlayDAO;
import relation.UserQuestPlayVO;
import util.Utils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


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
                String userId = Utils.getValueInCookie(request,"user_id");
                if(userId == null){
                    response.setStatus(HttpServletResponse.SC_OK);

                    return ;
                }

                HttpSession session = request.getSession();
                Map<Long, Map<String,Map<String,String>>> questMap = (Map<Long, Map<String,Map<String,String>>>) session.getAttribute("questMap");
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

                String userId = Utils.getValueInCookie(request,"user_id");
                if(userId ==null){
                    return ;
                }

                vo.setUser_id(Long.parseLong(userId));
                vo.setQuest_id(quest_id);
                dao.insert(vo); // user_quest_play에 추가

                QuestItemDAO questItemDAO = new QuestItemDAO();
                List<Long> idList = questItemDAO.findIdsByQuestId(quest_id);
                UserItemPlayDAO userItemPlayDAO = new UserItemPlayDAO();
                UserItemPlayVO userItemPlayVO = new UserItemPlayVO();
                userItemPlayVO.setIs_completed(0);
                userItemPlayVO.setUser_id(Long.parseLong(userId));
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
