package company;

public class Actor extends Staff {

    SexEnum sex;

    public Actor(String name, String lastName, double salary, SexEnum sex) {
        super(name, lastName, salary);
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Actor{" +
            "sex=" + sex +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", salary=" + salary +
            '}';
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }
}
