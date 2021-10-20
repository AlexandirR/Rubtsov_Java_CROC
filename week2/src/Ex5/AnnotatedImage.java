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

    //Поиск по координатам
    public Annotation findByPoint(int x, int y) {
        //Проходим по всем элементам массива и вызываем у их фигур метод для проверки принодлежности ей
        for (Annotation annotation : annotations) {
            if(annotation.getFigure().chekByPoint(x, y)) {
                return annotation;
            }
        }
        //Если ничего не нашли
        System.out.println("Not Found Annotation");
        return new Annotation(new Figure(), "Empty");
    }

    //Метод поиска по подписи
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
