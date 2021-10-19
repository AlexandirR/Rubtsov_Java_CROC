package Ex5;

public class AnnotatedImage {

    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    public Annotation findByPoint(int x, int y) {
        for (Annotation annotation : annotations) {
            if(annotation.getFigure().chekByPoint(x, y)) {
                return annotation;
            }
        }
        System.out.println("Not Found Annotation");
        return new Annotation(new Figure(), "Empty");
    }

    public Annotation findByLabel(String label) {
        for (Annotation annotation : annotations) {
            if(annotation.chekBySignature(label)) {
                return annotation;
            }
        }
        System.out.println("Not Found Annotation");
        return new Annotation(new Figure(), "Empty");
    }

    public void printAnnotations() {
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

}
