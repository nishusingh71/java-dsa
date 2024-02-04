package ArrayList;

import java.util.*;

public class Beautiful {
    // Iterative
    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (Integer e : ans) {
                if (2 * e <= n)
                    temp.add(e * 2);
            }
            for (Integer e : ans) {
                if (2 * e - 1 <= n)
                    temp.add(e * 2 - 1);
            }
            ans = temp;
        }

        return ans;
    }

    // Divide & Conquer
    public static ArrayList<Integer> bArray(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        divideConquer(1, 1, res, n);
        return res;
    }

    private static void divideConquer(int start, int increament, ArrayList<Integer> res, int n) {
        if (start + increament > n) {
            res.add(start);
            return;
        }
        divideConquer(start, 2 * increament, res, n);
        divideConquer(start + increament, 2 * increament, res, n);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(bArray(n));
    }
}
