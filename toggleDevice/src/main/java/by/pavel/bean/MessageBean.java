package by.pavel.bean;

public class MessageBean {

    private String text;

    public MessageBean(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageBean that = (MessageBean) o;

        return !(text != null ? !text.equals(that.text) : that.text != null);

    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "text='" + text + '\'' +
                '}';
    }
}
