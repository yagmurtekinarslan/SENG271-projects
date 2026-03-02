public class SkinCare extends Cosmetic{

    private boolean isBabySensitive;

    public SkinCare(int itemID, double price, int stock,ItemType itemType, String manufacturer, String brand,
                     boolean isOrganic, int expirationDate, double weight, boolean isBabySensitive){
        super(itemID, price, stock,ItemType.SKINCARE, manufacturer, brand, isOrganic, expirationDate, weight);

        this.isBabySensitive=isBabySensitive;
    }

    public boolean isBabySensitive() {
        return isBabySensitive;
    }

    private String CheckBabySensitive() {
        if (isBabySensitive) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public String toString() {
        return "Type: SkinCare\n"
                + "Item ID: " + getItemID() + "\n"
                + "Price: " + getPrice() + " $\n"
                + "Manufacturer: " + getManufacturer() + "\n"
                + "Brand: " + getBrand() + "\n"
                + "Organic: " + CheckOrganic() + "\n"
                + "Expiration Date: " + getExpirationDate() + "\n"
                + "Weight: " + getWeight() + "\n"
                + "Baby Sensitive: " + CheckBabySensitive();
    }

}
