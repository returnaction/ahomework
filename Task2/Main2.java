package Task2;

public class Main2 {
    public static void main(String[] args) {
        Figure triangle = new Triangle("Black", "Blue", 5, 5, 5);
        System.out.println("Треугольник " + triangle);
        Figure rectangular = new Rectangular("Red", "Yellow", 7, 3);
        System.out.println("Прямоугольник " + rectangular);
        Figure circle = new Circle("White", "Pink", 5);
        System.out.println("Круг " + circle);
    }
}
