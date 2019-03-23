package utils;

import data.Book;
import data.LibraryUser;
import data.Magazine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner sc;

    public DataReader() {
        sc = new Scanner(System.in);
    }

    public void close() {
        sc.close();
    }

    public int getInt() throws NumberFormatException {
        int number = 0;
        try {
            number = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new NumberFormatException(" INCORRECT FORMAT NUMBER ");
        } finally {
            sc.nextLine();
        }
        return number;
    }

    public Book readAndCreateBook() throws InputMismatchException {
        System.out.println(" TITLE ");
        String title = sc.nextLine();
        System.out.println(" AUTHOR ");
        String author = sc.nextLine();
        System.out.println(" PUBLISHER ");
        String publisher = sc.nextLine();
        System.out.println(" ISBN: ");
        String isbn = sc.nextLine();
        System.out.println(" RELEASE DATA: ");
        int releaseDate = 0;
        int pages = 0;
        try {
            releaseDate = sc.nextInt();
            sc.nextLine();
            System.out.println(" NUMBER OF PAGES ");
            pages = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            sc.nextLine();
            throw e;
        }

        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() throws InputMismatchException {
        System.out.println("TITLE");
        String title = sc.nextLine();
        System.out.println("PUBLISHER");
        String publisher = sc.nextLine();
        System.out.println("LANGUAGE");
        String language = sc.nextLine();
        System.out.println("GIVE YEAR");
        int year = 0;
        int month = 0;
        int day = 0;
        try {
            year = sc.nextInt();
            sc.nextLine();
            System.out.println(" GIVE MONTH ");
            month = sc.nextInt();
            sc.nextLine();
            System.out.println(" GIVE DAY ");
            day = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            sc.nextLine();
            throw e;
        }
        return new Magazine(title, publisher, language, year, month, day);
    }

    public LibraryUser readAndCreateLibraryUser() {
        System.out.println("NAME :");
        String firstName = sc.nextLine();
        System.out.println("SURNAME :");
        String lastName = sc.nextLine();
        System.out.println("PESEL :");
        String pesel = sc.nextLine();

        return new LibraryUser(firstName, lastName, pesel);
    }
}