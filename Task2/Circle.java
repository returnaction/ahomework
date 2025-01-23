package Task2;

 class Circle extends AbstractFigure implements Figure {
     final double radius;

     public Circle(String backgroundColor, String borderColor, double radius) {
         super(backgroundColor, borderColor);
         this.radius = radius;
     }

     @Override
     public double area() {
         return Math.PI * radius * radius;
     }

     @Override
     public double perimeter() {
         return 2 * Math.PI * radius;
     }

     @Override
     public String toString() {
         return "Периметр - " + perimeter() + ", Площадь - " + area() + super.toString();
     }
 }
