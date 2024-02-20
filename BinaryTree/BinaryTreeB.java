package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeB {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) {
                return;
            }

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        // Height of a Tree
        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        // count of Nodes
        public static int count(Node root) {
            if (root == null) {
                return 0;
            }
            int lc = count(root.left);
            int rc = count(root.right);
            return lc + rc + 1;
        }

        // Sum of Nodes
        public static int sum(Node root) {
            if (root == null) {
                return 0;
            }
            int ls = sum(root.left);
            int rs = sum(root.right);
            return ls + rs + root.data;
        }

        // Diameter of a Tree
        // no. of nodes in the longest path b/w 2 leaves
        public static int diameter(Node root) {
            if (root == null) {
                return 0;
            }
            int leftDiameter = diameter(root.left);
            int leftHeight = height(root.left);
            int rightDiameter = diameter(root.right);
            int rightHeight = height(root.right);
            int selfDiameter = leftHeight + rightHeight + 1;
            return Math.max(Math.max(rightDiameter, leftDiameter), selfDiameter);
        }

        // case2
        static class Info {
            int diameter;
            int height;

            public Info(int d, int h) {
                diameter = d;
                height = h;
            }

            public static Info diameters(Node root) {
                if (root == null) {
                    return new Info(0, 0);
                }
                Info lI = diameters(root.left);
                Info rI = diameters(root.right);
                int dia = Math.max(Math.max(lI.diameter, rI.diameter), lI.height + rI.height + 1);
                int ht = Math.max(lI.height, rI.height) + 1;
                return new Info(dia, ht);
            }

        }

        public static boolean isSubtree(Node root, Node subRoot) {
            if (root == null) {
                return false;
            }
            if (root.data == subRoot.data) {
                if (isIdentical(root, subRoot)) {
                    return true;
                }
            }

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        public static boolean isIdentical(Node node, Node subRoot) {
            if (node == null && subRoot == null) {
                return true;
            } else if (node == null || subRoot == null || node.data != subRoot.data) {
                return false;
            }
            if (!isIdentical(node.left, subRoot.left)) {
                return false;
            }
            if (!isIdentical(node.right, subRoot.right)) {
                return false;
            }
            return true;
        }

        // TopView of tree
        static class Infotop {
            Node node;
            int hd;

            public Infotop(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        public static void topView(Node root) {
            // lvel order
            Queue<Infotop> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int min = 0, max = 0;
            q.add(new Infotop(root, 0));
            q.add(null);
            while (!q.isEmpty()) {
                Infotop curr = q.remove();
                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    if (!map.containsKey(curr.hd)) {// first time my hd is occurring
                        map.put(curr.hd, curr.node);
                    }
                    if (curr.node.left != null) {
                        q.add(new Infotop(curr.node.left, curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);
                    }
                    if (curr.node.right != null) {
                        q.add(new Infotop(curr.node.right, curr.hd + 1));
                        max = Math.max(max, curr.hd + 1);
                    }
                }
            }

            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // BinaryTree tree = new BinaryTree();
        // Info info = new Info(3, 2);
        // System.out.println(root.data);
        // BinaryTree.preorder(root);
        // System.out.println("Inorder Travsel :");
        // BinaryTree.inorder(root);
        // System.out.println();
        // BinaryTree.postorder(root);
        // System.out.println();
        // BinaryTree.levelorder(root);
        // System.out.println(BinaryTree.height(root));
        // System.out.println(BinaryTree.count(root));
        // System.out.println(BinaryTree.sum(root));
        // System.out.println(BinaryTree.Info.diameters(root).diameter);
        // Node root = BinaryTree.buildTree(nodes);
        // Tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);
        // subRoot
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        // subRoot.right = new Node(5);
        System.out.println(BinaryTree.isSubtree(root, subRoot));
        // System.out.println(topView(subRoot));
        BinaryTree.topView(root);

    }
}