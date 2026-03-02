public class SmartPhone extends Electronic{

    private String  screenType;

    public SmartPhone(int itemID, double price, int stock,ItemType itemType, String manufacturer, String brand, int MaxVolt,
                      int MaxWatt, String screenType) {
        super(itemID, price, stock,ItemType.SMARTPHONE, manufacturer, brand, MaxVolt, MaxWatt);

        this.screenType = screenType;
    }

    public String getScreenType(){

        return screenType;
    }

    public String toString() {
        return "Type: SmartPhone\n"
                + "Item ID: " + getItemID() + "\n"
                + "Price: " + getPrice() + " $\n"
                + "Manufacturer: " + getManufacturer() + "\n"
                + "Brand: " + getBrand()+ "\n"
                + "Max Volt: " + getMaxVolt()+ "\n"
                + "Max Watt: " + getMaxWatt()+ "\n"
                + "Screen type:" + getScreenType();

    }

}
