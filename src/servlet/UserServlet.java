package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.QuestDAO;
import quest.QuestVO;
import user.UserDAO;
import user.UserVO;

public class UserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		UserDAO dao = new UserDAO();
        List<UserVO> ls = dao.findAll();
			}

	}
