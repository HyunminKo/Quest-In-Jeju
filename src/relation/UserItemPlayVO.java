package relation;

public class UserItemPlayVO {
    private Long user_id = null;
    private Long item_id = null;
    private Integer is_completed = null;

    @Override
    public String toString() {
        return "UserItemPlayVO{" +
                "user_id=" + user_id +
                ", item_id=" + item_id +
                ", is_completed=" + is_completed +
                '}';
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Integer getIs_completed() {
        return is_completed;
    }

    public void setIs_completed(Integer is_completed) {
        this.is_completed = is_completed;
    }
}
