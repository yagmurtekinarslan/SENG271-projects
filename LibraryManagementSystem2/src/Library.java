import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Library {

    private ArrayList<Material> materials;
    private static final String FILE_NAME = "library.txt";


    public Library() {

        materials = new ArrayList<>();
        loadFromFile();

    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return; //Not throw error if file doesn't exist

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                      String type=arr[0].trim();
                          switch (type){
                              case "Book":{
                                  Book book = new Book(arr[1].trim(),arr[2].trim(),arr[3].trim(), Integer.parseInt(arr[4].trim()));
                                  book.setBorrowed(Boolean.parseBoolean(arr[5]));
                                  book.setReserved(Boolean.parseBoolean(arr[6]));
                                  materials.add(book);
                                  break;
                              }

                              case "Magazine":{
                                  Magazine magazine=new Magazine(arr[1].trim(),arr[2].trim(), Integer.parseInt(arr[3].trim()));
                                  magazine.setBorrowed(Boolean.parseBoolean(arr[4]));
                                  materials.add(magazine);
                                  break;
                              }

                              case "DVD":{
                                  DVD dvd=new DVD(arr[1].trim(),arr[2].trim(), Integer.parseInt(arr[3].trim()));
                                  dvd.setIsWatching(Boolean.parseBoolean(arr[4]));
                                  materials.add(dvd);
                                  break;
                              }
                          }

                }

        }
        catch (IOException e) {
            System.out.println("An error occurred while writing to the file" + e.getMessage());
        }
    }



    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Material material: materials) {
                bw.write(material.toFileFormat());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file" + e.getMessage());
        }
    }


    public void addBook(Book newBook) {
        materials.add(newBook);  //add book to the list
        System.out.println("Book is successfully saved: " + newBook.toString());
        saveToFile();
    }

    public void addMagazine(Magazine newMagazine) {
        materials.add(newMagazine); //add magazine to the list
        System.out.println("Magazine is successfully saved: " + newMagazine.toString());
        saveToFile();
    }

    public void addDVD(DVD newDVD) {
        materials.add(newDVD);   //add DVD to the list
        System.out.println("DVD is successfully saved: " + newDVD.toString());
        saveToFile();
    }

    public void listAllMaterials() {
        if (materials.isEmpty()) {
            System.out.println("There are no materials."); //If it is empty display the message
        } else {
            for (Material material:materials) {

                System.out.println(material); //Print all materials
            }
        }
    }

    public void listByType(String type) {
        for (Material material : materials) {
            switch (type) {
                case "Book":
                    if (material instanceof Book) System.out.println(material);
                    break;
                case "Magazine":
                    if (material instanceof Magazine) System.out.println(material);
                    break;
                case "DVD":
                    if (material instanceof DVD) System.out.println(material);
                    break;
            }
        }
    }

    public void borrowMaterial(String isbn) {
        for (Material material : materials) {
            if (material instanceof Borrowable && material.getIsbn().equals(isbn)) {

                Borrowable m = (Borrowable) material;

                if (m.isAvailableToBorrow()) {
                    m.borrow();
                    System.out.println("You must return this item within " + m.getRemainingDays() + " days.");
                    saveToFile();
                } else {
                  m.borrow();
                }
                return;
            }
        }
        System.out.println("Material not found or not borrowable.");
    }

    public void returnMaterial(String isbn) {
        for (Material material : materials) {
            if (material instanceof Borrowable && material.getIsbn().equals(isbn)) {

               Borrowable m= (Borrowable) material;

               if(!m.isAvailableToBorrow()){
                   m.returnItem();
                   saveToFile();
               } else {
                   m.returnItem();
               }
               return;
            }

        }
        System.out.println("Material not found or cannot be returned.");
    }

    public void reserveMaterial(String isbn,String holder) {
        for (Material material : materials) {
            if (material instanceof Reservable && material.getIsbn().equals(isbn)) {
                ((Reservable) material).reserve(holder);
                saveToFile();
                return;
            }
        }

    }

    public void cancelReservation(String isbn) {
        for (Material material : materials) {
            if (material instanceof Reservable && material.getIsbn().equals(isbn)) {
                ((Reservable) material).cancelReservation();
                saveToFile();
                return;
            }
        }
        System.out.println("Material not found or not reservable.");
    }


    public void watchDVD(String isbn){
        for (Material material:materials){
            if(material instanceof DVD && material.getIsbn().equals(isbn)){
                ((DVD) material).watch();
                saveToFile();
                return;
            }
        }
        System.out.println("DVD not found!");
    }

    public void stopWatchingDVD(String isbn){
        for (Material material:materials){
            if(material instanceof DVD && material.getIsbn().equals(isbn)){
                ((DVD) material).stopWatching();
                saveToFile();
                return;
            }
        }
        System.out.println("DVD not found!");
    }


}
