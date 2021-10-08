package ThirdEx;

import java.util.Arrays;
import java.util.Scanner;

public class SwapInMass {

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        int[] mas = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxI = 0, minI = 0;
        for(int i = 0; i < mas.length; ++i) {
            if(mas[i] > mas[maxI]) {
                maxI = i;
            }
            if(mas[i] < mas[minI]) {
                minI = i;
            }
        }
        int t = mas[0];
        mas[0] = mas[minI];
        mas[minI] = t;
        t = mas[mas.length - 1];
        mas[mas.length - 1] = mas[maxI];
        mas[maxI] = t;
        for (int temp: mas) {
            System.out.print(temp + " ");
        }
    }
}
