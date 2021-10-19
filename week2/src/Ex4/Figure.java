package Ex4;

public class Figure {

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

    @Override
    public String toString() {
        return codeFigure + " Empty Figure";
    }
}
