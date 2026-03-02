public class Main {
    public static void main(String[] args) {


        MyBazaar bazaar = new MyBazaar();

        bazaar.loadUsers("users.txt");

        bazaar.loadItems("item.txt");

        bazaar.processCommands("commands.txt");
    }

}
