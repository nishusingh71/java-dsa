package ArrayList;

import java.util.*;

public class MostFreqNum {
    public static int mostFreq(ArrayList<Integer> nums, int key) {
        int[] res = new int[1000];
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == key) {
                res[nums.get(i + 1) - 1]++;
            }
        }
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < 1000; i++) {
            if (res[i] > max) {
                max = res[i];
                ans = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(100);
        list.add(200);
        list.add(1);
        list.add(100);
        System.out.println(mostFreq(list, 1));
    }
}
