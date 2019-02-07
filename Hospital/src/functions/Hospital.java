package functions;

import data.Patient;

import java.util.Scanner;

public class Hospital {

    Scanner scan = new Scanner(System.in);

    public Patient createPatient() {
        System.out.println("Wprowadź imie pacjenta:");
        String firstName = scan.nextLine();
        System.out.println("Wprowadź nazwisko pacjenta:");
        String lastName = scan.nextLine();
        System.out.println("Wprowadź PESEL pacjenta:");
        int pesel = scan.nextInt();
        scan.nextLine();

        return new Patient(firstName, lastName, pesel);
    }


}
