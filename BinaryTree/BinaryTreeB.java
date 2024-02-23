package BinaryTree;

import java.util.ArrayList;
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

        public void inOrder() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'inOrder'");
        }

        public void mirror() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'mirror'");
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

        // Kth level
        public static void Klevel(Node root, int level, int k) {
            if (root == null) {
                return;
            }
            if (level == k) {
                System.out.println(root.data + " ");
                return;
            }
            Klevel(root.left, level + 1, k);
            Klevel(root.right, level + 1, k);
        }

        // Lowest Common Ancestor-Approch-1
        public static Node lca(Node root, int n1, int n2) {
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();
            getPath(root, n1, path1);
            getPath(root, n2, path2);
            // last common ancestor
            int i = 0;
            for (; i < path1.size() & i < path2.size(); i++) {
                if (path1.get(i) != path2.get(i)) {
                    break;
                }
            }
            // last equal node ->i-th
            Node lca = path1.get(i - 1);
            return lca;
        }

        public static boolean getPath(Node root, int n, ArrayList<Node> path) {
            if (root == null)
                return false;
            path.add(root);
            if (root.data == n) {
                return true;
            }
            boolean foundLeft = getPath(root.left, n, path);
            boolean foundRight = getPath(root.right, n, path);
            if (foundLeft || foundRight) {
                return true;
            }
            path.remove(path.size() - 1);
            return false;
        }

        // LCA 2
        public static Node lca2(Node root, int n1, int n2) {
            if (root == null)
                return null;
            if (root.data == n1 || root.data == n2) {
                return root;
            }
            Node leftLca = lca2(root.left, n1, n2);
            Node rightLca = lca2(root.right, n1, n2);
            // leftLca=val rightLca=null
            if (rightLca == null) {
                return leftLca;
            }
            if (leftLca == null) {
                return rightLca;
            }
            return root;

        }

        // Min distance b/w nodes
        public static int minDist(Node root, int n1, int n2) {
            Node lca = lca2(root, n1, n2);
            int dist1 = lcaDist(lca, n1);
            int dist2 = lcaDist(lca, n2);
            return dist1 + dist2;
        }

        public static int lcaDist(Node root, int n) {
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 0;
            }
            int leftDist = lcaDist(root.left, n);
            int rightDist = lcaDist(root.right, n);
            if (leftDist == -1 && rightDist == -1)
                return 1;
            else if (leftDist == -1)
                return rightDist + 1;
            else {
                return leftDist + 1;
            }
        }

        // Kth Ancestor of node
        public static int kAncestor(Node root, int n, int k) {
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 0;
            }
            int lDist = kAncestor(root.left, n, k);
            int rDist = kAncestor(root.right, n, k);
            if (lDist == -1 && rDist == -1) {
                return -1;
            }
            int max = Math.max(lDist, rDist);
            if (max + 1 == k) {
                System.out.println(root.data);
            }
            return max + 1;
        }

        // Transform to sum tree
        public static int transfom(Node root) {
            if (root == null) {
                return 0;
            }
            int leftChild = transfom(root.left);
            int rightChild = transfom(root.right);
            int data = root.data;
            int newLeft = root.left == null ? 0 : root.left.data;
            int newRight = root.right == null ? 0 : root.right.data;
            root.data = newLeft + leftChild + newRight + rightChild;
            return data;
        }

        // Question to Practice
        static boolean isUnivalued(Node root) {
            if (root == null) {
                return true;
            }
            if (root.left != null && root.data != root.left.data)
                return false;
            if (root.right != null && root.data != root.right.data)
                return false;
            return isUnivalued(root.left) && isUnivalued(root.right);
        }

        // Delete Leaf Node with values as X.
        static Node deleteLeaf(Node root, int x) {
            if (root == null)
                return null;
            root.left = deleteLeaf(root.left, x);
            root.right = deleteLeaf(root.right, x);
            if (root.data == x && root.left == null && root.right == null) {
                return null;
            }
            return root;
        }

        
    }

    public static void main(String[] args) {
        // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
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
        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);
        // System.out.println(BinaryTree.isSubtree(root, subRoot));
        // System.out.println(topView(subRoot));
        // BinaryTree.topView(root);
        // int k = 3;
        // BinaryTree.Klevel(root, 3, k);
        int n1 = 4, n2 = 5;
        // System.out.println( BinaryTree.lca(root, n1, n2));
        // System.out.println(BinaryTree.lca2(root, n1, n2).data);
        // System.out.println(BinaryTree.minDist(root, n1, n2));
        // System.out.println(BinaryTree.kAncestor(root, 5, 1));
        // System.out.println(BinaryTree.transfom(root));
        // BinaryTree.preorder(root);
        // System.out.println(BinaryTree.isUnivalued(root));
        // root.inOrder();
        // System.out.println("");
        // root.mirror();
        // root.inOrder();
        BinaryTree.deleteLeaf(root, 1);
        BinaryTree.inorder(root);
    }
}