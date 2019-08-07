package servlet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import quest.QuestItemDAO;
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
import java.util.List;


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

            if("findAll".equals(method)){
                UserQuestPlayDAO dao = new UserQuestPlayDAO();
                List<UserQuestPlayVO> list = dao.findAll();
                System.out.println(list);
                JSONArray jsonArray = new JSONArray();
                for(UserQuestPlayVO vo : list){
                    jsonArray.add(vo.getQuest_id());
                }
                jsonArray.add(10);
                jsonArray.add(11);
                jsonArray.add(20);
                jsonArray.add(345);
                jsonArray.add(123);
                jsonArray.add(455);

                response.setStatus(HttpServletResponse.SC_OK);
                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(jsonArray.toJSONString());
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
