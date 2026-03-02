import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Library library = new Library();

        Scanner scan= new Scanner(System.in);

        System.out.println("Please enter your selection: \n 1 to add a book,\n 2 to add magazine,\n 3 to add DVD,\n 4 to list all materials,\n" +
                " 5 to list by type,\n 6 to borrow materials,\n 7 to return materials,\n 8 to reserve materials,\n" + " 9 to cancel reservation,\n" +
                " 10 watch a DVD,\n 11 to stop watching a DVD,\n 0 to exit.\n Your selection: ");
        int selection= scan.nextInt();
        scan.nextLine();

        while(selection!=0){

            switch (selection) {
                case 1: {
                    System.out.print("Enter ISBN: ");

                    String isbn = scan.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scan.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scan.nextLine();
                    System.out.print("Enter Year: ");
                    int publicationYear = scan.nextInt();
                    scan.nextLine();

                    Book b1 = new Book(isbn, title, author, publicationYear);
                    library.addBook(b1);
                    break;
                }

                case 2: {
                    System.out.print("Enter ISBN: ");
                    String isbn = scan.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scan.nextLine();
                    System.out.print("Enter Year: ");
                    int publicationYear = scan.nextInt();
                    scan.nextLine();

                    Magazine m1 = new Magazine(isbn, title, publicationYear);
                    library.addMagazine(m1);
                    break;
                }

                case 3: {
                    System.out.print("Enter ISBN: ");
                    String isbn = scan.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scan.nextLine();
                    System.out.print("Enter Year: ");
                    int publicationYear = scan.nextInt();
                    scan.nextLine();

                    DVD d1 = new DVD(isbn, title, publicationYear);
                    library.addDVD(d1);
                    break;
                }

                case 4: {
                    library.listAllMaterials();
                    break;
                }

                case 5: {
                    System.out.println("Please enter the type of product you would like to list: Book, Magazine, or DVD.");
                    String type = scan.nextLine();
                    library.listByType(type);
                    break;
                }

                case 6: {
                    System.out.println("Please enter ISBN: ");
                    String isbn = scan.nextLine();
                    library.borrowMaterial(isbn);
                    break;
                }

                case 7: {
                    System.out.println("Please enter ISBN: ");
                    String isbn = scan.nextLine();
                    library.returnMaterial(isbn);
                    break;
                }

                case 8: {
                    System.out.print("Please enter ISBN: ");
                    String isbn = scan.nextLine();

                    boolean found = false;

                    for (Material material : library.getMaterials()) {
                        if (material.getIsbn().equals(isbn)) {
                            found = true;

                            if (material instanceof Reservable) {
                                System.out.print("Please enter the reservation holder's name: ");
                                String name = scan.nextLine();
                                library.reserveMaterial(isbn, name);
                            } else {
                                System.out.println("This material type cannot be reserved.");
                            }

                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Material not found.");
                    }

                    break;
                }

                case 9:{
                    System.out.println("Please enter ISBN: ");
                    String isbn = scan.nextLine();
                    library.cancelReservation(isbn);
                    break;
                }

                case 10:{
                    System.out.println("Please enter DVD ISBN: ");
                    String isbn= scan.nextLine();
                    library.watchDVD(isbn);
                    break;

                }

                case 11:{
                    System.out.println("Please enter DVD ISBN: ");
                    String isbn= scan.nextLine();
                    library.stopWatchingDVD(isbn);
                    break;

                }
            }

            System.out.println("Please enter your selection: \n 1 to add a book,\n 2 to add magazine,\n 3 to add DVD,\n 4 to list all materials,\n" +
                    " 5 to list by type,\n 6 to borrow materials,\n 7 to return materials,\n 8 to reserve materials,\n" + " 9 to cancel reservation,\n" +
                    " 10 watch a DVD,\n 11 to stop watching a DVD,\n 0 to exit.\n Your selection: ");
            selection = scan.nextInt();
            scan.nextLine();

        }

        scan.close();
    }

}
