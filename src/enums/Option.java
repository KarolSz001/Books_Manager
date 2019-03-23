package enums;

import app.BooksManagerControl;
import exception.MyUncheckedException;

public enum Option {

    EXIT(0, "EXIT PROGRAM"),
    ADD_BOOK(1, "ADD BOOK"),
    ADD_MAGAZINE(2, "ADD MAGAZINE/NEWSPAPER"),
    PRINT_BOOKS(3, "PRINT BOOKS"),
    PRINT_MAGAZINES(4, "PRINT MAGAZINE/NEWSPAPER"),
    ADD_USER(5, "ADD NEW USER"),
    PRINT_USERS(6, "PRINT ALL USERS");

    private int value;
    private String description;

    Option(int value, String desc) {
        this.value = value;
        this.description = desc;

    }
    @Override
    public String toString() {
        return value + " - " + description;
    }

    public static Option createFromInt(int option) {
        Option result;
        try {
            result = Option.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MyUncheckedException("WRONG DATA ID");
        }

        return result;
    }
}
