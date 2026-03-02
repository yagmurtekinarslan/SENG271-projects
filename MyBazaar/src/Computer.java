public abstract class Computer extends Electronic{

    private String operatingSystem;
    private String CPUtype;
    private int ramCapacity;
    private int hddCapacity;

    public Computer(int itemID, double price, int stock,ItemType itemType, String manufacturer, String brand, int MaxVolt,
                    int MaxWatt,  String operatingSystem, String CPUtype,int ramCapacity, int hddCapacity ) {
        super(itemID, price, stock, itemType, manufacturer, brand, MaxVolt, MaxWatt);

        this.operatingSystem = operatingSystem;
        this.CPUtype = CPUtype;
        this.ramCapacity = ramCapacity;
        this.hddCapacity = hddCapacity;
    }

    public String getOperatingSystem(){
        return operatingSystem;
    }

    public String getCPUtype(){

        return CPUtype;
    }

    public int getRAMCapacity(){

        return ramCapacity;
    }

    public int getHDDCapacity(){

        return hddCapacity;
    }

    public String toString() {
        return "Type: Computer\n"
                + "Item ID: " + getItemID() + "\n"
                + "Price: " + getPrice() + " $\n"
                + "Manufacturer: " + getManufacturer() + "\n"
                + "Brand: " + getBrand()+ "\n"
                + "Max Volt: " + getMaxVolt()+ "\n"
                + "Max Watt: " + getMaxWatt()+ "\n"
                + "Operating System:" + getOperatingSystem()+ "\n"
                + "CPU Type:" + getCPUtype()+ "\n"
                + "RAM Capacity:" + getRAMCapacity()+ "\n"
                + "HDD Capacity:" + getHDDCapacity();
    }

}
