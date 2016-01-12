package by.pavel.bean;

public class KeywordBean {

    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeywordBean that = (KeywordBean) o;

        return !(keyword != null ? !keyword.equals(that.keyword) : that.keyword != null);

    }

    @Override
    public int hashCode() {
        return keyword != null ? keyword.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "KeywordBean{" +
                "keyword='" + keyword + '\'' +
                '}';
    }
}
