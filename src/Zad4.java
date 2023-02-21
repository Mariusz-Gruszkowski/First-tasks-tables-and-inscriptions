/*
Napisz program, w którym rozpatrujemy tablicę kwadratową o elementach, które mogą być dowolnymi liczbami rzeczywistymi.
Rozmiar tablicy losujemy z przedziału <5, 10>. Sprawdź, dla której przekątnej w tej tablicy suma elementów pod przekątną
jest większa od sumy elementów nad przekątną.



 */

import java.math.BigDecimal;
import java.util.Random;

public class Zad4 {
    static int[][] generateSquareArray(int size, int min, int max) {
        if(size <= 0) {
            throw new IllegalArgumentException("Size must be greater than null");
        }
        if(min > max) {
            throw new IllegalArgumentException("Range is not correct");
            }

        int[][] array = new int[size][size];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new Random().nextInt(max - min + 1) + min;

            }
        }
        return array;
    }


    static void showArray(int[][] array) {
        if(array == null) {
            throw new IllegalArgumentException("Array is null");
        }

        for (int[] col : array)  {
            for (int row: col) {
                System.out.print(row + " ");
            }
            System.out.println(" ");
        }
    }

    static int calculateUpperHalf(int[][] array) {
        if(array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int midIndex = 1;
        int sum = 0;
        int i = 0;

        for (i = array[i].length - 1; i > 0 ; i--) {
            for (int j = 0; j < array.length; j++) {
                if(j < midIndex) {
                    sum += array[j][i];
                }

            }
            midIndex++;
        }
        return sum;
    }



    public static void main(String[] args) {
        final int min = 0;
        final int max = 9;
        final int size = new Random().nextInt(6) + 5;

        int[][] array = generateSquareArray(4, min, max);

        System.out.println("Generated array: ");
        showArray(array);
        System.out.println();
        System.out.println("Sum of upper half: " + calculateUpperHalf(array));

    }

}
