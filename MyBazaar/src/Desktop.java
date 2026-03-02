public class Desktop extends Computer{

    private String boxColor;

    public Desktop(int itemID, double price, int stock,ItemType itemType, String manufacturer, String brand, int MaxVolt,
                   int MaxWatt, String operatingSystem, String CPUtype,
                   int ramCapacity, int hddCapacity, String boxColor){
        super(itemID, price, stock,ItemType.DESKTOP, manufacturer, brand, MaxVolt, MaxWatt, operatingSystem, CPUtype,
        ramCapacity, hddCapacity);

        this.boxColor=boxColor;
    }

    public String getBoxColor() {

        return boxColor;
    }

    public String toString() {
        return "Type: Desktop\n"
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
                + "Box Color:" + getBoxColor();
    }

}
