public abstract class Item {

    private int itemID;
    private double price;
    private int stock;
    protected ItemType itemType;

    public Item(int itemID, double price, int stock,ItemType itemType){
        this.itemID=itemID;
        this.price=price;
        this.stock=stock;
        this.itemType = itemType;

    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getItemID() {
        return itemID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public abstract String toString();

}
