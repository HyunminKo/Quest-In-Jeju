package servlet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import quest.QuestItemVO;
import relation.UserItemPlayDAO;
import relation.UserItemPlayVO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class UserItemPlayServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {


        StringBuffer sb = new StringBuffer();
        String line = null;

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(sb.toString());

            String method = (String) jsonObject.get("method");
            Long user_id = (Long) jsonObject.get("user_id");
            Long item_id = (Long) jsonObject.get("item_id");

            if("findAll".equals(method)){
                UserItemPlayDAO dao = new UserItemPlayDAO();
                List<UserItemPlayVO> list = dao.findAll();
                System.out.println(list);
                JSONArray jsonArray = new JSONArray();
                for(UserItemPlayVO vo : list){
                    jsonArray.add(vo);
                }
                response.setStatus(HttpServletResponse.SC_OK);
                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(jsonArray.toJSONString());
                out.flush();
            }else if("getQuestItemByUserId".equals(method)){
                UserItemPlayDAO dao = new UserItemPlayDAO();
                // 임시 user id: 1
                List<QuestItemVO> list = dao.getPlayingQuestItemsByUserId(1L);
                JSONArray jsonArray = new JSONArray();
                for(QuestItemVO vo : list){
                    jsonArray.add(vo);
                }
                response.setStatus(HttpServletResponse.SC_OK);
                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(jsonArray.toJSONString());
                System.out.println("userItemPlayServlet: "+jsonArray.toJSONString());
                out.flush();
            }else if("update".equals(method)){
                UserItemPlayDAO dao = new UserItemPlayDAO();
                int rc = dao.update(user_id, item_id);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

