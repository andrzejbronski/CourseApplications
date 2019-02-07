package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import data.LibraryUser;
import utils.DataReader;
import data.Library;
import data.Book;
import utils.FileManager;
import data.Magazine;
import utils.LibraryUtils;

public class LibraryControl {

    private DataReader dataReader; //prywatna zmienna do komunikacji z użytkownikiem
    private FileManager fileManager; //prywatna zmienna do komunikacji z użytkownikiem


    private Library library;

    public LibraryControl() {
        dataReader = new DataReader();
        fileManager = new FileManager();
        try {
            library = fileManager.readLibraryFromFile();
            System.out.println("Wczytano dane biblioteki z pliku");
        } catch (IOException | ClassNotFoundException e) { // | and, &
            library = new Library();
            System.out.println("Utworzono nową bazę biblioteki");
        }
    }

    public void controlLoop() {
        Option option = null;
        while (option != Option.EXIT) {
            try {
                printOptions();
                option = Option.createFromInt(dataReader.getInt());
                switch (option) {
                    case ADD_BOOK:
                        addBook();
                        break;
                    case ADD_MAGAZINE:
                        addMagazine();
                        break;
                    case PRINT_BOOKS:
                        printBooks();
                        break;
                    case PRINT_MAGAZINES:
                        printMagazines();
                        break;
                    case ADD_USER:
                        addUser();
                        break;
                    case PRINT_USERS:
                        printUsers();
                        break;
                    case EXIT:
                        exit();
                        ;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Wprowadzono niepoprawne dane! Publikacji nie dodano!");
            } catch (NumberFormatException | NoSuchElementException ex) {
                System.out.println("Wybrana opcja nie istnieje! Wybierz ponownie");
            }

        }
        dataReader.close();//zamknięcie strumienia wejścia
    }

    private void printOptions() {

        System.out.println("Wybierz opcję: ");
        for (Option o : Option.values()) {
            System.out.println(o);
        }
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void printBooks() {
        LibraryUtils.printBooks(library);
    }

    private void printMagazines() {
        LibraryUtils.printMagazines(library);
    }

    private void addUser() {
        LibraryUser user = dataReader.readAndCreateLibraryUser();
        library.addUser(user);
    }

    private void printUsers() {
        LibraryUtils.printUsers(library);
    }

    private void exit() {
        fileManager.writeLibraryToFile(library);
    }

    private enum Option {
        EXIT(0, "Wyjście z programu"),
        ADD_BOOK(1, "Dodanie książki"),
        ADD_MAGAZINE(2, "Dodanie magazynu/gazety"),
        PRINT_BOOKS(3, "Wyświetlenie dostępnych książek"),
        PRINT_MAGAZINES(4, "Wyświetlenie dostepnych magazynów/gazet"),
        ADD_USER(5,"Dodanie nowego użytkownika"),
        PRINT_USERS(6,"Wyświetlenie listy użytkowników");

        private int value;
        private String description;

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }

        Option(int value, String desc) {
            this.value = value;
            this.description = desc;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        public static Option createFromInt(int option) throws NoSuchElementException {
            Option result = null;
            try {
                result = Option.values()[option];

            } catch (ArrayIndexOutOfBoundsException ex) {
                throw new NoSuchElementException("Brak elementu o wskazanym ID!");
            }
            return result;
        }

    }

}
