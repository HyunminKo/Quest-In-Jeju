package servlet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import quest.QuestDAO;
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
import java.util.Map;


public class UserQuestPlayServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getContextPath());
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

//                PrintWriter out = response.getWriter();
//                response.setContentType("application/json");
//                response.setCharacterEncoding("UTF-8");
//                out.print(jsonObject.toJSONString(list));
//                out.flush();
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
