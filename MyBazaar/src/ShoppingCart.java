import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

   private List<Item> items;
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    public void removeItem(Item item) {
        if (item != null) {
            items.remove(item);
        }
    }

    public void emptyCart() {
        items.clear();
    }

    public double getTotalPriceBeforeDiscount() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

}
