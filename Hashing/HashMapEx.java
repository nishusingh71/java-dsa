package Hashing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

class HashMapEx {

    // Implementation
    static class HashMap<K, V> {

        private class Node {

            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n

        private int N;
        private LinkedList<Node> buckets[]; // N=buckets.length

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;// data index
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N * 2];
            N = 2 * N;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            // nodes-> add in bucket
            for (int i = 0; i < oldBuck.length; i++) {
                LinkedList<Node> ll = oldBuck[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);// 0 to 3
            int di = searchInLL(key, bi); // valid; -1
            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);// 0 to 3
            int di = searchInLL(key, bi); // valid; -1
            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);// 0 to 3
            int di = searchInLL(key, bi); // valid; -1
            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }

        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        // Insertion -O(1)
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 120);
        hm.put("China", 150);
        hm.put("US", 50);
        System.out.println(hm);
        // Get-O(1)
        int population = hm.get("India");
        System.out.println(population);
        // ContainsKey-O(1)
        System.out.println(hm.containsKey("India")); // true
        // Remove
        System.out.println(hm.remove("US"));
        // System.out.println(hm.size());
        // hm.clear();
        System.out.println(hm);

        // Iterate
        // Set<String> keys = hm.keySet();
        // System.out.println(keys);

        // for (String k : keys) {
        // System.out.println("key =" + k + ", value=" + hm.get(k));
        // }
        // HashMap<String, Integer> hm = new HashMap<>();
        // hm.put("India", 120);
        // hm.put("China", 150);
        // hm.put("US", 50);
        // ArrayList<String> keys = hm.keySet();
        // for (String key : keys) {
        // System.out.println(key);
        // }
        // System.out.println(hm.get("India"));
        // System.out.println(hm.remove("India"));
        // System.out.println(hm.get("India"));

        // HashMap
        HashMap<String, Integer> hms = new HashMap<>();
        hms.put("India", 120);
        hms.put("China", 150);
        hms.put("US", 50);
        System.out.println(hm);

        // LinkedHashMap
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 120);
        lhm.put("China", 150);
        lhm.put("US", 50);
        System.out.println(lhm);

        // //TreeMap- sorted
        // TreeMap<String, Integer> tm = new TreeMap<>();
        // tm.put("India", 100);
        // tm.put("China", 150);
        // tm.put("US", 50);
        // System.out.println(tm);

    }
}
