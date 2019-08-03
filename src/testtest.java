import user.AliasDAO;
import user.AliasVO;
import user.UserDAO;
import user.UserVO;

import java.util.List;

import relation.UserQuestPlayDAO;
import relation.UserQuestPlayVO;

public class testtest {
    public static void main(String[] args) {
      /*  UserDAO dao = new UserDAO();
        List<UserVO> ls = dao.findAll();
        System.out.println(ls);
        */
        UserQuestPlayDAO dao = new UserQuestPlayDAO();
        List<UserQuestPlayVO> ls = dao.findAll();
        System.out.println(ls);
    }
}
