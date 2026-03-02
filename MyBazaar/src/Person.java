public class Person {

   private String name;
   private String email;
   private String birthDate;

   public Person(String name, String email, String birthDate){
       this.name=name;
       this.email=email;
       this.birthDate=birthDate;
   }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void displayPersonalData() {
        System.out.println("Name: " + name);
        System.out.println("E-mail: " + email);
        System.out.println("Date of Birth: " + birthDate);
    }
}
