package Hashing;

import java.util.*;

public class HashingQuestion {
    // Two Sum
    public static int[] twoSum(int arr[], int target) {
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // diff =given target-number given at ith idx
            int diff = target - arr[i];
            // check if found diff is present in the Map list
            if (visited.containsKey(diff)) {
                // if diff in map matches with the ith index element in array
                return new int[] { i, visited.get(diff) };
            }
            // add arr element in map to match with future element if forms a pair
            visited.put(arr[i], i);

        }
        return new int[] { 0, 0 };
    }

    // Sort by Frequency
    public static String freqSort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getKey());
        for (Map.Entry<Character, Integer> e : map.entrySet())
            pq.add(e);
        StringBuilder res = new StringBuilder();
        while (pq.size() != 0) {
            char ch = pq.poll().getKey();
            int val = map.get(ch);
            while (val != 0) {
                res.append(ch);
                val--;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        // int arr[] = { 2, 7, 11, 15 };
        // int target = 9;

        // System.out.println(twoSum(arr, target));
        System.out.println(freqSort("tree"));

    }
}
