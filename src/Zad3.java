/*
Napisz program, w którym losowane są trzy liczby całkowite z przedziału <5, 10>.
Dwie największe spośród wylosowanych liczb to ilość wierszy i kolumn tablicy dwuwymiarowej liczb całkowitych
(nie ma znaczenia która liczba będzie ilością wierszy, a która ilością kolumn).
Tablicę wypełniamy wartościami losowanymi z przedziału <100, 999>. Następnie wylosuj indeks wiersza oraz indeks kolumny
tak wygenerowanej tablicy. Należy wyznaczyć do której krawędzi suma elementów w linii prostej od elementu wskazanego
przez wylosowane indeksy jest największa, tak jak pokazano to w przykładzie poniżej.
Zakładamy, że wyznaczono element oznaczony kolorem czerwonym.
Dla takiego układu elementów największa suma jest dla krawędzi lewej ponieważ wynosi 7 + 6 = 13.
Pozostałe sumy: dla krawędzi dolnej jest to 1, dla krawędzi prawej 2, natomiast dla krawędzi górnej 2 + 8 = 10.
3 1 8 1
8 9 2 8
7 6 5 2
8 6 1 1
 */

import java.util.Arrays;
import java.util.Random;

public class Zad3 {

    static int generateRandomNumber(int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("Range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int[][] generateArray(int rows, int cols, int min, int max) {
        if (rows <= 0) {
            throw new IllegalArgumentException("Number of rows is not correct");
        }
        if (cols <= 0) {
            throw new IllegalArgumentException("Number of cols is not correct");
        }
        if (max < min) {
            throw new IllegalArgumentException("Range is not correct");
        }

        int[][] array = new int[rows][cols];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = generateRandomNumber(min, max);
            }
        }
        return array;
    }

    static int[] threeRandomNumbers() {
        int[] array = new int[3];
        for (int i = 0; i < array.length; i++) {
            array[i] = generateRandomNumber(5, 10);
        }
        return array;
    }

    static void showArray(int[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }
        for (int[] row : array) {
            for (int i : row) {
                System.out.print(i + "\t");
            }
            System.out.println(" ");
        }
    }

    static int[] findBiggestSum(int[][] array, int i, int j) {

        if (array == null) {
            throw new IllegalArgumentException("Array is null !!");
        }
        if (i > array.length) {
            throw new IllegalArgumentException("Index is not correct");
        }
        if (j > array[i].length) {
            throw new IllegalArgumentException("Index is not correct");
        }

        int[] result = new int[4];

        result[0] = 0;   //left
        result[1] = 0;   //top
        result[2] = 0;   //right
        result[3] = 0;   //bottom

        for (int k = 0; k < array.length; k++) {
            for (int l = 0; l < array[k].length; l++) {

                if (k == i) {
                    if (l < j) {
                        result[0] += array[k][l];
                    }
                    if (l > j) {
                        result[1] += array[k][l];
                    }
                }

                if (l == j) {
                    if (k < i) {
                        result[2] += array[k][l];
                    }
                    if (k > i) {
                        result[3] += array[k][l];
                    }
                }
            }
        }
        return result;
    }

    static void findAndPrintBiggestValue(int[] array) {
        if(array == null) {
            throw new IllegalArgumentException("Array is null");
        }

        int biggest = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > biggest) {
                biggest = array[i];
                index = i;
            }
        }

        switch(index) {
            case 0:
                System.out.println("Biggest value is to the left border: " + biggest);
                break;
            case 1:
                System.out.println("Biggest value is to the top border: " + biggest);
                break;
            case 2:
                System.out.println("Biggest value is to the right border: " + biggest);
                break;
            case 3:
                System.out.println("Biggest value is to the bottom border: " + biggest);
                break;
        }
    }

    public static void main(String[] args) {

        System.out.println();
        int[] size = threeRandomNumbers();
        Arrays.sort(size);
        int[][] array = generateArray(size[2], size[1], 100, 999);
        System.out.println("Generated array:");
        showArray(array);

        int i = generateRandomNumber(0, size[2]-1);
        int j = generateRandomNumber(0, size[1]-1);
        System.out.println("Generated random index: " + i + " and " + j );

        int[] result = findBiggestSum(array, i, j);
        System.out.println("Result:");
        System.out.println(Arrays.toString(result));
        findAndPrintBiggestValue(result);


    }

}
