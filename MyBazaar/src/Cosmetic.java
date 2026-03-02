public abstract class Cosmetic extends Item{

    private String manufacturer;
    private String brand;
    private boolean isOrganic;
    private int expirationDate;
    private double weight;

    public Cosmetic(int itemID, double price, int stock,ItemType itemType, String manufacturer, String brand,
                    boolean isOrganic, int expirationDate, double weight) {
        super(itemID, price, stock ,itemType);

        this.manufacturer = manufacturer;
        this.brand = brand;
        this.isOrganic = isOrganic;
        this.expirationDate = expirationDate;
        this.weight = weight;

    }

    protected String CheckOrganic() {
        if (isOrganic) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isOrganic() {
        return isOrganic;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "Type: COSMETIC\n"
                + "Item ID: " + getItemID() + "\n"
                + "Price: " + getPrice() + " $\n"
                + "Manufacturer: " + getManufacturer() + "\n"
                + "Brand: " + getBrand()+ "\n"
                + "Organic: " + CheckOrganic() + "\n"
                + "Expiration Date: " + getExpirationDate() + "\n"
                + "Weight: " + getWeight() +" g.";
    }
}
