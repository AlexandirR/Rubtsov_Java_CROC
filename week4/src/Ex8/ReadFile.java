package Ex8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ReadFile {

    //Слово - любой символьный блок имеющий хоть одну букву или цифру отделенный пробелами или переводами строк
    public static int countWords(String pathFile) throws FileNotFoundException {
        int count = 0;
        File file = new File(pathFile);
        String temp;
        boolean flag;
        try(Scanner sc = new Scanner(new FileInputStream(file))) {
            while (sc.hasNext()) {
                temp = sc.next();
                flag = false;
                for(int i = 0; i < temp.length(); ++i) {
                    char c = temp.charAt(i);
                    if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
                            (c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я') ||
                            (c >= '0' && c <= '9')) {
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    count++;
                }
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
