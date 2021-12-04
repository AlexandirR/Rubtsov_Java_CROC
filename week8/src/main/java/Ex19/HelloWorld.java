package Ex19;

import java.io.FileWriter;
import java.io.IOException;

public class HelloWorld {

    public static void main(String[] args) {

        try(FileWriter writer = new FileWriter("very_hard_ex.txt", false))
        {
            writer.write("Hello, World!");
            writer.flush();
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
