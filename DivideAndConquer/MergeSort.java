package DivideAndConquer;

public class MergeSort {
    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei)
            return;
        int mid = si + (ei - si) / 2;
        // left
        mergeSort(arr, si, mid);
        // right
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);

    }

    private static void merge(int[] arr, int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        // iterator for left part
        int i = si;
        // iterator for right part
        int j = mid + 1;
        // iterator for compare
        int k = 0;
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
                // k++;
            } else {
                temp[k] = arr[j];
                j++;
                // k++;
            }
            k++;

        }
        // left part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // right part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        // copy temp to original arr
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8, -2 };
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
