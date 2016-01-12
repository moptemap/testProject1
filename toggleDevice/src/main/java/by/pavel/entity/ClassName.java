package by.pavel.entity;

public class ClassName {

    private int id;
    private String name;

    public ClassName() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassName className = (ClassName) o;

        return !(name != null ? !name.equals(className.name) : className.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ClassName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
