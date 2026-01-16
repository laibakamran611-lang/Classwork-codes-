package binarysearch;

public class BinarySearchRec {

    // Recursive Binary Search
    public static int binarySearchRec(int[] arr, int low, int high, int target) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            return binarySearchRec(arr, low, mid - 1, target);
        }

        return binarySearchRec(arr, mid + 1, high, target);
    }

    public static void main(String[] args) {

        int[] arr = {2, 5, 8, 12, 16, 25, 30};
        int target = 25;

        int result = binarySearchRec(arr, 0, arr.length - 1, target);

        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index: " + result);
    }
}
