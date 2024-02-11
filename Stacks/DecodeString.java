package Stacks;

import java.util.Stack;

public class DecodeString {
    static String decode(String str) {
        Stack<Integer> IntegerStack = new Stack<>();
        Stack<Character> StringStack = new Stack<>();
        String temp = "", res = "";
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            if (Character.isDigit(str.charAt(i))) {
                while (Character.isDigit(str.charAt(i))) {
                    count = count * 10 + str.charAt(i) - '0';
                    i++;
                }
                i--;
                IntegerStack.push(count);
            } else if (str.charAt(i) == ']') {
                temp = "";
                count = 0;
                if (!IntegerStack.isEmpty()) {
                    count = IntegerStack.peek();
                    IntegerStack.pop();
                }
                while (!StringStack.isEmpty() && StringStack.peek() != '[') {
                    temp = StringStack.peek() + temp;
                    StringStack.pop();
                }
                if (!StringStack.empty() && StringStack.peek() == '[') {
                    StringStack.pop();
                }
                for (int j = 0; j < count; j++) {
                    res = res + temp;
                }
                for (int j = 0; j < res.length(); j++) {
                    StringStack.push(res.charAt(j));
                    res = "";
                }
            } else if (str.charAt(i) == '[') {
                if (Character.isDigit(str.charAt(i - 1))) {
                    StringStack.push(str.charAt(i));
                } else {
                    StringStack.push(str.charAt(i));
                    IntegerStack.push(1);

                }
            } else
                StringStack.push(str.charAt(i));
        }

        while (!StringStack.isEmpty()) {
            res = StringStack.peek() + res;
            StringStack.pop();
        }
        return res;

    }

    public static void main(String[] args) {
        String str = "3[b2[v]]L";
        System.out.println(decode(str));
    }
}
