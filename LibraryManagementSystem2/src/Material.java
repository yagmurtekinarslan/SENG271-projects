public abstract class Material {

protected String isbn;
protected String title;
protected int publicationYear;

public Material(String isbn,String title, int publicationYear){
    this.isbn=isbn;
    this.title=title;
    this.publicationYear=publicationYear;

}
    public String getIsbn() {
        return this.isbn;

    }

    public String getTitle() {
        return this.title;

    }

    public int getPublicationYear() {
        return this.publicationYear;

    }
    public abstract String toFileFormat();
    public abstract String toString();

}
