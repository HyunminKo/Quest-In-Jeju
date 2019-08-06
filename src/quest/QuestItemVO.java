package quest;

public class QuestItemVO {
    private Long id = null;
    private String name = null;
    private Long quest_id = null;
    private String latitude = null;
    private String longitude = null;
    private String description = null;

    @Override
    public String toString() {
        return "QuestItemVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quest_id=" + quest_id +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", description='" + description + '\'' +
                ", addr='" + addr + '\'' +
                ", originalFileName='" + originalFileName + '\'' +
                ", fileSystemName='" + fileSystemName + '\'' +
                '}';
    }

    private String addr = null;
    private String originalFileName = null;
    private String fileSystemName = null;

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getFileSystemName() {
        return fileSystemName;
    }

    public void setFileSystemName(String fileSystemName) {
        this.fileSystemName = fileSystemName;
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

    public Long getQuest_id() {
        return quest_id;
    }

    public void setQuest_id(Long quest_id) {
        this.quest_id = quest_id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
