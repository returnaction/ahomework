package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        factorialProgram();
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    public static void factorialProgram() {
        Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            try {
                System.out.print("Введите число: ");
                input = Integer.parseInt(sc.next());
                if (input < 0) {
                    System.out.println("Факториал нельзя найти для отрицательных чисел");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Введите целое число");
            }
        }
        sc.close();

        long factorialResult = factorial(input);
        System.out.println("Факториал числа  " + input + " = " + factorialResult);

    }
}
