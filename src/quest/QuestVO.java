package quest;

public class QuestVO {
    private Long id = null;
    private String name = null;
    private Integer item_count = null;

    @Override
    public String toString() {
        return "QuestVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", item_count=" + item_count +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getItem_count() {
        return item_count;
    }

    public void setItem_count(Integer item_count) {
        this.item_count = item_count;
    }
}
