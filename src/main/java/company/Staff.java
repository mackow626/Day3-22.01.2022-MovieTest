package company;

public class Staff {
    String name;
    String lastName;
    double salary;

    public Staff(String name, String lastName, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Staff{" +
            "name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", salary=" + salary +
            '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
