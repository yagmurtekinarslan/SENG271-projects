public class DVD extends Material {

    private boolean isWatching;

    public DVD(String isbn,String title,int publicationYear){
        super(isbn,title,publicationYear);
        this.isWatching=false;
    }

    public void setIsWatching(boolean isWatching){
        this.isWatching=isWatching;
    }

    public void watch() {
        if (!isWatching) {
            System.out.println("Now watching: " + title);
            this.isWatching = true;
        } else {
            System.out.println("Already watching: " + title);

        }
    }

    public void stopWatching(){
        if(isWatching){
            System.out.println("Stop watching: " + title);
            this.isWatching=false;
        }
        else{
            System.out.println("Was not watched: "+ title);
            }
    }



    public String toString() {
        String status="";

        if(!isWatching){
            status="Available";
        }
        else{
            status="Currently Watching";
        }

        return "ISBN: " + this.isbn + "| Title: " + this.title +
                "| Year: " + String.valueOf(this.publicationYear) + "| Status: " + status;

    }

    public String toFileFormat() {

        return "DVD"+  "," + this.isbn + "," + this.title + "," + String.valueOf(this.publicationYear) + ","
                + String.valueOf(this.isWatching);

    }

}
