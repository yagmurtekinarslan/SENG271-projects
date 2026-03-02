import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Date orderDate;
    private int customerID;
    private List<Item> items;
    private double totalCost;


    public Order(Date orderDate, int customerID, List<Item> items, double totalCost) {
        this.orderDate = orderDate;

        this.customerID = customerID;
        if (items == null) {
            this.items = new ArrayList<>();
        } else {
            this.items = items;
        }

        this.totalCost = totalCost;
    }

    public Date getOrderDate() {

        return orderDate;
    }

    public int getCustomerID() {

        return customerID;
    }

    public List<Item> getItems() {

        return items;
    }

    public double getTotalCost() {

        return totalCost;
    }


    public int getNumberOfPurchasedItems() {

        return items.size();
    }

    public String toString() {
        return "Order date: " + orderDate.toString()
                + " Customer ID: " + getCustomerID()
                + " Total Cost: " + getTotalCost()
                + " Number of purchased items: " + getNumberOfPurchasedItems();
    }
}


