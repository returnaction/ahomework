package Task1;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        // Здесь заполняем массив корректными данными от 1 до 16
        // Здесь должна быть корректная сумма = 136
        System.out.println("Должно пройти без исключений");
        String[][] arr1 = new String[4][4];
        fillArray(arr1, 1);
        testTheArray(arr1);


        // меняем у массива на что бы вызвало исключение MyArrayDataException;
        System.out.println("\n\tДолжно вызвать исключение MyArrayDataException и вывод ячейки");
        arr1[1][0] = "A5";
        testTheArray(arr1);

        // меняем у массива на что бы вызвало исключение MyArrayDataException;
        System.out.println("\n\tДолжно вызвать исключение MyArrayDataException и вывод ячейки");
        arr1[1][0] = "5";
        arr1[1][3] = "8F";
        testTheArray(arr1);

        // Здесь делаем новый массив что на 4х3 что бы вызвало исключение MyArraysSizeException
        System.out.println("\n\tЗдесь должно вызвать исключение  MyArrayDataException");
        String[][] arr2 = new String[4][3];
        fillArray(arr2, 1);
        testTheArray(arr2);

        // Здесь делаем новый массив что на 4х3 что бы вызвало исключение MyArraysSizeException
        System.out.println("\n\tЗдесь должно вызвать исключение  MyArrayDataException");
        String[][] arr3 = new String[4][5];
        fillArray(arr3, 1);
        testTheArray(arr2);

        // Здесь делаем новый массив что на 4х3 что бы вызвало исключение MyArraysSizeException
        System.out.println("\n\tЗдесь должно вызвать исключение  MyArrayDataException");
        String[][] arr4 = new String[3][4];
        fillArray(arr4, 1);
        testTheArray(arr2);

    }


    static void testTheArray(String[][] arr) {
        try {
            int sumOfArray = arraySum(arr);
            System.out.println("Сумма массива: " + sumOfArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
        }
    }

    // Вспомогательные метод для заполнения массива
    static void fillArray(String[][] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = String.valueOf(value++);
                System.out.print(arr[i][j].toString() + " ");
            }
            System.out.println();
        }
    }

    // Метод нахождения суммы двухмерного массива
    static int arraySum(String[][] arr) {

        if (!(arr.length == 4 &&
                arr[0].length == 4 &&
                arr[1].length == 4 &&
                arr[2].length == 4 &&
                arr[3].length == 4)) {
            throw new MyArraySizeException("Массив должен быть 4 на 4");
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("\nВ ячейке - [" + i + "][" + j + "] - " + arr[i][j] + " некорректные данные");
                }
            }
        }
        return sum;
    }
}
