import java.util.ArrayList;
import java.util.List;

public class Customer extends Person{

    private int customerID;
    private String password;
    private double balance;
    private CustomerStatus status;
    private ShoppingCart shoppingCart;
    private List<Order> orderHistory;

    public static final double SILVER_LIMIT = 1000;
    public static final double GOLDEN_LIMIT = 5000;

    public static final double SILVER_DISCOUNT = 0.10;
    public static final double GOLDEN_DISCOUNT = 0.15;

    private double totalSpent;

    public Customer(int customerID, String name, String email, String birthDate, double balance,
                    String password) {
        super(name, email, birthDate);

        this.customerID = customerID;
        this.password = password;
        this.balance = balance;
        this.status = CustomerStatus.CLASSIC;
        this.shoppingCart = new ShoppingCart();
        this.orderHistory = new ArrayList<>();
        this.totalSpent = 0.0;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void changePassword(String oldPwd, String newPwd) {
        if (this.password != null && this.password.equals(oldPwd)) {
            this.password = newPwd;
        }

    }

    public void depositMoney(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void viewCampaigns() {}

    public void addToCart(Item item) {
        shoppingCart.addItem(item);
    }

    public void emptyCart() {
        shoppingCart.emptyCart();
    }

    public void placeOrder(String password) {}

    public void updateStatusAfterOrder(double totalSpent) {
        this.totalSpent = totalSpent;

        if (totalSpent >= GOLDEN_LIMIT) {
            status = CustomerStatus.GOLDEN;
        } else if (totalSpent >= SILVER_LIMIT) {
            status = CustomerStatus.SILVER;
        } else {
            status = CustomerStatus.CLASSIC;
        }
    }

    public String toString() {
        return "Customer name: " + getName()
                + " ID: " + customerID
                + " e-mail: " + getEmail()
                + " Date of Birth: " + getBirthDate()
                + " Status: " + status;
    }


}
