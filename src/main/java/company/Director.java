package company;

public class Director extends Staff{
    boolean hasOscar;

    public Director(String name, String lastName, double salary, boolean hasOscar) {
        super(name, lastName, salary);
        this.hasOscar = hasOscar;
    }

    @Override
    public String toString() {
        return "Director{" +
            "hasOscar=" + hasOscar +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", salary=" + salary +
            '}';
    }

    public boolean isHasOscar() {
        return hasOscar;
    }

    public void setHasOscar(boolean hasOscar) {
        this.hasOscar = hasOscar;
    }
}
