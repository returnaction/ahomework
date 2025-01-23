import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

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
        boolean result = sumOfNumbersBetween10and20(5, 6);
        System.out.println("Task #5 sumOfNumbersBetween10and20 = " + result);

        // Task 6
        printNumberOddOrEven(5);
        printNumberOddOrEven(-1);

        // Task 7
        boolean result2 = numberIsNegative(5);
        System.out.println("Task #7 numberIsNegative(5) = " + result2);
        boolean result3 = numberIsNegative(-5);
        System.out.println("Task #7 numberIsNegative(-5) = " + result3);

        // Task 8
        printLine(3, "Nikita loves Java");

        // Task 9
        boolean result4 = checkYearType(2020);
        System.out.println("Task #9 checkYearType = " + result4);

        // Task 10
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Array before inverting " + Arrays.toString(arr));
        arrChange1to0and0to1(arr);
        System.out.println("Array after inverting " + Arrays.toString(arr));

        // Task 11
        int[] array100 = new int[100];
        fillArrayFrom1to100(array100);
        System.out.println(Arrays.toString(array100));

        // Task 12
        int[] arr12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Task 12 before - " + Arrays.toString(arr12));
        multiplyByTwoNumbersMoreThanSix(arr12);
        System.out.println("Task 12 after - " + Arrays.toString(arr12));

        // Task13
        int[][] resultArr = createArrayTwoDimension();
        // вывод на экран
        for (int i = 0; i < resultArr.length; i++) {
            for (int j = 0; j < resultArr[i].length; j++) {
                System.out.print(resultArr[i][j]);
            }
            System.out.println();
        }

        // Task14
        int[] arrTask14 = makeArray(5, 66);
        System.out.println(Arrays.toString(arrTask14));

    }

    // Task 1
    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // Task 2
    private static void checkSumSign() {
        Random rnd = new Random();
        int a = rnd.nextInt(201) - 100;
        int b = rnd.nextInt(201) - 100;

        if (a + b >= 0) {
            System.out.println("Task2 = Сумма " + a + " и " + b +" положительная");
        } else {
            System.out.println("Task2 = Сумма " + a + " и " + b +"  отрицательная");
        }
    }

    // Task 3
    private static void printColor() {
        int value = -2;
        if (value <= 0) {
            System.out.println("Красный");
        }
        if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        }
        if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    // Task 4
    private static void compareNumbers() {
        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);
        if (a >= b) {
            System.out.println(a + " >= " + b);
        } else {
            System.out.println(a + " < " + b);
        }
    }

    // Task 5
    private static boolean sumOfNumbersBetween10and20(int num1, int num2) {
        return num1 + num2 >= 10 && num1 + num2 <= 20;
    }

    // Task 6
    private static void printNumberOddOrEven(int num) {
        if (num >= 0)
            System.out.println(num + " - число положительное.");
        else {
            System.out.println(num + " - число отрицательное.");
        }

    }

    // Task 7
    private static boolean numberIsNegative(int num) {
        return num < 0;
    }

    // Task 8
    private static void printLine(int num, String text) {
        for (int i = 0; i < num; i++) {
            System.out.println(text);
        }
    }

    // Task 9
    private static boolean checkYearType(int year) {
        // 0004 0008 0012 0016 0020 0024  и 400 и 4
        // 100
        if (year % 400 == 0)
            return true;
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return false;
    }

    // Task 10
    private static void arrChange1to0and0to1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] ^= 1;
        }
    }

    // Task 11
    private static void fillArrayFrom1to100(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }

    // Task 12
    private static void multiplyByTwoNumbersMoreThanSix(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i] *= 2;
        }
    }

    // Task 13
    private static int[][] createArrayTwoDimension() {
        int[][] arr = new int[5][5];

        for (int i = 0; i < arr.length; i++) {
            for (int y = 0; y < arr[i].length; y++) {
                // c лево на право
                if (i == y) {
                    arr[i][y] = 1;
                }
                // с право на лево
                if (arr.length - (i + y + 1) == 0) {
                    arr[i][y] = 1;
                }
            }
        }

        return arr;
    }

    // Task 14
    private static int[] makeArray(int len, int initialValue){
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

}
