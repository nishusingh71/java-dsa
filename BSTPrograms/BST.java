package BSTPrograms;

import java.util.*;

import Queue.InterleaveHalves;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

    }

    // build BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Search a BST
    public static boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key)
            return true;
        if (root.data > key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // Delete a Node
    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else { // voila
                 // case 1 -leaf node delete
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2- single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // case 3- both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Print in Ranges
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    // Root to leaf Paths
    public static void printRoot2leaf(Node root, ArrayList<Integer> paths) {
        if (root == null) {
            return;
        }
        paths.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(paths);
        }
        printRoot2leaf(root.left, paths);
        printRoot2leaf(root.right, paths);
        paths.remove(paths.size() - 1);
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    // Validate BST
    // Approach 1st:-compare with left & right node.
    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    // Mirrir BST
    public static Node createMirror(Node root) {
        if (root == null) {
            return null;
        }
        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);
        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Sorted Array to Balanced BST
    public static Node createBST(int arr[], int st, int end) {
        if (st > end)
            return null;
        int mid = (st + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid - 1);
        root.right = createBST(arr, mid + 1, end);
        return root;
    }

    // Convert BST to Balanced BST-O(n)
    public static Node balanceBST(Node root) {
        // inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        // sorted inorder-> Balanced BST
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid - 1);
        root.right = createBST(inorder, mid + 1, end);
        return root;
    }

    // Size of Largest BST in BT
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBst, int size, int min, int max) {
            this.isBST = isBst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBst = 0;

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBst = Math.max(maxBst, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    // Merge 2 BST
    public static Node mergeBSTs(Node root1, Node root2) {
        // step 1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);
        // step 2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);
        // merge i=0, j=0;
        int i = 0, j = 0;
        ArrayList<Integer> findArr = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                findArr.add(arr1.get(i));
                i++;
            } else {
                findArr.add(arr2.get(j));
                j++;
            }
        }
        while (i < arr1.size()) {
            findArr.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size()) {
            findArr.add(arr2.get(j));
            j++;
        }
        // sorted AL-boolean BST
        return createBST(findArr, 0, findArr.size() - 1);
    }

    public static void main(String[] args) {
        // int values[] = { 8, 5, 3, 6, 10, 11, 14 };
        // Node root = null;
        // for (int i = 0; i < values.length; i++) {
        // root = insert(root, values[i]);
        // }
        // inorder(root);
        // System.out.println();
        // if (search(root, 6)) {
        // System.out.println("Found");
        // } else {
        // System.out.println("Not Found");
        // }
        // Node roots = delete(root,
        // inorder(root);
        // printInR
        // printRoot2leaf(root, new ArrayList<>());
        // System.out.println(isValidBST(root, null, null));

        // createMirror(root);
        // preorder(root);
        // System.out.println(createBST(values, 0, values.length - 1));
        // preorder(root);
        // Node r = balanceBST(root);
        // preorder(r);
        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);
        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);
        // Info Info = largestBST(root);
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBSTs(root1, root2);
        preorder(root);

    }

}
