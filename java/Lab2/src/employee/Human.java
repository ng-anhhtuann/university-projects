package employee;
public class Human {
    private String name;
    private int id;
    private String sex;
    private String nation;

    // Constructors
    public Human(String name, int id, String sex, String nation) {
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.nation = nation;
    }

    public Human() {
        // No-args constructor
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String isSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", sex=" + sex +
                ", nation='" + nation + '\'' +
                '}';
    }
}
