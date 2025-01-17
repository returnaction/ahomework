public class Main {
    public static void main(String[] args) {
        // Task 1
        printThreeWords();
        // Task 2
        checkSumSign();
        // Task 3
        printColor();
        // Task 4
        compareNumbers();
        // Task 5
        boolean result = sumOfNumbersBetween10and20(5,6);
        // Task 6
        printNumberOddOrEven(5);
        printNumberOddOrEven(-1);
        // Task 7
        boolean result2 = numberPositiveOrNegative(5);
        boolean result3 = numberPositiveOrNegative(-5);
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

    // Task 4
    private static void compareNumbers(){
        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);
        if( a >= b){
            System.out.println("a >= b");
        } else{
            System.out.println("a < b");
        }
    }

    // Task 5
    private static boolean sumOfNumbersBetween10and20(int num1, int num2){
        return num1 + num2 >=10 && num1 + num2 <= 20;
    }

    // Task 6
    private static void printNumberOddOrEven(int num){
        if(num >=0)
            System.out.println(num + " - число положительное.");
        else {
            System.out.println(num + " - число отрицательное.");
        }

    }

    // Task 7
    private static boolean numberPositiveOrNegative(int num){
        return num >= 0;
    }

}
