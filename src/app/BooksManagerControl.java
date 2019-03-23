package app;

import data.Book;
import data.Library;
import data.LibraryUser;
import data.Magazine;
import exception.MyUncheckedException;
import parsers.LibraryJsonParser;
import utils.DataReader;
import utils.LibraryUtils;
import enums.Option;


public class BooksManagerControl {
    /**
     * variables to communication with user
     */

    private DataReader dataReader;
    private LibraryJsonParser libraryJsonParser;

    // main object to store books
    private Library library;

    public BooksManagerControl() {
        dataReader = new DataReader();
        libraryJsonParser = new LibraryJsonParser();
        try {
            library = libraryJsonParser.readLibraryFromJsonFile();
            System.out.println(" READ DATA FROM FILE ");
        } catch (Exception e) {
            library = new Library();
            System.out.println(" NEW LIBRARY CREATED ");
        }
    }

    /*
     * Main loop with control flow
     */
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
                        break;
                }
            } catch (MyUncheckedException e) {
                e.printStackTrace();
            }
        }
        // closing input
        dataReader.close();
    }

    private void printOptions() {
        System.out.println(" MAKE A CHOICE ");
        for (Option o : Option.values()) {
            System.out.println(o);
        }
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printBooks() {
        LibraryUtils.printBooks(library);
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        System.out.println(magazine);
        library.addMagazine(magazine);
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
        libraryJsonParser.saveLibraryToJsonFile(library);
    }


}