package Ex7;

import java.util.Scanner;

public class TestMain {

    private static Scanner scanner = new Scanner(System.in);
    private static ChessPosition[] chessPositions;

    //считывание и парсинг входных данных
    public static ChessPosition[] input(String[] args) throws IllegalPositionException {
        ChessPosition[] chessPositions = new ChessPosition[args.length];
        for (int i = 0; i < args.length; ++i) {
            chessPositions[i] = ChessPosition.parse(args[i]);
        }
        return chessPositions;
    }

    public static boolean move() throws IllegalMoveException {
        return ChessPosition.checkMove(chessPositions);
    }

    public static void main(String[] args) {
        try {
            chessPositions = input(args);
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
        catch (Exception ex) {
            System.out.println("It's not my Error..\n" + ex.getMessage());
        }
    }
}
