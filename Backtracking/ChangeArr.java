package Backtracking;

public class ChangeArr {
    public static void changeArr(int arr[], int index, int val) {
        // base case
        if (index == arr.length) {
            printArr(arr);
            return;
        }
        // recursion
        arr[index] = val;
        // func call
        changeArr(arr, index + 1, val + 1);
        // Backtracking
        arr[index] = arr[index] - 2;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);
    }
}
