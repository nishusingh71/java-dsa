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

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node() {

        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }

    }

    Node head;
    Node tail;
    int maxCapcity;
    HashMap<Integer, Node> map;

    public void LRUCahe(int capcity) {
        head = new Node();
        head.next = tail;
        tail.prev = head;
        this.maxCapcity = capcity;
        map = new HashMap<>();

    }

    public void addLast(Node node) {
        Node temp = tail.prev;
        node.next = tail;
        tail.prev = node;
        node.prev = temp;
    }

    public void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        prevNode.prev = prevNode;
        node.prev = null;
        node.next = null;
    }

    public void moveToLast(Node node) {
        remove(node);
        addLast(node);
    }

    public int getKey(int key) {
        if (map.containsKey(key) == false) {
            return -1;
        } else {
            Node node = map.get(key);
            int val = node.value;
            moveToLast(node);
            return val;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key) == false) {
            Node node = new Node(key, value);
            if (map.size() == maxCapcity) {
                Node LRU_node = head.next;
                remove(LRU_node);
                map.remove(LRU_node.key);
            } else {
                node = map.get(key);
                node.value = value;
                moveToLast(node);
            }
        }
    }

    public static void main(String[] args) {
        // int arr[] = { 2, 7, 11, 15 };
        // int target = 9;

        // System.out.println(twoSum(arr, target));
        System.out.println(freqSort("tree"));

    }
}
