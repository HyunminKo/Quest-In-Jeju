package servlet;

import relation.UserQuestPlayDAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


public class UserQuestPlayServlet extends HttpServlet {

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


        String quest = json.substring(12,13);
        String user = json.substring(24,25);


        System.out.println(quest);
        System.out.println(user);


        Long user_id = Long.parseLong(user);
        Long quest_id = Long.parseLong(quest);


        UserQuestPlayDAO dao = new UserQuestPlayDAO();
        dao.insert(user_id, quest_id);

    }

}
