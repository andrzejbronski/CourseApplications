package utils;

import data.Library;

import java.io.*;

public class FileManager {
    public static final String FILE_NAME = "Library.o";

    public void writeLibraryToFile(Library lib){
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                ){
            objectOutputStream.writeObject(lib);//zapis obiektu do pliku w postaci binarnej

        } catch (FileNotFoundException e) {
           System.err.println("Nie znaleziono pliku: "+FILE_NAME);
        } catch (IOException e) {
           System.err.println("Błąd zapisu danych do pliku "+FILE_NAME);
        }

    }
    public Library readLibraryFromFile() throws ClassNotFoundException, FileNotFoundException, IOException {
        Library library = null;
        try(
            FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                ){
            library = (Library)objectInputStream.readObject();

        } catch (FileNotFoundException e) {
          System.err.println("Nie znaleziono pliku "+FILE_NAME);
          throw e;
        } catch (IOException e) {
            System.err.println("Błąd zapisu do pliku "+FILE_NAME);
            throw e;
        } catch (ClassNotFoundException e){
            System.err.println("Nieprawidłowy format pliku!");
            throw e;
        }

        return library;
    }
}
