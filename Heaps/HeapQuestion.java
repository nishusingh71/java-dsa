package Heaps;

import java.util.*;

public class HeapQuestion {
    static PriorityQueue<Integer> min;
    static int k;

    static List<Integer> getAllKthNum(int arr[]) {
        List<Integer> list = new ArrayList<>();
        for (int val : arr) {
            if (min.size() < k)
                min.add(val);
            else {
                if (val > min.peek()) {
                    min.poll();
                    min.add(val);
                }
            }
            if (min.size() >= k)
                list.add(min.peek());
            else
                list.add(-1);
        }
        return list;
    }

    // Mininum Time required to fill given N Slots
    public static void minTime(int arr[], int N, int k) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[N + 1];
        int time = 0;
        for (int i = 0; i < k; i++) {
            q.add(arr[i]);
            vis[arr[i]] = true;
        }
        while (q.size() > 0) {
            for (int i = 0; i < q.size(); i++) {
                int curr = q.poll();
                if (curr - 1 >= 1 && !vis[curr - 1]) {
                    vis[curr - 1] = true;
                    q.add(curr - 1);
                }
                if (curr + 1 <= N && !vis[curr + 1]) {
                    vis[curr + 1] = true;
                    q.add(curr + 1);
                }
            }
            time++;
        }
        System.out.println(time - 1);
    }

    // Path with Minimum Effort
    // static String decode(String str) {
    //     Stack<Integer> integerStack = new Stack<>();
    //     Stack<Character> stringStack = new Stack<>();
    //     String temp = "", res = "";
    //     for (int i = 0; i < str.length(); i++) {
    //         int count = 0;
    //         if (Character.isDigit(str.charAt(i))) {
    //             while (Character.isDigit(str.charAt(i))) {
    //                 count = count * 10 + str.charAt(i) - '0';
    //                 i++;
    //             }
    //             i--;
    //             integerStack.push(count);
    //         } else if (str.charAt(i) == ')') {
    //             temp = "";
    //             count = 0;
    //         }
    //     }
    // }

    public static void main(String[] args) {
        // min = new PriorityQueue<>();
        // k = 3;
        // int arr[] = { 10, 20, 11, 70, 50, 40, 100, 5 };
        // List<Integer> res = getAllKthNum(arr);
        // for (int x : res)
        // System.out.print(x + " ");
        // System.out.println();

        int N = 6;
        int arr[] = { 2, 6 };
        int k = arr.length;
        minTime(arr, N, k);
    }

}
