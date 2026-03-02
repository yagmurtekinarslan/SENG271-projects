public class Admin extends Employee {

    private String password;

    public Admin(String name, String email, String birthDate, double salary,
                 String password) {
        super(name, email, birthDate, salary);

        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void displayPersonalData() {
        System.out.println("----------- Admin info -----------");
        System.out.println("Admin name: " + getName());
        System.out.println("Admin e-mail: " + getEmail());
        System.out.println("Admin date of birth: " + getBirthDate());
    }
}
