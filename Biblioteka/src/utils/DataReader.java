package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import data.Book;
import data.LibraryUser;
import data.Magazine;

public class DataReader {



    private Scanner scan;

    public DataReader() {
        scan = new Scanner(System.in);
    }

    public void close() {
        scan.close();
    }
    public int getInt() throws NumberFormatException{
        int number = 0;
        try {
            number = scan.nextInt();
        }catch (InputMismatchException ex){
            throw new NumberFormatException("Liczba wprowadzona w niepoprawnej formie!");
        }finally {
            scan.nextLine();
        }

        return number;
    }

    public Book readAndCreateBook() {
        System.out.println("Podaj tytuł:");
        String title = scan.nextLine();
        System.out.println("Podaj autora:");
        String author = scan.nextLine();
        System.out.println("Podaj wydawnictwo:");
        String publisher = scan.nextLine();
        System.out.println("Podaj numer ISBN:");
        String isbn = scan.nextLine();
        System.out.println("Podaj rok wydania:");
        int releaseDate = 0;
        int pages = 0;
        try {
            releaseDate = scan.nextInt();
            scan.nextLine();
            System.out.println("Podaj ilość stron:");
            pages = scan.nextInt();
            scan.nextLine();
        }catch (InputMismatchException ex){
            scan.nextLine();
            throw ex;
        }

        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }
    public Magazine readAndCreateMagazine(){
        System.out.println("Podaj tytuł: ");
        String title = scan.nextLine();
        System.out.println("Podaj wydawnictwo: ");
        String publisher = scan.nextLine();
        System.out.println("Podaj język: ");
        String language = scan.nextLine();
        System.out.println("Podaj rok wydania: ");

        int releaseYear = 0;
        int releaseMonth = 0;
        int releaseDay = 0;
        try {
            releaseYear = scan.nextInt();
            scan.nextLine();
            System.out.println("Podaj miesiąc wydania: ");
            releaseMonth = scan.nextInt();
            scan.nextLine();
            System.out.println("Podaj dzień wydania: ");
            releaseDay = scan.nextInt();
            scan.nextLine();
        }catch (InputMismatchException ex){
            scan.nextLine();
            throw ex;
        }

        return new Magazine(title,publisher,releaseYear,releaseMonth,releaseDay,language);
    }
    public LibraryUser readAndCreateLibraryUser(){
        System.out.println("Imię: ");
        String firstName = scan.nextLine();
        System.out.println("Nazwisko: ");
        String lastName = scan.nextLine();
        System.out.println("PESEL: ");
        String pesel = scan.nextLine();
        return new LibraryUser(firstName,lastName,pesel);
    }
}
