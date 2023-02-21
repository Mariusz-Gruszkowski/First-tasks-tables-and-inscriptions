/*
Write a program that randomizes the size of an array of integers between <5, 10>
and elements of this array from the range <100, 999>. The user then enters the index of the array element.
The task is to designate an element other than the one at the given index,
whose value is closest to the value of the element under the given index.


Napisz program, w którym losujesz rozmiar tablicy liczb całkowitych z przedziału <5, 10>
oraz elementy tej tablicy z przedziału <100, 999>. Następnie użytkownik podaje indeks elementu tablicy.
Zadanie polega na wyznaczeniu elementu innego niż ten pod podanym indeksem,
którego wartość jest najbliższa wartości elementu spod podanego indeksu.

 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Zad2 {
    static int[] generateArray(int size, int min, int max) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        if (max < min) {
            throw new IllegalArgumentException("Range is not correct");
        }

        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = randomNumber(min, max);
        }
        return array;
    }

    static int randomNumber(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int getIndex(int size) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter index: ");
        int index = in.nextInt();
        if (index < 0) {
            throw new IllegalArgumentException("Range is not correct");
        }
        if (index > size) {
            throw new IllegalArgumentException("Range is not correct");
        }
        return index;
    }

    static int findNearestElement(int[] array, int element) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }

        int diff = Math.abs(array[0] - array[element]);
        int nextIndex = 0;

        for (int i = 1; i < array.length; i++) {

            if (element == i) {
                continue;
            }

            int diff2 = Math.abs(array[i] - array[element]);
            if (diff2 < diff) {
                nextIndex = i;
                diff = diff2;
            }
            return nextIndex;
        }

        return nextIndex;
    }

    public static void main(String[] args) {
        final int SIZE = new Random().nextInt(6) + 5;
        final int MIN = 100;
        final int MAX = 999;
        int[] array = generateArray(SIZE, MIN, MAX);
        System.out.println(Arrays.toString(array));
        int index = getIndex(SIZE);
        int nextIndex = findNearestElement(array, index);
        System.out.println("Closest element to index " + index + " is " + nextIndex);

    }

}
