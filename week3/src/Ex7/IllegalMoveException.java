package Ex7;

public class IllegalMoveException extends Exception {
    private final ChessPosition first;
    private final ChessPosition second;

    public IllegalMoveException(ChessPosition first, ChessPosition second, Throwable e) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String getMessage() {
        return "Impossible to move from point " + this.first + " to point " + this.second;
    }
}
