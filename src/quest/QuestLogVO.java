package quest;

public class QuestLogVO {
    private Long user_id = null;
    private Long quest_id = null;
    private Long item_id = null;

    @Override
    public String toString() {
        return "QuestLogVO{" +
                "user_id=" + user_id +
                ", quest_id=" + quest_id +
                ", item_id=" + item_id +
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

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }
}
