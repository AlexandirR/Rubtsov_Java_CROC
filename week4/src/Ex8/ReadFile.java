package Ex8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

    public static int countWords(String pathFile) throws FileNotFoundException {
        int count = 0;
        File file = new File(pathFile);
        try(Scanner sc = new Scanner(new FileInputStream(file))) {
            while (sc.hasNext()) {
                sc.next();
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String pathFile = args[0];
        try {
            System.out.println("In file " + countWords(pathFile) + " words");
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
