public class Tablet extends Computer{

    private String dimension;

    public Tablet(int itemID, double price, int stock,ItemType itemType, String manufacturer, String brand, int MaxVolt,
                  int MaxWatt, String operatingSystem, String CPUtype,
                  int ramCapacity, int hddCapacity, String dimension){
        super(itemID, price, stock,ItemType.TABLET, manufacturer, brand, MaxVolt, MaxWatt, operatingSystem, CPUtype,
                ramCapacity, hddCapacity);

        this.dimension=dimension;
    }

    public String getDimension(){

        return dimension;
    }

    public String toString() {
        return "Type: Tablet\n"
                + "Item ID: " + getItemID() + "\n"
                + "Price: " + getPrice() + " $\n"
                + "Manufacturer: " + getManufacturer() + "\n"
                + "Brand: " + getBrand()+ "\n"
                + "Max Volt: " + getMaxVolt()+ "\n"
                + "Max Watt: " + getMaxWatt()+ "\n"
                + "Operating System:" + getOperatingSystem()+ "\n"
                + "CPU Type:" + getCPUtype()+ "\n"
                + "RAM Capacity:" + getRAMCapacity()+ "\n"
                + "HDD Capacity:" + getHDDCapacity()+ "\n"
                + "Dimension: " + getDimension();
    }

}
