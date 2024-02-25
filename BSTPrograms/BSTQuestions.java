package BSTPrograms;

import java.util.*;

public class BSTQuestions {
    static class Node {
        int data, key;
        Node left, right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    };

    static int min_diff, min_diff_key;

    static Node newNode(int key) {
        Node temp = new Node(key);
        temp.key = key;
        temp.left = temp.right = null;
        return temp;
    }

    static int sum = 0;

    /*
     * Range Sum of BST
     */
    static int rangeSumBST(Node root, int low, int high) {
        if (root == null)
            return 0;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (q.isEmpty() == false) {
            Node curr = q.peek();
            q.remove();
            if (curr.data >= low && curr.data <= high) {
                sum += curr.data;
            }
            if (curr.left != null && curr.data > low)
                q.add(curr.left);
            if (curr.right != null && curr.data < high)
                q.add(curr.right);
        }
        return sum;
    }

    static Node insert(Node node, int data) {
        if (node == null)
            return newNode(data);
        if (data <= node.data)
            node.left = insert(node.left, data);
        else
            node.right = insert(node.right, data);
        return node;
    }

    // static class Nodes{
    // int key;
    // Node left,right;
    // };
    static void maxDiffUtil(Node ptr, int k) {
        if (ptr == null)
            return;
        if (ptr.key == k) {
            min_diff_key = k;
            return;
        }
        if (min_diff > Math.abs(ptr.key - k)) {
            min_diff = Math.abs(ptr.key - k);
            min_diff_key = ptr.key;
        }
        if (k < ptr.key)
            maxDiffUtil(ptr.left, k);
        else
            maxDiffUtil(ptr.right, k);
    }

    static int maxDiff(Node root, int k) {
        min_diff = 999999999;
        min_diff_key = -1;
        maxDiffUtil(root, k);
        return min_diff_key;
    }

    static int count = 0;

    // public static Node insert(Node root,int x){
    // if(root==null){
    // return newNode(x);
    // }
    // if(x<root.data)
    // root.left=insert(root.left, x);
    // else if(x>root.data) root.right=insert(root.right, x);
    // }
    public static Node kthSmallest(Node root, int k) {
        if (root == null)
            return null;
        Node left = kthSmallest(root.left, k);
        if (left != null)
            return left;
        count++;
        if (count == k)
            return root;
        return kthSmallest(root.right, k);
    }

    public static void printKthSmallest(Node root, int k) {
        Node res = kthSmallest(root, k);
        if (res == null)
            System.out.println("There are less than k nodes in the BST");
        else
            System.out.println("K-th Smallest Element is " + res.data);
    }

    static Node root1;
    static Node root2;

    static int countPairs(Node root1, Node root2, int x) {
        if (root1 == null || root2 == null)
            return 0;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        Node top1, top2;
        count = 0;
        while (true) {
            while (root1 != null) {
                st1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                st2.push(root2);
                root2 = root2.right;
            }
            if (st1.empty() || st2.empty())
                break;
            top1 = st1.peek();
            top2 = st2.peek();
            if ((top1.data + top2.data) == x) {
                count++;
                st1.pop();
                st2.pop();
                root1 = top1.right;
                root2 = top2.left;
            } else if ((top1.data + top2.data) < x) {
                st1.pop();
                root1 = top1.right;
            } else {
                st2.pop();
                root2 = top2.left;
            }
        }
        return count;
    }

    static class Info {
        int max;
        int min;
        boolean isBST;
        int sum;
        int currmax;

        Info(int m, int mi, boolean is, int su, int curr) {
            max = m;
            min = mi;
            isBST = is;
            sum = su;
            currmax = curr;
        }

        Info() {
        }

    };

    static class INT {
        int a;
    }

    static Info MaxSumBSTUtil(Node root, INT maxsum) {
        if (root == null)
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0, 0);
        if (root.left == null && root.right == null) {
            maxsum.a = Math.max(root.data, root.data);
            return new Info(root.data, root.data, true, root.data, maxsum.a);
        }
        Info L = MaxSumBSTUtil(root.left, maxsum);
        Info R = MaxSumBSTUtil(root.right, maxsum);
        Info BST = new Info();
        if (L.isBST && R.isBST && L.max < root.data && R.min > root.data) {
            BST.max = Math.max(root.data, Math.max(L.max, R.max));
            BST.min = Math.min(root.data, Math.min(L.min, R.min));

            maxsum.a = Math.max(maxsum.a, R.sum + root.data + L.sum);
            BST.sum = R.sum + root.data + L.sum;
            BST.currmax = maxsum.a;
            BST.isBST = true;
            return BST;
        }
        BST.isBST = false;
        BST.currmax = maxsum.a;
        BST.sum = R.sum + root.data + L.sum;
        return BST;
    }

    static int MaxSumBST(Node root) {
        INT maxsum = new INT();
        maxsum.a = Integer.MIN_VALUE;
        return MaxSumBSTUtil(root, maxsum).currmax;
    }

    public static void main(String[] args) {
        // Node root = null;
        // root = insert(root, 10);
        // insert(root, 5);
        // insert(root, 15);
        // insert(root, 3);
        // insert(root, 7);
        // insert(root, 18);
        // int L = 7, R = 15;
        // System.out.print(rangeSumBST(root, L, R));

        // Node root = newNode(9);
        // root.left = newNode(4);
        // root.right = newNode(17);
        // root.left.left = newNode(3);
        // root.left.right = newNode(6);
        // root.left.right.left = newNode(5);
        // root.left.right.right = newNode(7);
        // root.right.right = newNode(22);
        // root.right.right.left = newNode(20);
        // int k = 18;
        // System.out.println(maxDiff(root, k));

        // Node root = null;
        // int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
        // for (int x : keys)
        // root = insert(root, x);
        // int k = 3;
        // printKthSmallest(root, k);

        // root1 = new Node(5);
        // root1.left = new Node(3);
        // root1.right = new Node(7);
        // root1.left.left = new Node(2);
        // root1.left.right = new Node(4);
        // root1.right.left = new Node(6);
        // root1.right.right = new Node(8);

        // root2 = new Node(10);
        // root2.left = new Node(6);
        // root2.right = new Node(15);
        // root2.left.left = new Node(3);
        // root2.left.right = new Node(8);
        // root2.right.left = new Node(11);
        // root2.right.right = new Node(18);

        // int x = 16;
        // System.out.println("Pairs= " + countPairs(root1, root2, x));

        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        System.out.println(MaxSumBST(root));
    }
}
