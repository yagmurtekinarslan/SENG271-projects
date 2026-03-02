public class HairCare extends Cosmetic{

    private boolean isMedicated;

    public HairCare(int itemID, double price, int stock, ItemType itemType,String manufacturer, String brand,
                    boolean isOrganic, int expirationDate, double weight,boolean isMedicated){
        super(itemID, price, stock,ItemType.HAIRCARE, manufacturer, brand, isOrganic, expirationDate, weight);

        this.isMedicated=isMedicated;
    }

    public boolean isMedicated() {
        return isMedicated;
    }


    private String CheckMedicated() {
        if (isMedicated) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public String toString() {
        return "Type: HairCare\n"
                + "Item ID: " + getItemID() + "\n"
                + "Price: " + getPrice() + " $\n"
                + "Manufacturer: " + getManufacturer() + "\n"
                + "Brand: " + getBrand() + "\n"
                + "Organic: " + CheckOrganic() + "\n"
                + "Expiration Date: " + getExpirationDate() + "\n"
                + "Weight: " + getWeight() + "\n"
                + "Medicated: " + CheckMedicated();
    }

}
