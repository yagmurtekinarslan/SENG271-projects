public abstract class Electronic extends Item{

    private String manufacturer;
    private String brand;
    private int MaxVolt;
    private int MaxWatt;

    public Electronic(int itemID, double price, int stock,ItemType itemType, String manufacturer, String brand, int MaxVolt,
                      int MaxWatt){
        super(itemID, price, stock,itemType);

        this.manufacturer=manufacturer;
        this.brand=brand;
        this.MaxVolt=MaxVolt;
        this.MaxWatt=MaxWatt;
    }

    public String getManufacturer() {

        return manufacturer;
    }

    public String getBrand() {

        return brand;
    }

    public int getMaxVolt(){

        return MaxVolt;
    }

    public int getMaxWatt(){

        return MaxWatt;
    }

    public String toString() {
        return "Type: ELECTRONIC\n"
                + "Item ID: " + getItemID() + "\n"
                + "Price: " + getPrice() + " $\n"
                + "Manufacturer: " + getManufacturer() + "\n"
                + "Brand: " + getBrand()+ "\n"
                + "Max Volt: " + getMaxVolt()+ "\n"
                + "Max Watt: " + getMaxWatt();

    }

}
