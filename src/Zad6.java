/*
Write a program that randomizes the dimension of a one-dimensional array of integers in the range <5, 10>.
The elements of the array are randomly selected from the range <10, 99>.
Generate a new array of integers where each ith element is formed by interchanging the ones and tens digits
  the i-th element of the first array. Check which table has the greater arithmetic mean.

Napisz program, w którym losujesz wymiar tablicy jednowymiarowej liczb całkowitych z przedziału <5, 10>.
Elementy tablicy losujemy z przedziału <10, 99>.
Wygeneruj nową tablicę liczb całkowitych, w której każdy i-ty element powstaje przez zamianę cyfr jedności i dziesiątek
 i-tego elementu tablicy pierwszej. Sprawdź, która tablica ma większą średnią arytmetyczną.
*/

import javax.swing.*;
import java.util.Random;

public class Zad6 {

    static int[] generateArray(int size, int min, int max) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0!");
        }
        if (min > max) {
            throw new IllegalArgumentException("Range is not correct");
        }

        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = generateRandomInt(min, max);
        }
        return array;
    }

    static int generateRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;

    }

    static int[] generateNewArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null!");
        }

        int l = array.length;

        int[] newArray = new int[l];

        for (int i = 0; i < l; i++) {
            newArray[i] = swapDigits(array[i]);
        }

        return newArray;

    }

    static int swapDigits(int number) {
        if (number < 10) {
            throw new IllegalArgumentException("Number must be greater than 9");
        }

        int units = number % 10;
        int tens = (number % 100) / 10;

        return units * 10 + tens;

    }

    static void showTwoArrays(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("Array is null");
        }

        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i] + "   " + array2[i]);
        }

    }

    static double calculateAverage(int[] array) {
        if(array == null) {
            throw new IllegalArgumentException("Array is null");
        }

        int count = 0;

        for (int value : array) {
            count += value;
        }

        return count / array.length;

    }

    public static void main(String[] args) {
        final int size = generateRandomInt(5, 10);
        final int MIN = 10;
        final int MAX = 99;
        int[] array1 = generateArray(size, MIN, MAX);
        int[] array2 = generateNewArray(array1);
        showTwoArrays(array1, array2);
        System.out.println();
        System.out.println("Average value of array 1: " + calculateAverage(array1));
        System.out.println("Average value of array 2: " + calculateAverage(array2));
        System.out.println("Greater average: " + Math.max(calculateAverage(array1), calculateAverage(array2)));



    }

}



