package apiTestPlat.dataobject.vo1;

public class CaseQueryVO{

    private Integer page = 1;
    private Integer limit = 10;
    private Integer groupId;
    private Integer id;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CaseQueryVO{" +
                "page=" + page +
                ", limit=" + limit +
                ", groupId='" + groupId + '\'' +
                ", id=" + id +
                '}';
    }
}
