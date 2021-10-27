package Ex7;

public class ChessPosition {
    private int x;
    private int y;

    public ChessPosition(int x, int y) throws IllegalPositionException {
        if(x > 0 && x < 9 && y > 0 && y < 9) {
            this.x = x;
            this.y = y;
        }
        else
            throw new IllegalPositionException(x,y, new IllegalArgumentException());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) throws IllegalPositionException {
        if(x > 0 && x < 9) {
            this.x = x;
        }
        else
            throw new IllegalPositionException(x, y, new IllegalArgumentException());
    }

    public int getY() {
        return y;
    }

    public void setY(int y)  throws IllegalPositionException {
        if(y > 0 && y < 9) {
            this.y = y;
        }
        else
            throw new IllegalPositionException(x, y, new IllegalArgumentException());
    }

    // проверка для 2 точек являются ли они ходами кодня друг относительно друга
    public boolean checkTwo(ChessPosition chessPosition) throws IllegalMoveException {
        if((Math.abs(this.x - chessPosition.x) == 1 && Math.abs(this.y - chessPosition.y) == 2 )
                || (Math.abs(this.x - chessPosition.x) == 2 && Math.abs(this.y - chessPosition.y) == 1)) {
            return true;
        }
        else
            throw new IllegalMoveException(this, chessPosition, new IllegalArgumentException());
    }

    //проверка для всех точек можно ли по ним пройти конем
    public static boolean checkMove(ChessPosition[] chessPositions) throws IllegalMoveException {
        for (int i = 1; i < chessPositions.length; ++i) {
            if (!chessPositions[i - 1].checkTwo(chessPositions[i])){
                throw new IllegalMoveException(chessPositions[i - 1], chessPositions[i], new IllegalArgumentException());
            }
        }
        return true;
    }

    public static ChessPosition parse(String position) throws IllegalPositionException {
        return new ChessPosition(position.charAt(0) - 'a' + 1, position.charAt(1) - '0');
    }

    @Override
    public String toString() {
        return Character.toString('a' + this.x - 1) + Integer.toString(this.y);
    }
}