import user.AliasDAO;
import user.AliasVO;
import user.UserDAO;
import user.UserVO;

import java.util.List;

import board.PostDAO;
import board.PostVO;
import quest.QuestItemDAO;
import quest.QuestItemVO;
import relation.UserQuestPlayDAO;
import relation.UserQuestPlayVO;

public class testtest {
    public static void main(String[] args) {
    	/*
    	UserDAO dao = new UserDAO();
        List<UserVO> ls = dao.findAll();
        System.out.println(ls);
       */
       
    	QuestItemDAO dao = new QuestItemDAO();
    	List<QuestItemVO> ls = dao.findAll();
    	System.out.println(ls);
    }
}
