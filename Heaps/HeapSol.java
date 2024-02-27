package Heaps;

import java.util.*;

public class HeapSol {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {// O(logn)
            // add at last idx
            arr.add(data);
            int x = arr.size() - 1; // x is child index
            int par = (x - 1) / 2; // par index
            while (arr.get(x) < arr.get(par)) {
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x - 1) / 2;
            }
        }

        public void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;
            if (left < arr.size() && arr.get(minIdx) < arr.get(left)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(minIdx) < arr.get(right)) {
                minIdx = right;
            }
            if (minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);

            }
        }

        // remove
        public int remove() {// O(logn)
            int data = arr.get(0);
            // step1-swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.size() - 1);
            arr.set(arr.size() - 1, temp);
            // step2- delete last
            arr.remove(arr.size() - 1);
            // step3 heapify
            heapify(0);
            return data;
        }

        public int peek() {
            return arr.get(0);
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

    }

    // heapsort
    public static void heapSort(int arr[]) {
        // step1 build Max Heap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapifys(arr, i, n);
        }
        // step2
        for (int i = n - 1; i > 0; i--) {
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapifys(arr, 0, i);
        }
    }

    public static void heapifys(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;
        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }
        if (maxIdx != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapifys(arr, maxIdx, i);
        }
    }

    public static void main(String[] args) {
        // Heap h = new Heap();// heap -O(nlogn)
        // h.add(3);
        // h.add(4);
        // h.add(1);
        // h.add(5);
        // // h.add(2);
        // while (!h.isEmpty()) {
        // System.out.println(h.peek());
        // h.remove();
        // }

        int arr[] = { 1, 2, 4, 5, 3 };
        heapSort(arr);
       for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i]+" ");
       }
       System.out.println();
    }
}
