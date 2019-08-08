//import java.util.List;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//<<<<<<< HEAD
//import quest.QuestDAO;
//import quest.QuestItemDAO;
//import quest.QuestItemVO;
//import quest.QuestVO;

/*
import user.AliasDAO;
import user.AliasVO;
>>>>>>> 6bdf6ba0e07b975053d55dad20dd81e7c7c24bc5
import user.UserDAO;
*/
//public class DBTest {
//    public static void main(String[] args) throws ParseException {
//        //JSON 데이터
//        String jsonInfo = "{\"books\":[{\"genre\":\"소설\",\"price\":\"100\",\"name\":\"사람은 무엇으로 사는가?\",\"writer\":\"톨스토이\",\"publisher\":\"톨스토이 출판사\"},{\"genre\":\"소설\",\"price\":\"300\",\"name\":\"홍길동전\",\"writer\":\"허균\",\"publisher\":\"허균 출판사\"},{\"genre\":\"소설\",\"price\":\"900\",\"name\":\"레미제라블\",\"writer\":\"빅토르 위고\",\"publisher\":\"빅토르 위고 출판사\"}],\"persons\":[{\"nickname\":\"남궁민수\",\"age\":\"25\",\"name\":\"송강호\",\"gender\":\"남자\"},{\"nickname\":\"예니콜\",\"age\":\"21\",\"name\":\"전지현\",\"gender\":\"여자\"}]}";
//        String testStr = "{\"user_id\":1,\"quest_id\":1}";
//        String testStr2 = "{\"user_id\":1,\"quest_id\":1}";
//        System.out.println(testStr);
//        System.out.println(testStr2);
//        try {
//            JSONParser jsonParser = new JSONParser();
//            JSONObject jsonObject = (JSONObject) jsonParser.parse(testStr2);
//
//            System.out.println(jsonObject.get("user_id"));
//            System.out.println(jsonObject.get("quest_id"));
//
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        //insert into user (name, password, email) values ("user1", 1234, "xxx@gmail.com");
///////////////////////////////////////////////////
//        User Test
//        UserDAO dao = new UserDAO();
//        UserVO vo = new UserVO();
//        vo.setName("admin");
//        vo.setPassword("admin");
//        vo.setEmail("admin@admin.com");
//        int rc = dao.insert(vo);
//        System.out.println(rc);
//        List<UserVO> ls = dao.findAll();
//        System.out.println(ls);
///////////////////////////////////////////////////
//        Quest Test
//        QuestDAO questDAO = new QuestDAO();
//        QuestVO questVO = new QuestVO();
//        questVO.setName("오름 정복하기");
//        questVO.setItem_count(3);
//        questVO.setId(1L);
//        System.out.println(questDAO.insert(questVO));

//      QuestDAO questDAO = new QuestDAO();
//      QuestVO questVO = new QuestVO();
//      questVO.setName("로컬맛집 정복하기");
//      questVO.setItem_count(4);
//      questVO.setId(3L);
//      System.out.println(questDAO.insert(questVO));
///////////////////////////////////////////////////
//		  Alias Test
//    	  AliasDAO aliasDAO = new AliasDAO();
//  	  AliasVO aliasVO = new AliasVO();
//   	  aliasDAO.insert(aliasVO);
//    	  aliasVO.setName("바다의 수호자");
//    	  aliasDAO.insert(aliasVO);
//    	  aliasVO.setName("인스타 갬성러");
//    	  aliasDAO.insert(aliasVO);
//    	  aliasVO.setName("고독한 미식가");
//    	  aliasDAO.insert(aliasVO);
//    	  List<AliasVO> list = aliasDAO.findAll();
//    	  System.out.println(list);
///////////////////////////////////////////////////////   	  
//        QuestItem Test
//        QuestItemDAO dao = new QuestItemDAO();
//        QuestItemVO vo = new QuestItemVO();
//        vo.setName("거문오름");
//        vo.setQuest_id(1L);
//        vo.setLatitude("33.365955");
//        vo.setLongitude("126.356440");
//        vo.setDescription("초저녁에 뜨는 샛별 같다고 이름이 붙은 새별오름. 예쁘면서 외로운 이름을 지닌 오름답게 가는 길은 조금 쓸쓸하지만 오름에 올라서면 눈부신 억새들이 반겨주어요. 새별오름은 정상에 올라 다시 돌아오는데 1시간이면 충분하니 가벼운 마음으로 다녀오세요! ");
//        vo.setAddr("제주특별자치도 제주시 애월읍 봉성리 주변");
//        vo.setOriginalFileName("static/img/saebyul.jpeg");
//        vo.setFileSystemName("static/img/saebyul.jpeg");
//        System.out.println(dao.insert(vo));
        
//       
//        vo.setName("용눈이오름");
//        vo.setQuest_id(1L);
//        vo.setLatitude("33.460571");
//        vo.setLongitude("126.831417");
//        vo.setDescription("숨을 헐떡이게 만드는 여느 오름과 달리 용눈이오름을 오르는 길은 평탄하고 부드러워요. 제주도 동쪽 가장 끝에 자리하고 있어 성산일출봉과 바다가 어우러지는 장관을 한눈에 담을 수 있답니다!");
//        vo.setAddr("제주특별자치도 제주시 구좌읍 종달리");
//        vo.setOriginalFileName("static/img/yongnun.jpg");
//        vo.setFileSystemName("static/img/yongnun.jpg");
//        System.out.println(dao.insert(vo));
////        
//        List<QuestItemVO> ls = dao.findAll();
//        System.out.println(ls);
	        
      
        
//
//        vo.setName("거문오름");
//        vo.setQuest_id(1L);
//        vo.setLatitude("33.4550191");
//        vo.setLongitude("126.7177087");
//        vo.setDescription("거문오름은 해발 456m(둘레 4,551m)의 오름으로 거문오름 용암동굴계를 형성한 모체로 알려져 있다. 숲이 우거져 검게 보여 검은오름이라 하였다고 전해진다. 제주도의 오름 중 유일하게 유네스코 세계자연유산에 등재되었는데, 이는 거문오름에서 흘러나온 용암류가 경사를 따라 북동쪽 해안가까지 흘러가면서 지질학적 가치가 높은 화산지형과 용암동굴을 만들어 냈기 때문이다. 제주도 자연유산지구 학술조사용역결과에 따르면 선흘리 거문오름 주변에 발달한 동굴의 규모는 용암동굴로서는 세계적인 수준인 것으로 확인되었다.");
//        vo.setAddr("제주특별자치도 제주시 조천읍 선흘리 주변");
//        vo.setOriginalFileName("static/img/gumun.jpg");
//        vo.setFileSystemName("static/img/gumun.jpg");
//        System.out.println(dao.insert(vo));
//
//        vo.setName("노로오름");
//        vo.setQuest_id(1L);
//        vo.setLatitude("33.3684804");
//        vo.setLongitude("126.4399921");
//        vo.setDescription("'노로'는 노루를 뜻하는 옛말로, 예전에 노루가 많이 서식 했다고 하여 붙여진 이름이라고 합니다.");
//        vo.setAddr("제주특별자치도 제주시 애월읍 어음리 주변");
//        vo.setOriginalFileName("static/img/noro.jpg");
//        vo.setFileSystemName("static/img/noro.jpg");
//        System.out.println(dao.insert(vo));
//
//        List<QuestItemVO> list = dao.findAll();
//        System.out.println(list);
//    	UserDAO dao = new UserDAO();
//    	System.out.println(dao.findAll());
//    }
//}
