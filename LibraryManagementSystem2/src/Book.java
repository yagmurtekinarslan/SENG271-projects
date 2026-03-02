public class Book extends Material implements Borrowable, Reservable{

    private String author;
    private boolean isBorrowed;
    private boolean isReserved;
    private String reservationHolder;

    public Book(String isbn, String title, String author, int publicationYear){
    super(isbn,title,publicationYear) ;

        this.author = author;
        this.isBorrowed = false;
        this.isReserved=false;

    }


    public String getAuthor() {
        return this.author;

    }

    public void setBorrowed(boolean isBorrowed){
       this.isBorrowed=isBorrowed;
    }

    public void setReserved(boolean isReserved){
        this.isReserved=isReserved;
    }

    //implement Borrowable
    public void borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Book " + title + "' borrowed successfully!");
        } else {
            System.out.println("Book " + title + "' is already borrowed!");
        }
    }

    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Book " + title + " returned successfully!");
        } else {
            System.out.println("Book " + title + " not borrowed!");
        }
    }

    public boolean isAvailableToBorrow(){
       return !isBorrowed;
    }

    public int getRemainingDays() {
        if (isBorrowed) {
            return 14;
        } else {
            return 0;
        }

    }

    //implemet Reservable
    public void reserve(String holder) {
        if (!isReserved) {
            this.isReserved = true;
            reservationHolder = holder;
            System.out.println("Book reserved successfully for " + reservationHolder + ".");

        } else {
            System.out.println("Book is already reserved by " + reservationHolder + ".");
        }
    }

    public  void cancelReservation() {
        if (isReserved) {
            this.isReserved = false;
            reservationHolder = "";
            System.out.println("Reservation canceled! ");
        } else {
            System.out.println("Book not reserved");
        }
    }

    public boolean isReserved() {
        return isReserved;
    }

    public String getReservationHolder(){
        return reservationHolder;
    }



    public String toString() {
        String status="";

        if(!isBorrowed){
           status+="Available";
        }
        else{
            status+="Borrowed";
        }
        if(isReserved()){
            status+=" Reserved by: " + getReservationHolder();
        }

        return "ISBN: " + this.isbn + "| Title: " + this.title + "| Author: " + this.author +
                "| Year: " + String.valueOf(this.publicationYear) + "| Status: " + status;

    }

    public String toFileFormat() {

        return "Book" + "," + this.isbn + "," + this.title + "," + this.author + "," + String.valueOf(this.publicationYear) + ","
                + String.valueOf(this.isBorrowed) + "," + String.valueOf(this.isReserved);

    }
}
