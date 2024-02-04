package ArrayList;

import java.util.*;

public class Monotonic {
    public static boolean isMonotonic(ArrayList<Integer> A) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) > A.get(i + 1))
                inc = false;
            if (A.get(i) < A.get(i + 1))
                dec = false;
        }
        return inc || dec;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(2);
        nums.add(3);
        System.out.println(isMonotonic(nums));
    }
}
