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

    // Longest word in Dictionary
    private static class Node {
        private char data;
        private String words;
        private boolean isEnd;
        private Node[] children;

        public Node(char data) {
            this.data = data;
            this.data = data;
            this.words = null;
            this.isEnd = false;
            this.children = new Node[26];
        }

    }

    private static Node roots = new Node('/');
    private static String answer = " ";

    private static void insert(String word) {
        Node curr = roots;
        for (int i = 0; i < word.length(); i++) {
            int childIdx = word.charAt(i) - 'a';
            if (curr.children[childIdx] == null) {
                curr.children[childIdx] = new Node(word.charAt(i));
            }
            curr = curr.children[childIdx];
        }
        curr.isEnd = true;
        curr.words = word;
    }

    private static void dfs(Node node) {
        if (node == null) {
            return;
        }
        if (node.words != null) {
            if (node.words.length() > answer.length()) {
                answer = node.words;
            } else if (node.words.length() == answer.length() && node.words.compareTo(answer) < 0) {
                answer = node.words;
            }
        }
        for (Node child : node.children) {
            if (child != null && child.words != null) {
                dfs(node);
            }
        }
    }

    public static String longestWord(String[] words) {
        for (String word : words) {
            insert(word);
        }
        Node curr = roots;
        dfs(curr);
        return answer;
    }

    public static void main(String[] args) {
        String word[] = { "w", "wo", "wor", "worl", "world" };
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
            // System.out.println(longestWord(new String[i]));
        }
        // System.out.println(groupAnagrams(""));
        // for (int i = 0; i < word.length; i++)
        // answer="hellll";
          
    }
}
