package Ex5;

public class Rectangle extends Figure {
    private int xLeft;
    private int yBottom;
    private int xRight;
    private int yUpper;

    public Rectangle() {
        this.xLeft = 0;
        this.yBottom = 0;
        this.xRight = 0;
        this.yUpper = 0;
        this.codeFigure = "R";
    }

    public Rectangle(int xLeft, int yBottom, int xRight, int yUpper) {
        this.xLeft = xLeft;
        this.yBottom = yBottom;
        this.xRight = xRight;
        this.yUpper = yUpper;
        this.codeFigure = "R";
    }

    public int getXLeft() {
        return xLeft;
    }

    public void setXLeft(int xLeft) {
        this.xLeft = xLeft;
    }

    public int getYBottom() {
        return yBottom;
    }

    public void setYBottom(int yBottom) {
        this.yBottom = yBottom;
    }

    public int getXRight() {
        return xRight;
    }

    public void setXRight(int xRight) {
        this.xRight = xRight;
    }

    public int getYUpper() {
        return yUpper;
    }

    public void setYUpper(int yUpper) {
        this.yUpper = yUpper;
    }

    @Override
    public boolean chekByPoint(int x, int y) {
        return (x >= this.xLeft && x <= this.xRight && y >= this.yBottom && y <= this.yUpper);
    }

    @Override
    public void move(int dx, int dy) {
        this.xLeft += dx;
        this.yBottom += dy;
        this.xRight += dx;
        this.yUpper += dy;
    }

    @Override
    public String toString() {
        return codeFigure + " (" + xLeft + ", " + yBottom + "), " + " (" + xRight + ", " + yUpper + "):";
    }
}
