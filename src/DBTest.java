import java.text.ParseException;

//import java.util.List;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import quest.QuestDAO;
//import quest.QuestItemDAO;
//import quest.QuestItemVO;
//import quest.QuestVO;

//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import quest.QuestDAO;
//import quest.QuestItemDAO;
//import quest.QuestItemVO;
//import quest.QuestVO;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import quest.QuestDAO;
import quest.QuestItemDAO;
import quest.QuestItemVO;
import quest.QuestVO;
/*
import user.AliasDAO;
import user.AliasVO;
import user.UserDAO;
*/
public class DBTest {
        public static void main(String[] args) throws ParseException {
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
//      questVO.setName("이색체험 정복하기");
//      questVO.setItem_count(4);
//      questVO.setId(2L);
//      System.out.println(questDAO.insert(questVO));


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
//        vo.setName("용담 해안도로");
//        vo.setQuest_id(4L);
//        vo.setLatitude("33.558577");
//        vo.setLongitude("126.763316");
//        vo.setDescription("용담동에서 이호동으로 이어지는 해안도로. 제주공항에서 가깝고 일몰이 예뻐서 많은 분들이 찾아요! 용담 해안도로의 끝에 있는 이호테우 해변도 좋답니다. ");
//        vo.setAddr("제주특별자치도 제주시 구좌읍 김녕리 주변");
//        vo.setOriginalFileName("yongdam.jpg");
//        vo.setFileSystemName("static/img/yongdam.jpg");
//        System.out.println(dao.insert(vo));
        
////       
//        vo.setName("애월 해안도로");
//        vo.setQuest_id(4L);
//        vo.setLatitude("33.483934");
//        vo.setLongitude("126.378466");
//        vo.setDescription("푸르른 바닷가와 탁 트인 전경을 보며 하염없이 달리다 보면, 용암대지가 품고 있던 샘물이 솟구치는 중엄새물이 나와요. 파도가 찰랑이는 샘터에서 힐링 하고 가세요!");
//        vo.setAddr("제주특별자치도 제주시 애월읍 주변");
//        vo.setOriginalFileName("aewol.jpg");
//        vo.setFileSystemName("static/img/aewol.jpg");
//        System.out.println(dao.insert(vo));
////        
//   
//        
////
//        vo.setName("신창 풍차 해안도로");
//        vo.setQuest_id(4L);
//        vo.setLatitude("33.342981");
//        vo.setLongitude("126.174091");
//        vo.setDescription("제주의 맑은 물빛 중에서도 손꼽히는 에메랄드빛 해안을 가진 풍차 해안도로 ! 색다른 경험을 해보고 싶으신 분들은 풍차 해안도로에 있는 투명 카약을 타보시는 것을 추천합니다 ");
//        vo.setAddr("제주특별자치도 제주시 한경면 신창리 주변");
//        vo.setOriginalFileName("windmill.JPG");
//        vo.setFileSystemName("static/img/windmill.JPG");
//        System.out.println(dao.insert(vo));
////
//        vo.setName("성산 세화 해안도로");
//        vo.setQuest_id(4L);
//        vo.setLatitude("33.342981");
//        vo.setLongitude("126.174091");
//        vo.setDescription("세화 해안도로는 해맞이 해안로이기도 하지만 제주 환상 자전거길 구간이기도 하고, 중간중간 올레길을 공유하는 구간이기도 합니다. 도로를 따라 가다보면 독립서점부터 소소한 카페도 많으니 놓치지 이 점도 놓치지 마세요!");
//        vo.setAddr("제주특별자치도 제주시 구좌읍 종달리");
//        vo.setOriginalFileName("jongdal.JPG");
//        vo.setFileSystemName("static/img/jongdal.JPG");
//        System.out.println(dao.insert(vo));
//        
                QuestItemDAO dao = new QuestItemDAO();
                QuestItemVO vo = new QuestItemVO();
                vo.setName("용담 해안도로");
                vo.setQuest_id(4L);
                vo.setLatitude("33.558577");
                vo.setLongitude("126.763316");
                vo.setDescription("용담동에서 이호동으로 이어지는 해안도로. 제주공항에서 가깝고 일몰이 예뻐서 많은 분들이 찾아요! 용담 해안도로의 끝에 있는 이호테우 해변도 좋답니다. ");
                vo.setAddr("제주특별자치도 제주시 구좌읍 김녕리 주변");
                vo.setOriginalFileName("yongdam.jpg");
                vo.setFileSystemName("static/img/yongdam.jpg");
                System.out.println(dao.insert(vo));

//       
                vo.setName("애월 해안도로");
                vo.setQuest_id(4L);
                vo.setLatitude("33.483934");
                vo.setLongitude("126.378466");
                vo.setDescription("푸르른 바닷가와 탁 트인 전경을 보며 하염없이 달리다 보면, 용암대지가 품고 있던 샘물이 솟구치는 중엄새물이 나와요. 파도가 찰랑이는 샘터에서 힐링 하고 가세요!");
                vo.setAddr("제주특별자치도 제주시 애월읍 주변");
                vo.setOriginalFileName("aewol.jpg");
                vo.setFileSystemName("static/img/aewol.jpg");
                System.out.println(dao.insert(vo));
//        


//
                vo.setName("신창 풍차 해안도로");
                vo.setQuest_id(4L);
                vo.setLatitude("33.342981");
                vo.setLongitude("126.174091");
                vo.setDescription("제주의 맑은 물빛 중에서도 손꼽히는 에메랄드빛 해안을 가진 풍차 해안도로 ! 색다른 경험을 해보고 싶으신 분들은 풍차 해안도로에 있는 투명 카약을 타보시는 것을 추천합니다 ");
                vo.setAddr("제주특별자치도 제주시 한경면 신창리 주변");
                vo.setOriginalFileName("windmill.JPG");
                vo.setFileSystemName("static/img/windmill.JPG");
                System.out.println(dao.insert(vo));
//
                vo.setName("성산 세화 해안도로");
                vo.setQuest_id(4L);
                vo.setLatitude("33.342981");
                vo.setLongitude("126.174091");
                vo.setDescription("세화 해안도로는 해맞이 해안로이기도 하지만 제주 환상 자전거길 구간이기도 하고, 중간중간 올레길을 공유하는 구간이기도 합니다. 도로를 따라 가다보면 독립서점부터 소소한 카페도 많으니 놓치지 이 점도 놓치지 마세요!");
                vo.setAddr("제주특별자치도 제주시 구좌읍 종달리");
                vo.setOriginalFileName("jongdal.JPG");
                vo.setFileSystemName("static/img/jongdal.JPG");
                System.out.println(dao.insert(vo));


//        List<QuestItemVO> list = dao.findAll();
//        System.out.println(list);
//    	UserDAO dao = new UserDAO();
//    	System.out.println(dao.findAll());
 /*   	
    	QuestItemDAO dao = new QuestItemDAO();
        QuestItemVO vo = new QuestItemVO();
        vo.setName("용눈이오름");
        vo.setQuest_id(1L);
        vo.setLatitude("33.460571");
        vo.setLongitude("126.831417");
        vo.setDescription("숨을 헐떡이게 만드는 여느 오름과 달리 용눈이오름을 오르는 길은 평탄하고 부드럽다. 동산을 걸어가듯 천천히 오르면 어우러지는 세 개의 능선이 말발자국처럼 둘러선 정상에 도착하게 된다. 368개에 이른다는 제주 오름들 중 유일하게 세 개의 분화구를 함께 가지는 특별한 모습이다. 제주도 동쪽 가장 끝에 자리하고 있어 성산일출봉과 바다가 어우러지는 장관을 한눈에 담을 수 있다.");
        vo.setAddr("제주특별자치도 제주시 구좌읍 종달리");
        vo.setOriginalFileName("static/img/yongnun.jpg");
        vo.setFileSystemName("static/img/yongnun.jpg");
        System.out.println(dao.insert(vo));
        
        
      
       	QuestItemDAO dao = new QuestItemDAO();
        QuestItemVO vo = new QuestItemVO();
    	List<QuestItemVO> list = dao.findAll();
    	System.out.println(dao.findAll());
    	
    	
      vo.setName("제주 청초밭");
      vo.setQuest_id(2L);
      vo.setLatitude("33.421387");
      vo.setLongitude("126.781652");
      vo.setDescription("제주 동부 핫 플레이스 동백꽃 가득한 청초밭! 제주도에서 인생샷을 건지고 싶다면 이곳 청초밭으로 오세요. 붉은 동백꽃길을 걷다보면 올곧은 삼나무길도 나옵니다. 복잡한 도심속 마음의 휴식을 얻고싶다면 제주 청초밭으로 힐링하세요.");
      vo.setAddr("제주 특별자치도 서귀포시 표선면 성읍리 2497");
      vo.setOriginalFileName("static/img/chungcho.jpg");
      vo.setFileSystemName("static/img/chungcho.jpg");
      System.out.println(dao.insert(vo));
      
      
      vo.setName("제주 모노리스");
      vo.setQuest_id(2L);
      vo.setLatitude("33.390750");
      vo.setLongitude("126.366586");
      vo.setDescription("모노리스는 놀이의 본질인 일탈성과 자유로움을 지키면서 현대 사회의 즐거움에 맞게 시공간을 확장한 새로운 개념의 스마트 플레이 파크(Smart Play Park), 스마트「놀이+터」를 계획하는 곳입니다. 모노리스 테마파크에서 참석자들에게 랩타임과 실시간 랭킹데이터 그리고 본인의 사진과 영상을 바로 확인할 수 있는 앱 서비스도 제공되어있다. 나만의 경기 영상을 찍고 싶다면 어서 도전하세요!");
      vo.setAddr("제주특별자치도 제주시 애월읍 어음리 산 131-3");
      vo.setOriginalFileName("static/img/mono.jpg");
      vo.setFileSystemName("static/img/mono.jpg");
      System.out.println(dao.insert(vo));
    	
      vo.setName("빅볼랜드");
      vo.setQuest_id(2L);
      vo.setLatitude("33.388871");
      vo.setLongitude("126.374338");
      vo.setDescription("빅볼은 커다란 원형 플라스틱 공 안에 2m의 또 다른 공이 들어있어 이 안에 사람이 들어가 언덕을 구르며 내려오는 놀이, 레포츠 기구입니다. 제주도에서 새로운 체험을 느끼고 싶다면 어서 빅볼에 몸을 맡겨보세요!");
      vo.setAddr("제주특별자치도 제주시 애월읍 산록서로");
      vo.setOriginalFileName("static/img/bigball.jpg");
      vo.setFileSystemName("static/img/bigball.jpg");
      System.out.println(dao.insert(vo));   	
      
      
      vo.setName("포니밸리");
      vo.setQuest_id(2L);
      vo.setLatitude("33.402695");
      vo.setLongitude("126.778671");
      vo.setDescription("몽골리안이 펼치는 아슬아슬한 마상마예공연과 귀여운 포니들을 만날 수 있는 기회! 우리나라에서 유일하게 새끼 낙타를 구경할 수 있는 곳이기도 합니다. 아이들과 함께하기 좋은곳이에요.");
      vo.setAddr("제주특별자치도 서귀포시 표선면 번영로 2564-21");
      vo.setOriginalFileName("static/img/pony.jpg");
      vo.setFileSystemName("static/img/pony.jpg");
      System.out.println(dao.insert(vo));         
    	
      vo.setName("레포츠랜드");
      vo.setQuest_id(2L);
      vo.setLatitude("33.482408");
      vo.setLongitude("126.638649");
      vo.setDescription("레포츠 랜드는 국내 최대 카트체험장으로 썰매, 사격, 짚라인 등 다양한 레저스포츠를 체험할 수 있어요! 봄, 여름, 가을, 겨울 사계절 체험이 가능하고 set로 이용하면 할인 받을 수 있습니다.");
      vo.setAddr("제주특별자치도 제주시 조천읍 와홀상서2길 47");
      vo.setOriginalFileName("static/img/reports.jpg");
      vo.setFileSystemName("static/img/reports.jpg");
      System.out.println(dao.insert(vo));  

   */
        }
}
//    }
//}
