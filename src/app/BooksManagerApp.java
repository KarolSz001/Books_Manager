package app;

public class BooksManagerApp {
    public static void main(String[] args) {
        final String appName = "BOOKS_MANAGER v0.4 K.Szot 20.03.2019";
        System.out.println(appName);
        BooksManagerControl libControl = new BooksManagerControl();
        libControl.controlLoop();
    }
}