package servlet;

//import relation.UserItemPlayDAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


public class UserItemPlayServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StringBuffer json = new StringBuffer();
        String line = null;

        try {
            BufferedReader reader = request.getReader();
            while((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch(Exception e) {
            System.out.println("JSON Error");
        }
        System.out.println(json.toString());


        // user_item_play 테이블에서 "is_completed" 애트리뷰트 값을 1로 변경 -> 완료했다는 의미
//        UserItemPlayDAO dao = new UserQuestItemDAO();
//
//        String sql = "select item_id from user_item_play where item_id = (?)";
//        dao.queryForObject(sql, <UserItemPlayVO>);

    }

}
