package user;

public class AliasVO {
    private Long id = null;
    private String name = null;

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

    @Override
    public String toString() {
        return "AliasVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
