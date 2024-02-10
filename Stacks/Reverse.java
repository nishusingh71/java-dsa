package Stacks;

import java.util.Stack;

public class Reverse {
    public static void reverseString(String str){
        Stack<Character>s=new Stack<>();
        int idx=0;
        while (idx<str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder res=new StringBuilder("");
        while (!s.empty()) {
            char curr=s.pop();
            res.append(curr);
        }
        str=res.toString();
    }
}
