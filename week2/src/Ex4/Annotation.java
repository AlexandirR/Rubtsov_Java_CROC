package Ex4;

public class Annotation {
    private Figure figure;
    private String signature;

    public Annotation() {
        figure = new Figure();
        signature = "NAN";
    }

    public Annotation(Figure figure, String signature) {
        this.figure = figure;
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        return figure.toString() + " " + signature;
    }
}
