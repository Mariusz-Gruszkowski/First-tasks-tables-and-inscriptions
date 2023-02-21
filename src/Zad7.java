/*

Napisz program, w którym losujesz rozmiar tablicy jednowymiarowej liczb całkowitych z przedziału <10, 20>.
 Następnie losujesz dwa pierwsze elementy tablicy z przedziału <20, 100>. Każdy kolejny element tablicy to
  najmniejsza wspólna wielokrotność dwóch poprzednich elementów tablicy.
  Sprawdź, czy tablica zawiera jakiekolwiek duplikaty i podaj ich wartości.

 */

import java.util.*;

public class Zad7 {

    static int[] generateArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        int[] array = new int[size];
        return array;
    }

    static int generateRandomInt(int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("Range is not correct");
        }

        return new Random().nextInt(max - min + 1) + min;
    }

    static int findSmallestCommonMultiple(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("value is not correct");
        }


        int lower = Math.min(a, b);
        int higher = Math.max(a, b);

        int scm = higher;

        while (scm % lower != 0) {
            scm += higher;

        }

        return scm;

    }

    static int[] fillTheArray(int[] array) {

        array[0] = generateRandomInt(20, 100);
        array[1] = generateRandomInt(20, 100);

        for (int i = 2; i < array.length; i++) {
            array[i] = findSmallestCommonMultiple(array[i - 1], array[i - 2]);
        }

        return array;

    }

    static void findAndPrintDuplicates(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    System.out.println(array[i]);
                    break;
                }
            }
        }

    }


    public static void main(String[] args) {


        int[] array = generateArray(generateRandomInt(10, 20));

        int[] array2 = fillTheArray(array);

        System.out.println(Arrays.toString(array2));

        System.out.println("Duplicates:");

        findAndPrintDuplicates(array2);


    }

}