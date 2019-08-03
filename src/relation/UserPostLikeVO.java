package relation;

public class UserPostLikeVO {
    private Long user_id = null;

    @Override
    public String toString() {
        return "UserPostLikeVO{" +
                "user_id=" + user_id +
                ", post_id=" + post_id +
                '}';
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    private Long post_id = null;
}
