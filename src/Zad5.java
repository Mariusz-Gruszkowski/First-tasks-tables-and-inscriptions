/*
Write a program that randomizes the dimensions of a two-dimensional array of real numbers in the range <10, 20>.
  Array elements are randomly selected from the range <2.5, 4.5>. You should designate a column,
  for which the sum of the values of the elements with an even row index is the greatest.


Napisz program, w którym losujesz wymiary tablicy dwuwymiarowej liczb rzeczywistych z przedziału <10, 20>.
 Elementy tablicy losowane są z przedziału <2.5, 4.5>. Należy wyznaczyć kolumnę,
 dla której suma wartości elementów o parzystym indeksie wiersza jest największa.
 */

import java.util.Arrays;
import java.util.Random;

public class Zad5 {

    static double[][] generateArray(int sizeMin, int sizeMax, double min, double max) {
        if (sizeMax < sizeMin) {
            throw new IllegalArgumentException("Range of size is not correct");
        }
        if (sizeMin <= 0) {
            throw new IllegalArgumentException("Min range of size must be greater than 0");
        }
        if (max < min) {
            throw new IllegalArgumentException("Range of array elements is not correct");
        }

        double[][] array = new double[generateRandomInt(sizeMin, sizeMax)][generateRandomInt(sizeMin, sizeMax)];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = generateRandomDouble(min, max);
            }
        }
        return array;
    }

    static int generateRandomInt(int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("Range ist not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static double generateRandomDouble(double min, double max) {
        if (max < min) {
            throw new IllegalArgumentException("Range is not correct");
        }
        return new Random().nextDouble() * (max - min + 1) + min;
    }

    static void showArray(double[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }
        for (double[] row : array) {
            for (double i : row) {
                System.out.print(i + "\t");
            }
            System.out.println(" ");
        }
    }

    static double sumColumn(double[][] array, int columnNumber) {
        if (array == null) {
            throw new IllegalArgumentException("array is null");
        }

        if (columnNumber < 0 || columnNumber >= array[0].length) {
            throw new IllegalArgumentException("column number is not correct");
        }

        int s = 0;
        for (int i = 0; i < array.length; i++) {
            s += array[i][columnNumber];
        }
        return s;
    }

    static int findColumnWithBiggestSum(double[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }
        /*int biggestIndex = 0;
        int biggestSum = 0;
        int sum = 0;

        for (int i = 0; i < array[i].length; i++) {
            for (int j = 0; j < array.length; j++) {
            if(j % 2 == 0) {
                sum += array[j][i];
            }
            if(sum > biggestSum) {
                biggestSum = sum;
                biggestIndex = i;
            }
            sum = 0;
            }
           }

    return biggestIndex;*/

        int maxIdx = 0;
        double maxSum = sumColumn(array, 0);
        double sum;

        for (int i = 1; i < array[0].length; i++) {
            sum = sumColumn(array, i);
            if (sum > maxSum) {
                maxSum = sum;
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public static void main(String[] args) {

        final int sizeMin = 10;
        final int sizeMax = 20;
        final double min = 2.5;
        final double max = 4.5;

        double[][] array = generateArray(sizeMin, sizeMax, min, max);

        System.out.println("Generated array: ");
        showArray(array);
        System.out.println();
        System.out.println("Index of the column with biggest sum: " + findColumnWithBiggestSum(array));
    }

}
