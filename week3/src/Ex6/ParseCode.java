package Ex6;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseCode {

    private static Scanner scanner = new Scanner(System.in);

    public static String parseCode (String code) {
        Pattern pattern = Pattern.compile("//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/");
        StringBuilder blurred = new StringBuilder();
        Matcher matcher = pattern.matcher(code);
        while (matcher.find()) {
            matcher.appendReplacement(blurred, "$1");
        }
        matcher.appendTail(blurred);
        return blurred.toString();
    }

    public static void main(String[] args) {
        //пример для проверки
        String code = """
/*
 * My first ever program in Java!
 */
class Hello { // class body starts here 
  
  /* main method */
  public static void main(String[] args/* we put command line arguments here*/) {
    // this line prints my first greeting to the screen
    System.out.println("Hi!"); // :)
  }
} // the end
// to be continued...
""";
        String answer = parseCode(code);
        System.out.println(answer);
    }
}
