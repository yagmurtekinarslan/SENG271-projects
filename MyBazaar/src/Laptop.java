public class Laptop extends Computer{

    private boolean hasHDMI;

    public Laptop(int itemID, double price, int stock,ItemType itemType, String manufacturer, String brand, int MaxVolt,
                  int MaxWatt,String operatingSystem, String CPUtype,
                  int ramCapacity, int hddCapacity, boolean hasHDMI){
        super(itemID, price, stock,ItemType.LAPTOP, manufacturer, brand, MaxVolt, MaxWatt, operatingSystem, CPUtype,
                ramCapacity, hddCapacity);

        this.hasHDMI= hasHDMI;
    }

    public boolean hasHDMI() {
        return hasHDMI;
    }

    private String CheckHDMI() {
        if (hasHDMI) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public String toString() {
        return "Type: Laptop\n"
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
                + "HDMI Support: " + CheckHDMI();
    }

}
