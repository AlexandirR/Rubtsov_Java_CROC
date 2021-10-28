package Ex7;

public class IllegalPositionException extends Exception {

    private final int x;
    private final int y;

    public IllegalPositionException(int x, int y, Throwable e) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String getMessage() {
        return "Coordinates " + this.x + " " + this.y + " are outside the board! (a-h, 1-8)";
    }
}
