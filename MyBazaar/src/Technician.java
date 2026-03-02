public class Technician extends Employee {

    private boolean isSenior;

    public Technician(String name, String email, String birthDate, double salary,
                      boolean isSenior) {
        super(name, email, birthDate, salary);
        this.isSenior = isSenior;
    }

    public boolean isSenior() {
        return isSenior;
    }

    public void setSenior(boolean senior) {
        isSenior = senior;
    }

}
