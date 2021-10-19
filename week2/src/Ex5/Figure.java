package Ex5;

public class Figure implements Movable {

    protected String codeFigure;

    public Figure() {
        this.codeFigure = "F";
    }

    public String getCodeFigure() {
        return codeFigure;
    }

    public void setCodeFigure(String codeFigure) {
        this.codeFigure = codeFigure;
    }

    public boolean chekByPoint(int x, int y) {
        return false;
    }

    @Override
    public void move(int dx, int dy) {
        System.out.println("Can't move empty figure");
    }

    @Override
    public String toString() {
        return codeFigure + " Empty Figure";
    }
}
