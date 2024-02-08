package LinkedList;

public class MergeKSorted {
    public static Node sortedMerge(Node a, Node b) {
        Node res = null;
        if (a == null)
            return b;
        else if (b == null)
            return a;
        if (a.data <= b.data) {
            res = a;
            res.next = sortedMerge(a.next, b);
        } else {
            res = b;
            res.next = sortedMerge(a, b.next);
        }
        return res;
    }

    public static Node MergeKList(Node arr[], int last) {
        while (last != 0) {
            int i = 0, j = last;
            while (i < j) {
                arr[i] = sortedMerge(arr[i], arr[j]);
                i++;
                j--;
                if (i >= j)
                    last = j;
            }
        }
        return arr[0];
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 4;
        Node arr[] = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[0] = new Node(0);
        arr[0].next = new Node(9);
        arr[0].next.next = new Node(10);
        arr[0].next.next.next = new Node(11);

        Node head = MergeKList(arr, k - 1);
        printList(head);

    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
