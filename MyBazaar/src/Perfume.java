public class Perfume extends Cosmetic{

    private int lastDuration;

    public Perfume(int itemID, double price, int stock,ItemType itemType,String manufacturer, String brand,
                   boolean isOrganic, int expirationDate, double weight, int lastDuration) {
        super(itemID, price, stock,ItemType.PERFUME, manufacturer, brand, isOrganic, expirationDate, weight);

        this.lastDuration = lastDuration;
    }

    public int getLastDuration() {
        return lastDuration;
    }

    public String toString() {
        return "Type: Perfume\n"
                + "Item ID: " + getItemID() + "\n"
                + "Price: " + getPrice() + " $\n"
                + "Manufacturer: " + getManufacturer() + "\n"
                + "Brand: " + getBrand() + "\n"
                + "Organic: " + CheckOrganic() + "\n"
                + "Expiration Date: " + getExpirationDate() + "\n"
                + "Weight: " + getWeight() + "\n"
                + "Last Duration: " + getLastDuration();
    }
}
