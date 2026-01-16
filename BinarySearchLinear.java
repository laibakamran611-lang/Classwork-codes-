package binarysearch;

public class BinarySearchLinear {

    // Recursive Linear Search
    public static int linearSearchRec(int[] arr, int target, int index) {

        // Base case
        if (index == arr.length) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        }

        return linearSearchRec(arr, target, index + 1);
    }

    public static void main(String[] args) {

        int[] arr = {5, 12, 7, 25, 3};
        int target = 25;

        int result = linearSearchRec(arr, target, 0);

        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index: " + result);
    }
}
