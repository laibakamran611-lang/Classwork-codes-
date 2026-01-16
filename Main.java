package dsaaignment;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {5, 3, 4, 1};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();
        int[] arr4 = arr1.clone();
        int[] arr5 = arr1.clone();

        BubbleSort.sort(arr1);
        System.out.println("BubbleSort: " + Arrays.toString(arr1));

        SelectionSort.sort(arr2);
        System.out.println("SelectionSort: " + Arrays.toString(arr2));

        InsertionSort.sort(arr3);
        System.out.println("InsertionSort: " + Arrays.toString(arr3));

        MergeSort.sort(arr4);
        System.out.println("MergeSort: " + Arrays.toString(arr4));

        QuickSort.sort(arr5);
        System.out.println("QuickSort: " + Arrays.toString(arr5));
    }
}
