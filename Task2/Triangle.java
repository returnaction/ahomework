package Task2;

public class Triangle extends AbstractFigure implements Figure{
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(String backgroundColor, String borderColor, double sideA, double sideB, double sideC) {
        super(backgroundColor, borderColor);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double area() {
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String toString() {
        return "Периметр - " + perimeter() + ", Площадь - " + area() + super.toString();
    }
}
