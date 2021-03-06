package utils;

import data.*;

import java.util.*;

public class LibraryUtils {

    public static void printBooks(Library library) {
    printPublications(library, Book.class);
    }

    public static void printMagazines(Library library) {
        printPublications(library,Magazine.class);

    }
    private static void printPublications(Library lib, Class cl){
        long countPublications = lib.getPublications().values().stream()
                .filter(cl::isInstance).sorted(new Library.AlphabeticalComparator())
                .peek(System.out::println).count();
        if (countPublications == 0){
            System.out.println("W bibliotece nie znaleziono publikacji typu: "+cl.getSimpleName());
        }
    }
    public static void printUsers(Library lib){
       lib.getUsers().values().stream().sorted((a,b)->a.getLastName().compareTo(b.getLastName()))
               .forEach(System.out::println);
    }
}
