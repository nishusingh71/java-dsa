package Strings;

import java.util.*;

public class Anagrams {
    public static void isAnagram(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if (str1.length() == str2.length()) {
            char[] str1CharArr = str1.toCharArray();
            char[] str2CharArr = str2.toCharArray();
            Arrays.sort(str1CharArr);
            Arrays.sort(str2CharArr);
            boolean res = Arrays.equals(str1CharArr, str2CharArr);
            if (res) {
                System.out.println(str1 + " and " + str2 + " are Anagrams of each others");
            } else {
                System.out.println(str1 + " and " + str2 + " are not Anagrams of each others");
            }
        } else {
            System.out.println(str1 + " and " + str2 + " are not Anagrams of each others");
        }
    }

    public static void main(String[] args) {
        String str1 = "heart";
        String str2 = "earth";
        isAnagram(str1, str2);
    }
}
