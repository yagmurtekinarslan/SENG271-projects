import java.util.List;

public class Book extends OfficeSupplies{

    private String publisher;
    private List<String> authors;
    private int pageNumber;

    public Book(int itemID, double price, int stock,ItemType itemType, String releaseDate, String coverTitle, String publisher,
    List<String> authors, int pageNumber) {
        super(itemID, price, stock,ItemType.BOOK, releaseDate, coverTitle);

        this.publisher = publisher;
        this.authors = authors;
        this.pageNumber = pageNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    private String authorsToText() {
        if (authors == null || authors.isEmpty()) {
            return "";
        }

        String result = "";
        for (int i = 0; i < authors.size(); i++) {
            result += authors.get(i);
            if (i < authors.size() - 1) {
                result += ", ";
            }
        }
        return result;
    }

    public String toString() {
        return "Type: Book\n"
                + "Item ID: " + getItemID() + "\n"
                + "Price: " + getPrice() + " $\n"
                + "Release Date: " + getReleaseDate()+ "\n"
                + "Title: " + getCoverTitle()+ "\n"
                + "Publisher: " + getPublisher()+ "\n"
                + "Author: " + authorsToText() + "\n"
                + "Page: " + pageNumber + " pages";

    }

}
