package Ex5;

public class TestMain {

    public static void main(String[] args) {
        Annotation[] annotations = new Annotation[3];
        Figure figure1 = new Figure();
        Annotation annotation1 = new Annotation(figure1, "Empty");
        annotations[0] = annotation1;
        Figure figure2 = new Circle(0, 0, 2);
        Annotation annotation2 = new Annotation(figure2, "Circle");
        annotations[1] = annotation2;
        Figure figure3 = new Rectangle(-5, -5, -3, -3);
        Annotation annotation3 = new Annotation(figure3, "Rectangle");
        annotations[2] = annotation3;
        AnnotatedImage annotatedImage = new AnnotatedImage("Puth", annotations);
        annotatedImage.printAnnotations();

        annotatedImage.findByLabel("Circle").getFigure().move(2, 2);
        annotatedImage.findByPoint(-4, -4).getFigure().move(1, 1);
        annotatedImage.findByLabel("NotEmpty").getFigure().move(1,1);
        annotatedImage.printAnnotations();
    }
}
