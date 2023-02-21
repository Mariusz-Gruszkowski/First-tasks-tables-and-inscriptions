/*
Napisz program, w którym losujesz wymiary tablicy dwuwymiarowej liczb całkowitych z przedziału <5, 10>.
Elementy tablicy losowane są z przedziału <100, 999>. Podaj indeks wiersza i kolumny wszystkich elementów tablicy,
 które posiadają cyfrę dziesiątek większą od sumy cyfr jedności i setek.
 */

import java.util.Arrays;
import java.util.Random;

public class Zad9 {

    static int generateRandomInt(int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("Range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int[][] generateArray(int sizeMin, int sizeMax, int min, int max) {
        if (sizeMin <= 0 || sizeMax <= 0) {
            throw new IllegalArgumentException("Value must be greater than 0");
        }
        if (max < min) {
            throw new IllegalArgumentException("Range is not correct");
        }

        int[][] array = new int[generateRandomInt(sizeMin, sizeMax)][generateRandomInt(sizeMin, sizeMax)];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
            array[i][j] = generateRandomInt(min, max);
            }
        }
        return array;
    }

    static boolean checkDigits(int number) {
        if(number < 100) {
            throw new IllegalArgumentException("Value is not correct");
        }

        int units = number % 10;
        int tens = number % 100 / 10;
        int hunderts =  number % 1000 / 100;

        if(tens > units + hunderts) {
            return true;
        } else {
            return false;
        }

        }

        static void findIndex (int[][] array) {
        if(array == null) {
            throw new IllegalArgumentException("Array is null");
        }

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if(checkDigits(array[i][j])) {
                        System.out.println("Col: " + i + " Row: " + j);
                    }
                }

            }

        }


    public static void main(String[] args) {
        final int minSize = 5;
        final int maxSize = 10;
        final int MIN = 100;
        final int MAX = 999;

        int[][] array = generateArray(minSize, maxSize, MIN, MAX);

        System.out.println("Generated array: ");
        System.out.println(Arrays.deepToString(array));
        System.out.println();
        findIndex(array);

    }
}
