/*

Napisz program, w którym losujesz rozmiar tablicy jednowymiarowej liczb całkowitych z przedziału <10, 20>.
Następnie losujesz pierwszy element tablicy z przedziału <10, 40>.
Kolejne elementy tablicy to suma czynników pierwszych poprzedniego elementu tablicy.
Wyznacz indeksy dwóch sąsiednich elementów tablicy, które różnią się najmniej między sobą.

 */

import java.util.Arrays;
import java.util.Random;

public class Zad8 {
    static int generateRandomInt(int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("Range is not correct");
        }

        return new Random().nextInt(max - min + 1) + min;
    }

    static int[] generateArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        return new int[size];
    }

    static void fillTheArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null !");
        }

        array[0] = generateRandomInt(10, 40);

        for (int i = 1; i < array.length; i++) {
            array[i] = sumOfPrimeFactors(array[i - 1]);
        }
    }


    static int sumOfPrimeFactors(int number) {

        int sum = 0;

        for (int i = 2; i < number; i++) {
            while (number % i == 0) {

                sum += i;
                number = number / i;
            }
        }
        return sum;
    }

    static void findSmallestDifference(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }
        
        int smallestDifference = Integer.MAX_VALUE;
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int difference = Math.abs(array[i]) - Math.abs(array[j]);
                if(difference < smallestDifference) {
                    smallestDifference = difference;
                    index1 = i;
                    index2 = j;
                }
            }
            
        }
        System.out.println("Indexes with smallest difference are " + index1 + " and " + index2);
    }

    public static void main(String[] args) {
        int[] array = generateArray(generateRandomInt(10, 20));
        fillTheArray(array);
        System.out.println("Generated array: ");
        System.out.println(Arrays.toString(array));
        System.out.println();
        findSmallestDifference(array);

    }
}
