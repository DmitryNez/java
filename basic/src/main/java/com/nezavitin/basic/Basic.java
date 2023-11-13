package com.nezavitin.basic;

public class Basic {
    private static void fillArray(int[] array) {
        for (int idx = 0; idx < array.length; ++idx) {
            array[idx] = (int)(Math.random() * 10);
        }
    }

    private static void printArray(int[] array) {
        System.out.print("array : [ ");
        for (int value : array) { System.out.print(value + " "); }
        System.out.println("]");
    }

    private static void printArrayInfo(int[] array) {
        int length = array.length;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        double averageValue = 0;

        for (int value : array) {
            if (value > maxValue) {
                maxValue = value;
            }
            if (value < minValue) {
                minValue = value; 
            }
            averageValue += 1.0 * value / length;
        }

        printArray(array);
        System.out.println("Max element : " + maxValue);
        System.out.println("Min element : " + minValue);
        System.out.println("Average : " + averageValue);
    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array.length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    private static void printPrimeNumbers() {
        System.out.print("Prime number : ");
        for (int i = 2; i < 100; ++i) {
            boolean isPrime = true;
            for (int j = 2; j < i; ++j) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) System.out.print(i + " ");
        }
    }

    private static int[] deleteFromArray(int[] array, int value) {
        int valueCounter = 0;
        for (int element : array) {
            if (element == value) {
                ++valueCounter;
            }
        }

        int[] arrayWithoutValue = new int[array.length - valueCounter];
        int idx = 0;
        for (int element : array) {
            if (element != value) {
                arrayWithoutValue[idx++] = element;
            }
        }

        return arrayWithoutValue;
    }

    public static void main(String[] args) {
        // 1.0
        int[] array = new int[10];
        fillArray(array);
        printArrayInfo(array);

        // 1.1
        sort(array);
        System.out.print("Sorted ");
        printArray(array);

        // 1.2
        printPrimeNumbers();

        // 1.3
        int[] arrayForTestDelete = {1, 2, 1, 3, 1, 4, 1, 5, 1};
        System.out.println("\nBefore remove value 1: ");
        printArray(arrayForTestDelete);
        System.out.println("After remove value 1: ");
        printArray(deleteFromArray(arrayForTestDelete, 1));
    }
}
