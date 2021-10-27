package Ex7;

import java.util.Scanner;

public class TestMain {

    private static Scanner scanner = new Scanner(System.in);
    private static ChessPosition[] chessPositions;

    //считывание и парсинг входных данных
    public static ChessPosition[] input() throws IllegalPositionException {
        String mas = scanner.nextLine();
        String[] strings = mas.split(" ");
        ChessPosition[] chessPositions = new ChessPosition[strings.length];
        for (int i = 0; i < strings.length; ++i) {
            chessPositions[i] = ChessPosition.parse(strings[i]);
        }
        return chessPositions;
    }

    public static boolean move() throws IllegalMoveException {
        return ChessPosition.checkMove(chessPositions);
    }

    public static void main(String[] args) {
        try {
            chessPositions = input();
            if(move()){
                System.out.println("OK");
            }
        }
        catch (IllegalPositionException ex) {
            System.out.println(ex.getMessage());
        }
        catch (IllegalMoveException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
