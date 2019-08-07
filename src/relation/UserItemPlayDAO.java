//package relation;
//
//import jdbcUtil.JdbcTemplate;
//import rowmapper.UserItemPlayRowMapper;
//
//public class UserItemPlayDAO {
//
//
//    JdbcTemplate jdbc = new JdbcTemplate();
//
//    public UserQuestPlayVO queryForObject(user_id, item_id){
//        String sql = "select user_id, item_id from user_item_play where user_id=? and item_id=?";
//        UserItemPlayVO vo = new UserItemPlayVO();
//        UserItemPlayRowMapper rowMapper = new UserItemPlayRowMapper();
//        try {
//            vo = jdbc.queryForObject(sql, rowMapper, user_id, item_id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return vo;
//    }
//}
