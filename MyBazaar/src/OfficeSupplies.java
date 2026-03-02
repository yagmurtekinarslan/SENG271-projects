public abstract class OfficeSupplies extends Item{

    private String releaseDate;
    private String coverTitle;

    public OfficeSupplies(int itemID, double price, int stock,ItemType itemType, String releaseDate, String coverTitle){
        super(itemID, price, stock, itemType);

        this.releaseDate= releaseDate;
        this.coverTitle= coverTitle;
    }

    public String getReleaseDate(){
        return releaseDate;
    }

    public String getCoverTitle(){
        return coverTitle;
    }

    public String toString() {
        return "Type: OFFICE SUPPLIES\n"
                + "Item ID: " + getItemID() + "\n"
                + "Price: " + getPrice() + " $\n"
                + "Release Date: " + getReleaseDate()+ "\n"
                + "Title: " + getCoverTitle();

    }

}
