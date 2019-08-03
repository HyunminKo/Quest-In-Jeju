package relation;

public class UserAliasHaveVO {
    private Long user_id = null;

    @Override
    public String toString() {
        return "UserAliasHaveVO{" +
                "user_id=" + user_id +
                ", alias_id=" + alias_id +
                '}';
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getAlias_id() {
        return alias_id;
    }

    public void setAlias_id(Long alias_id) {
        this.alias_id = alias_id;
    }

    private Long alias_id = null;
}
