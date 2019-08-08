package relation;

public class QuestAliasVO {
    private Long alias_id = null;
    private Long quest_id = null;

    @Override
    public String toString() {
        return "QuestAliasVO{" +
                "alias_id=" + alias_id +
                ", quest_id=" + quest_id +
                '}';
    }

    public Long getAlias_id() {
        return alias_id;
    }

    public void setAlias_id(Long alias_id) {
        this.alias_id = alias_id;
    }

    public Long getQuest_id() {
        return quest_id;
    }

    public void setQuest_id(Long quest_id) {
        this.quest_id = quest_id;
    }
}
