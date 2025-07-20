package local.data.arrays;

import java.util.Arrays;
//import java.util.Comparator;

public class AppArrays {

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void printArray2(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    static int[] copyArray(int[] source) {
        int[] destination = new int[source.length];
        System.out.println("Original array: " + source);
        System.arraycopy(source, 0, destination, 0, source.length);
        System.out.println("Copied array using System.arraycopy:");
        printArray(destination);
        System.out.println("Copy " + destination);

        // Alternativa 1
        int[] destination2 = Arrays.copyOf(source, source.length);
        System.out.println("Copied array using Arrays.copyOf:");
        printArray(destination2);
        System.out.println("Copy " + destination2);

        // Alternativa 2
        int[] destination3 = source.clone();
        System.out.println("Copied array using clone:");
        printArray(destination3);
        System.out.println("Copy " + destination3);

        return destination;
    }

    static void compararArrays(int[] arr1, int[] arr2) {
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("Arrays are equal");
        } else {
            System.out.println("Arrays are not equal");
        }
    }

    static int[] sortArray(int[] arr) {
        int[] result = arr.clone();
        Arrays.sort(result);
        System.out.println("Sorted array:");
        printArray(result);
        return result;
    }

    static boolean binarySearch(int[] arr, int key) {
        int index = Arrays.binarySearch(arr, key);

        if (index >= 0) {
            System.out.println("Element " + key + " found at index: " + index);
            return true;
        } else {
            System.out.println("Element " + key + " not found.");
            return false;
        }
    }

    static void printArrayRef(int[] arr) {
        System.out.println("Parameter: " + arr);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Demo of Arrays in Java");

        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(arr);
        System.out.println("Arrays.toString:");
        System.out.println(Arrays.toString(arr));

        System.out.println("Array as parameter:");
        System.out.println("Argument: " + arr);
        printArrayRef(arr);
        System.out.println("Print original array:");
        // bucle for
        printArray(arr);
        // bucle for each
        printArray2(arr);
        System.out.println("Copias");
        int[] clone = copyArray(arr);
        System.out.println("Comparing original and cloned arrays:");
        System.out.println("Original array: " + arr);
        System.out.println("Cloned array: " + clone);
        System.out.println(arr == clone);
        compararArrays(arr, clone);

        int[] arrUnsorted = { 5, 3, 1, 4, 2 };
        System.out.println("Unsorted array:");
        printArray(arrUnsorted);
        int[] sortedArray = sortArray(arrUnsorted);
        System.out.println("Comparing original and sorted arrays:");
        System.out.println("Original array: " + arrUnsorted);
        System.out.println("Sorted array: " + sortedArray);
        binarySearch(sortedArray, 10); // Element not found
        binarySearch(sortedArray, 3); // Element found

        Integer[] aIntegers = { 3, 1, 7, 5, 4, 8 };
        Arrays.sort(aIntegers, (a, b) -> b - a);
        System.out.println(Arrays.toString(aIntegers));
    }
}