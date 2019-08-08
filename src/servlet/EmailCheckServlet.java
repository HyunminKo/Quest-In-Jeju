package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.UserDAO;

public class EmailCheckServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		UserDAO dao = new UserDAO();
		PrintWriter out = response.getWriter();
		if(dao.isExistByEmail(email)) {
			out.println("false");
		}else {
			out.println("true");
		}
		out.flush();
	}
	
}
