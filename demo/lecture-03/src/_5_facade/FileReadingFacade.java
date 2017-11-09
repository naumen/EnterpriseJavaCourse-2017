package _5_facade;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReadingFacade {

    // тут что-то что нужно для работы
    String encoding = "UTF-8";

    public FileReadingFacade(String encoding) {
        this.encoding = encoding;
    }

    public List<String> readFileForLines(String pathToFile){
        try {
            URI fileUri = getClass().getResource(pathToFile).toURI();

            File fileFromUri = new File(fileUri);

            Scanner input = new Scanner(fileFromUri);

            List<String> result = new ArrayList<>();
            while (input.hasNext()) {
                String nextLine = input.nextLine();
                result.add(nextLine);
            }

            input.close();

            return result;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
