package Task2;

public class Rectangular extends AbstractFigure implements Figure{

    private final double width;
    private final double length;

    public Rectangular(String backgroundColor, String borderColor, double width, double length) {
        super(backgroundColor, borderColor);
        this.width = width;
        this.length = length;
    }


    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Периметр - " + perimeter() + ", Площадь - " + area() + super.toString();
    }
}
