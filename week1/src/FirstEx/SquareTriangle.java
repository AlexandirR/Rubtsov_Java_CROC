package FirstEx;

import java.util.Scanner;

public class SquareTriangle {

    static class Point {
        public double x;
        public double y;
    }

    public static double calculateSide(Point point1, Point point2) {
        return Math.sqrt(Math.abs(point1.x - point2.x)*Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y)*Math.abs(point1.y - point2.y));
    }

    public static void main(String[] args) {
        double x,y;
        Scanner scanner = new Scanner(System.in);
        Point pointA = new Point();
        System.out.println("Write x1 and y1:");
        pointA.x = scanner.nextDouble();
        pointA.y = scanner.nextDouble();
        Point pointB = new Point();
        System.out.println("Write x2 and y2:");
        pointB.x = scanner.nextDouble();
        pointB.y = scanner.nextDouble();
        Point pointC = new Point();
        System.out.println("Write x3 and y3:");
        pointC.x = scanner.nextDouble();
        pointC.y = scanner.nextDouble();
        if((pointA.x == pointB.x && pointA.y == pointB.y) || (pointC.x == pointB.x && pointC.y == pointB.y) || (pointA.x == pointC.x && pointA.y == pointC.y)) {
            System.out.println("Wrong Points.");
        }
        else {
            double answer = 0.5 * Math.abs((pointB.x - pointA.x) * (pointC.y - pointA.y) - (pointC.x - pointA.x) * (pointB.y - pointA.y));
            System.out.println("Squre = " + answer);
        }
    }
}
