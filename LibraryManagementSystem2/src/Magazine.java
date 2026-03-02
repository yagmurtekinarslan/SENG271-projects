public class Magazine extends Material implements Borrowable{

    private boolean isBorrowed;

    public Magazine(String isbn, String title, int publicationYear){
        super(isbn,title,publicationYear);
        this.isBorrowed=false;
    }

    public void setBorrowed(boolean isBorrowed){
        this.isBorrowed=isBorrowed;
    }

    //implement Borrowable
    public void borrow(){
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Magazine " + title + "' borrowed successfully!");
        } else {
            System.out.println("Magazine " + title + "' is already borrowed!");
        }
    }

    public void returnItem(){
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Magazine " + title + " returned successfully!");
        } else {
            System.out.println("Magazine " + title + " not borrowed!");
        }
    }

    public boolean isAvailableToBorrow(){
        return !isBorrowed;
    }

    public int getRemainingDays() {
        if (isBorrowed) {
            return 7;
        } else {
            return 0;
        }

    }



    public String toString() {
        String status="";

        if(!isBorrowed){
            status+="Available";
        }
        else{
            status+="Borrowed";
        }

        return "ISBN: " + this.isbn + "| Title: " + this.title +
                "| Year: " + String.valueOf(this.publicationYear) + "| Status: " + status;

    }

    public String toFileFormat() {

        return "Magazine"+ "," +this.isbn + "," + this.title + "," + String.valueOf(this.publicationYear) + ","
                + String.valueOf(this.isBorrowed);

    }

}


