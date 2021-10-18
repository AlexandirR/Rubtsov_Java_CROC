package ThirdEx;

import java.util.Arrays;
import java.util.Scanner;

public class SwapInMass {

    private static Scanner scanner = new Scanner(System.in);
    private static String input;
    private static int[] mas;

    // Метод считывания массива
    public static void inputMass() {
        input = scanner.nextLine();
        mas = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray(); //парс строки в масив интов
    }

    // вывод массива
    public static void outputMass() {
        for (int temp: mas) {
            System.out.print(temp + " ");
        }
    }

    // Метод для поиска индексов максимального и минимальнго значения
    public static int findIndexOfMin() {
        int minI = 0;
        for(int i = 1; i < mas.length; ++i) {
            if(mas[i] < mas[minI]) {
                minI = i;
            }
        }
        return minI;
    }

    public static int findIndexOfMax() {
        int maxI = 0;
        for(int i = 1; i < mas.length; ++i) {
            if(mas[i] >= mas[maxI]) {
                maxI = i;
            }
        }
        return maxI;
    }

    // Метод для обмента двух элементов местами
    public static void swap(int indexFirst, int indexSecond) {
        int t = mas[indexFirst];
        mas[indexFirst] = mas[indexSecond];
        mas[indexSecond] = t;
    }

    // Основной метод
    public static void main(String[] args) {
        inputMass();
        //Нахождение индексов мин и макс и постановка их в начало и конеу массива соотвественно
        swap(0, findIndexOfMin());
        swap(mas.length - 1, findIndexOfMax());
        outputMass();
    }
}
