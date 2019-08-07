package servlet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import relation.UserItemPlayDAO;
import relation.UserItemPlayVO;



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


public class UserItemPlayServlet extends HttpServlet {

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

            // 한 줄 검색
//            if("queryForObject".equals(method)) {
//                Long user_id = (Long)jsonObject.get("user_id");
//                Long item_id = (Long)jsonObject.get("item_id");
//
//                UserItemPlayDAO dao = new UserItemPlayDAO();
//                UserItemPlayVO vo = new UserItemPlayVO();
//
//                vo = dao.queryForObject(user_id, item_id);
//            }

            if("update".equals(method)){
                Long user_id = (Long)jsonObject.get("user_id");
                Long item_id = (Long)jsonObject.get("item_id");

                UserItemPlayDAO dao = new UserItemPlayDAO();
                dao.update(user_id, item_id);
            }



        } catch(Exception e) {
            e.printStackTrace();
        }


    }
}

