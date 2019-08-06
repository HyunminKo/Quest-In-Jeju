import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
///////////////////////////////////////////////////
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
    }
}
