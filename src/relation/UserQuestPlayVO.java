package relation;

public class UserQuestPlayVO {
    private Long user_id = null;
    private Long quest_id = null;

    @Override
    public String toString() {
        return "UserQuestPlayVO{" +
                "user_id=" + user_id +
                ", quest_id=" + quest_id +
                '}';
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getQuest_id() {
        return quest_id;
    }

    public void setQuest_id(Long quest_id) {
        this.quest_id = quest_id;
    }
}
