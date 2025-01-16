public class Main {
    public static void main(String[] args) {
        // Task 1
        printThreeWords();
        // Task 2
        checkSumSign();
        // Task 3
        printColor();
    }

    // Task 1
    private static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // Task 2
    private static void checkSumSign(){
        int a = 5;
        int b = 10;

        if( a + b > 0){
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // Task 3
    private static void printColor(){
        int value = -2;
        if(value <= 0){
            System.out.println("Красный");
        }
        if(value > 0 && value <= 100){
            System.out.println("Желтый");
        }
        if( value > 100){
            System.out.println("Зеленый");
        }
    }
}
