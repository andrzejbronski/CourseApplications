package app;

import data.Patient;
import functions.Hospital;

import java.util.Scanner;

public class HospitalApp {
    public static void main(String[] args) {

        Scanner skan = new Scanner(System.in);
        Hospital hospital = new Hospital();

        Patient[] patientsDataBase = new Patient[10];
        int index = 0;
        System.out.println("+++++++++++++++++++");
        System.out.println("+ Program Szpital +");
        System.out.println("+++++++++++++++++++");

        int option;
        System.out.println("Wybierz opcje: \n 0 - Wyjście z programu\n 1 - Tworzenie nowego pacjenta\n 2 - Wyświetlenie listy pacjentów");

        while ((option = skan.nextInt()) != 0) {

            switch (option) {

                case 0:
                    System.out.println("Wyjście z programu!");
                    System.exit(0);
                    break;

                case 1:
                    System.out.println("Dodawanie nowego pacjenta");
                    if (index < 10) {
                        patientsDataBase[index] = hospital.createPatient();
                        index++;
                    } else {
                        System.out.println("Przekroczona liczba zarejestrowanych pacjentów!");
                    }
                    break;

                case 2:
                    System.out.println("Lista pacjentów zawiera " + index + " osoby.\n"); //odwoływanie sie do najwyższego indeksu tablicy zwraca wartość równą ilości dodanych pacjentów, odwołanie sie do tab.lenght zwróci rozmiar tablicy a nie dodanych pacjentów!

                    //    for (Patient p : patientsDataBase) { //wyświetla poprawnie ale "null pointer" ponieważ iteruje po całej tablicy, nawet po pustych polach
                    //        System.out.println("Imie pacjenta: " + p.getFirstName() + "\nNazwisko pacjenta: " + p.getLastName() + "\nPesel pacjenta:" + p.getPesel());
                    //  }
                    int a = 0;

                    for (int i = 0; i < index; i++) {

                        Patient p = patientsDataBase[a];
                        System.out.println("Imie pacjenta: " + p.getFirstName() + "\nNazwisko pacjenta: " + p.getLastName() + "\nPesel pacjenta:" + p.getPesel());
                        System.out.println("++++++++++++++++++++++++++++++");
                        a++;
                    }
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("Błędznie zdefiniowana opcja!");
            }
            System.out.println("Wybierz opcje: \n 0 - Wyjście z programu\n 1 - Tworzenie nowego pacjenta\n 2 - Wyświetlenie listy pacjentów");

        }

        System.out.println("Koniec progrmu");

        skan.close();

    }
}
