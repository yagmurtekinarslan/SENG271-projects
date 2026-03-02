public abstract class Employee extends Person{

    private double salary;

    public Employee(String name, String email, String birthDate, double salary) {
        super(name, email, birthDate);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

}

