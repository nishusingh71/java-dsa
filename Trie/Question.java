package Trie;

import java.util.*;

public class Question {
    static class TrieNode {
        List<String> data;
        TrieNode children[];
        boolean isEnd;

        TrieNode() {
            data = new ArrayList<>();
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    static TrieNode root;
    List<List<String>> ans;

    List<List<String>> groupAnagrams(String[] strs) {
        ans = new ArrayList<>();
        root = new TrieNode();
        for (String word : strs) {
            build(word);
        }
        dfs(root);
        return ans;
    }

    public static void build(String s) {
        TrieNode temp = root;
        char[] word = s.toCharArray();
        Arrays.sort(word);
        for (char c : word) {
            TrieNode child = temp.children[c - 'a'];
            if (child == null) {
                temp.children[c - 'a'] = new TrieNode();
                temp = temp.children[c - 'a'];
            }
            temp.isEnd = true;
            temp.data.add(s);
        }
    }

    public void dfs(TrieNode rt) {
        if (rt.isEnd) {
            ans.add(rt.data);
        }
        for (int i = 0; i < 26; i++) {
            if (rt.children[i] != null) {
                dfs(rt.children[i]);
            }
        }
    }
   //Longest word in Dictionary
   private static class Node{
    private char data;
    private String words;
    private boolean is;

   }
    public static void main(String[] args) {
        String word[] = { "eat", "tea", "titan", "ate", "mat", "bat" };
        for (int i = 0; i < word.length; i++) {
            build(word[i]);
        }
        // System.out.println(groupAnagrams(""));
    }
}
