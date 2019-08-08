import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
//        vo.setName("새별오름");
//        vo.setQuest_id(1L);
//        vo.setLatitude("33.3669846");
//        vo.setLongitude("126.3564604");
//        vo.setDescription("이름에서부터 샛별이 보이는 새별오름(519m). 초저녁에 뜨는 샛별 같다고 이름 붙었단다. 새별오름의 새별은 샛별, 금성을 뜻하는데, 이른 아침 이 오름을 찾으면 금성의 빛을 만난다고 이런 이름이 붙었다는 얘기도 있다. 실제로 새별오름을 찾아가다 보면 허허벌판에 외롭게 서있는 그를 발견하게 된다. 예쁘면서 외로운 이름을 지닌 오름답게 가는 길은 조금 쓸쓸하지만 일단 오름에 올라서면 눈부신 억새들이 반겨준다. 이름도 이름이지만 새별오름이 우리들에게 다가온 것은 매년 정월대보름 열리는 들불 축제 공이 크다. 가을에는 억새축제도 진행되곤 했다. 굳이 축제일정을 기억하지 않아도 가을날의 새별오름은 억새꽃 춤사위가 끊이질 않는다.");
//        vo.setAddr("제주특별자치도 제주시 애월읍 봉성리 주변");
//        vo.setOriginalFileName("static/img/saebyul.jpeg");
//        vo.setFileSystemName("static/img/saebyul.jpeg");
//        System.out.println(dao.insert(vo));
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
//        vo.setDescription("세계자연유산 제주 오름제주 단원이 들려주는 제주도 오름 노로오름 이야기. 크고 작은 제주도의  수많은 오름 들 중에서도 오늘 오름제주님께서 여러분께 소개해 드릴 곳은 바로 노로오름이랍니다. '노로'는 노루를 뜻하는 옛말로, 예전에 노루가 많이 서식 했다고 하여 붙여진 이름이라고 합니다. 제주도 오름 산행을 계획하고 계신 분들께서는 오늘 오름 이야기, 참고하시길 바랍니다~ :) ");
//        vo.setAddr("제주특별자치도 제주시 애월읍 어음리 주변");
//        vo.setOriginalFileName("static/img/noro.jpg");
//        vo.setFileSystemName("static/img/noro.jpg");
//        System.out.println(dao.insert(vo));
//
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
