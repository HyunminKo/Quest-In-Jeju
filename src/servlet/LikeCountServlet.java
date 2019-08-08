package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import board.PostDAO;
import relation.UserPostLikeDAO;
import relation.UserPostLikeVO;
import util.Utils;

public class LikeCountServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctxPath = request.getContextPath();
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
            String postId = (String) jsonObject.get("post_id");
            String userId = Utils.getValueInCookie(request, "user_id");
            
            PostDAO postDAO = new PostDAO();
            UserPostLikeDAO userPostLikeDAO = new UserPostLikeDAO();
            
            UserPostLikeVO vo = new UserPostLikeVO();
            if("Add".equals(method)) {
            	postDAO.updateLikeCount(Long.parseLong(postId), "Add");
            	
            	vo.setPost_id(Long.parseLong(postId));
            	vo.setUser_id(Long.parseLong(userId));
            	userPostLikeDAO.insert(vo);
            	
            }else if("Sub".equals(method)) {
            	postDAO.updateLikeCount(Long.parseLong(postId), "Sub");
                userPostLikeDAO.delete(Long.parseLong(postId),Long.parseLong(userId));
            }
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = response.getWriter();
            out.println(method);
            out.flush();
            out.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        System.out.println("END");
        
		response.sendRedirect(ctxPath + "/timeline.jsp");
	}
	

}
