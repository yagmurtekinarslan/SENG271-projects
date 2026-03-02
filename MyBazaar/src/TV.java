public class TV extends Electronic{

    private int screenSize;

    public TV(int itemID, double price, int stock,ItemType itemType, String manufacturer, String brand, int MaxVolt,
              int MaxWatt, int screenSize) {
        super(itemID, price, stock, ItemType.TV,manufacturer, brand, MaxVolt, MaxWatt);

        this.screenSize=screenSize;
    }

    public int getScreenSize(){
        return screenSize;
    }

    public String toString() {
        return "Type: TV\n"
                + "Item ID: " + getItemID() + "\n"
                + "Price: " + getPrice() + " $\n"
                + "Manufacturer: " + getManufacturer() + "\n"
                + "Brand: " + getBrand()+ "\n"
                + "Max Volt: " + getMaxVolt()+ "\n"
                + "Max Watt: " + getMaxWatt()+ "\n"
                + "Screen size:" + getScreenSize();

    }

}
