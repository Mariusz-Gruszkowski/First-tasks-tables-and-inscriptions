/*
 Zad

Write a program that randomizes the size of an array of integers between <4, 7>
and elements of this array from the range <100, 999>. Give the indexes of the three elements of this array with the
 largest sum of digits.

 */


import java.util.Arrays;
import java.util.Random;

public class Zad1 {

    static int [] generateArray(int size, int min, int max) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0 !");
        }
        if (min > max) {
            throw new IllegalArgumentException("Range is not correct");
        }

        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(max - min + 1) + min;
        }
        return array;
    }

    static int digitsSum(int number) {
        number = Math.abs(number);

        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;

    }

    static void findAndPrintThreeBiggest(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }

        int first = 0;
        int second = 0;
        int third = 0;

        for (int i = 0; i < array.length; i++) {

            int sum = digitsSum(array[i]);

            if (sum > digitsSum(array[first])) {
                third = second;
                second = first;
                first = i;

            } else if(sum > digitsSum(array[second])) {
                third = second;
                second = i;

            } else if (sum > digitsSum(array[third])) {
                 third = i;
            }
        }

        System.out.println("Index with the biggest sum of digits: " + first + " \n Index of second: " + second + "  \n Index of third: " + third);


    }


    public static void main(String[] args) {
        final int SIZE = new Random().nextInt(4) + 5;
        final int MIN = 100;
        final int MAX = 999;

        int[] array = generateArray(SIZE, MIN, MAX);

        System.out.println(Arrays.toString(array));
        System.out.println(" ");
        findAndPrintThreeBiggest(array);

    }

}
