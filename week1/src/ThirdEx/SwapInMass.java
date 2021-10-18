package ThirdEx;

import java.util.Arrays;
import java.util.Scanner;

public class SwapInMass {

    // Метод считывания массива
    public static int[] inputMass() {
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray(); //парс строки в масив интов
    }

    // вывод массива
    public static void outputMass(int[] mas) {
        for (int temp: mas) {
            System.out.print(temp + " ");
        }
    }

    // Метод для поиска индексов максимального и минимальнго значения
    public static int findIndexOfMin(int[] mas) {
        int minI = 0;
        for(int i = 1; i < mas.length; ++i) {
            if(mas[i] < mas[minI]) {
                minI = i;
            }
        }
        return minI;
    }

    public static int findIndexOfMax(int[] mas) {
        int maxI = 0;
        for(int i = 1; i < mas.length; ++i) {
            if(mas[i] >= mas[maxI]) {
                maxI = i;
            }
        }
        return maxI;
    }

    // Метод для обмента двух элементов местами
    public static void swap(int[] mas, int indexFirst, int indexSecond) {
        int t = mas[indexFirst];
        mas[indexFirst] = mas[indexSecond];
        mas[indexSecond] = t;
    }

    // Основной метод
    public static void main(String[] args) {
        int[] array = inputMass();
        //Нахождение индексов мин и макс и постановка их в начало и конеу массива соотвественно
        swap(array, 0, findIndexOfMin(array));
        swap(array, array.length - 1, findIndexOfMax(array));
        outputMass(array);
    }
}
