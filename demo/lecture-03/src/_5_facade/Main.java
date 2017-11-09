package _5_facade;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // нужно прочитать строки файла
        String encoding = "UTF-8";

        try {
            String filePath = args[0];

            URI fileUri = ClassLoader.getSystemClassLoader().getResource(filePath).toURI();

            File fileFromUri = new File(fileUri);

            Scanner input = new Scanner(fileFromUri, encoding);

            List<String> result = new ArrayList<>();
            while (input.hasNext()) {
                String nextLine = input.nextLine();
                result.add(nextLine);
            }

            input.close();
        } catch (Exception e){
            // ...
        }

        FileReadingFacade fileReadingFacade = new FileReadingFacade(encoding);

        fileReadingFacade.readFileForLines(args[0]);
        fileReadingFacade.readFileForLines(args[2]);
        fileReadingFacade.readFileForLines(args[4]);
    }
}
