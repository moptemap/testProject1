package by.pavel.entity;

public class Keyword {

    private int id;
    private String keyword;
    private int classNameId;

    public Keyword() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getClassNameId() {
        return classNameId;
    }

    public void setClassNameId(int classNameId) {
        this.classNameId = classNameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Keyword keyword1 = (Keyword) o;

        return !(keyword != null ? !keyword.equals(keyword1.keyword) : keyword1.keyword != null);

    }

    @Override
    public int hashCode() {
        return keyword != null ? keyword.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                ", classNameId=" + classNameId +
                '}';
    }
}
