package board;

public class PostVO {
    private Long id = null;
    private Integer like_count = null;
    private String contents = null;
    private String date = null;
    private Long user_id = null;
    private String src = null;
    private Integer category = null; 

    @Override
    public String toString() {
        return "PostVO{" +
                "id=" + id +
                ", like_count=" + like_count +
                ", contents='" + contents + '\'' +
                ", date='" + date + '\'' +
                ", user_id=" + user_id +
                ", src='" + src + '\'' +
                ", category=" + category +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}
