import user.UserDAO;
import user.UserVO;

import java.util.List;

public class testtest {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        List<UserVO> ls = dao.findAll();
        System.out.println(ls);
    }
}
