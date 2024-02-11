package Stacks;

import java.util.Stack;

public class Reverse {
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder res = new StringBuilder("");
        while (!s.empty()) {
            char curr = s.pop();
            res.append(curr);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "abc";
        String s = reverseString(str);
        System.out.println(s);

    }
}
