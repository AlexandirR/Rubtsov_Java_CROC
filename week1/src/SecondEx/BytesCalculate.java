package SecondEx;

import java.util.Scanner;

public class BytesCalculate {

    public static void main(String[] args) {
        double bytes;
        String [] names = new String [] {"B", "KB", "MB", "GB", "TB"};
        System.out.println("Write bytes:");
        Scanner scanner = new Scanner(System.in);
        bytes = scanner.nextDouble();
        int count = 0;
        while (bytes >= 1023.95) {
            bytes /= 1024;
            count += 1;
        }
        if(count < 5) {
            System.out.println(String.format("%.1f", bytes) + " " + names[count]);
        }
        else {
            System.out.println("O, It's so big, sorry...");
        }
    }
}
