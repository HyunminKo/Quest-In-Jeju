package servlet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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


            if ("queryForObject".equals(method)) {
                Long user_id = (Long) jsonObject.get("user_id");
                Long quest_id = (Long) jsonObject.get("quset_id");

            }else if("findAll".equals(method)){
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
            }


//            if("insert".equals(method)){
//                Long quest_id = (Long) jsonObject.get("quest_id");
//                UserQuestPlayDAO dao = new UserQuestPlayDAO();
//                UserQuestPlayVO vo = new UserQuestPlayVO();
//                //임시
//                vo.setUser_id(1L);
//                vo.setQuest_id(quest_id);
//                dao.insert(vo); // user_quest_play에 추가
//
//                QuestItemDAO questItemDAO = new QuestItemDAO();
//                List<Long> idList = questItemDAO.findIdsByQuestId(quest_id);
//                UserItemPlayDAO userItemPlayDAO = new UserItemPlayDAO();
//                UserItemPlayVO userItemPlayVO = new UserItemPlayVO();
//                userItemPlayVO.setIs_completed(0);
//                userItemPlayVO.setUser_id(1L);
//                for(Long id : idList){
//                    userItemPlayVO.setItem_id(id);
//                    userItemPlayDAO.insert(userItemPlayVO);
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        // user_item_play 테이블에서 user_id와 item_id로 찾아야 됨
        // user_item_play 테이블에서 "is_completed" 애트리뷰트 값을 1로 변경 -> 완료했다는 의미


//        UserItemPlayDAO dao = new UserQuestItemDAO();
//
//        String sql = "select item_id from user_item_play where item_id = (?)";
//        dao.queryForObject(sql, <UserItemPlayVO>);


        // 모든 item을 불러와라
    }
}

