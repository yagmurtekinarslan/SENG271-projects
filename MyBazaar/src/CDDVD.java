import java.util.List;

public class CDDVD extends OfficeSupplies{

    private String composer;
    private List<String> songs;

    public CDDVD(int itemID, double price, int stock,ItemType itemType, String releaseDate, String coverTitle, String publisher,
                String composer, List<String> songs) {
        super(itemID, price, stock,ItemType.CDDVD, releaseDate, coverTitle);

        this.composer= composer;
        this.songs=songs;
    }

    public String getComposer(){

        return composer;
    }

    public List<String> getSongs(){

        return songs;
    }

    private String songsToText() {
        if (songs == null || songs.isEmpty()) {
            return "";
        }

        String result = "";
        for (int i = 0; i < songs.size(); i++) {
            result += songs.get(i);
            if (i < songs.size() - 1) {
                result += ", ";
            }
        }
        return result;
    }

    public String toString() {
        return "Type: CDDVD\n"
                + "Item ID: " + getItemID() + "\n"
                + "Price: " + getPrice() + " $\n"
                + "Release Date: " + getReleaseDate()+ "\n"
                + "Title: " + getCoverTitle()+ "\n"
                + "Composer: " + getComposer()+ "\n"
                + "Songs: " + songsToText();

    }

}
