package servlet;

import quest.QuestDAO;
import quest.QuestVO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


public class QuestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        QuestDAO dao = new QuestDAO();
        List<QuestVO> ls = dao.findAll();

    }

}
