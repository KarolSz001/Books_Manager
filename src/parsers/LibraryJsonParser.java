package parsers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.Library;
import exception.MyUncheckedException;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class LibraryJsonParser {

    private static final String JSONFILE_NAME = "Library.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public void saveLibraryToJsonFile(Library library) {
        try {
            FileWriter writer = new FileWriter(JSONFILE_NAME);
            gson.toJson(library, writer);
            writer.close();
        } catch (Exception e) {
            throw new MyUncheckedException("TO JSON EXCEPTION");
        }
    }

    public Library readLibraryFromJsonFile()  {
        Library library;
        try (FileReader reader = new FileReader(JSONFILE_NAME)) {
            library = gson.fromJson(reader, Library.class);
        } catch (IOException e) {
            throw new MyUncheckedException("FROM JSON - JSON FILENAME EXCEPTION");
        }
        return library;
    }
}
