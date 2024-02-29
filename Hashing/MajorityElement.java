package Hashing;

import java.util.*;

public class MajorityElement {
    // valid Anagram
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    // Iternary
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key; // Starting point
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Majority Element
        int ar[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            // if (map.containsKey(ar[i])) {
            // map.put(ar[i], map.get(ar[i]) + 1);
            // } else {
            // map.put(ar[i], 1);
            // }
            map.put(ar[i], map.getOrDefault(ar[i], 0) + 1);
        }

        // Set<Integer> keySet = map.keySet();
        for (Integer key : map.keySet()) {
            if (map.get(key) > ar.length / 3) {
                System.out.println(key);
            }
        }
        boolean b = isAnagram("care", "race");
        System.out.println(b);

        // HashSet
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(1);
        System.out.println(set);
        set.remove(2);
        if (set.contains(2)) {
            System.out.println("Set Contains");
        } else {
            System.out.println("Not Contains");
        }
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        // Iteration on HashSet
        // @SuppressWarnings("rawtypes")
        // Iterator iterator = set.iterator();
        // while (iterator.hasNext()) {
        // System.out.println(iterator.next());
        // }
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        Iterator it = cities.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // LinkedHashSet
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Noida");
        System.out.println(lhs);

        // TreeSet
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Noida");
        ts.add("Mumbai");
        System.out.println(ts);

        // Count Distinct Element
        int num[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            set2.add(num[i]);
        }
        System.out.println(set2.size());

        // Union & Interesection of 2 arrays
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        HashSet<Integer> h = new HashSet<>();
        // union
        for (int i = 0; i < arr1.length; i++) {
            h.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            h.add(arr2[i]);
        }
        System.out.println("Union =" + h.size());

        // Intersection
        h.clear();
        for (int i = 0; i < arr1.length; i++) {
            h.add(arr1[i]);
        }
        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (h.contains(arr2[i])) {
                count++;
                h.remove(arr2[i]);
            }
        }
        System.out.println("Intersection " + count);

        // Find Itinerary From Tickets
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");
        String start = getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.print("->" + tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();

        // Largest Subarray with 0 Sum
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        HashMap<Integer, Integer> mp = new HashMap<>();
        // Sum,idx
        int sum = 0, len = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (mp.containsKey(sum)) {
                len = Math.max(len, i - mp.get(sum));
            } else {
                mp.put(sum, i);
            }
        }
        System.out.println(len);

        //Subarray Sum equal to K
        int a[]={10,2,-2,-20,10};
        int k=-10;
        mp=new HashMap<>();
        //sum,count
        mp.put(0, 1);
        sum=0;
        int ans=0;
        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
            if (mp.containsKey(sum-k)) {
                ans+=mp.get(sum-k);
            }
            mp.put(sum, mp.getOrDefault(sum, 0)+1);
        }
        System.out.println(ans);
    }
}
