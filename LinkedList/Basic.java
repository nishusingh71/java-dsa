package LinkedList;

import java.util.LinkedList;

public class Basic {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;

        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add First
    public void addFirst(int data) {
        // step 1 create new Node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step2 - new node next=head
        newNode.next = head; // link
        // step3- head= newNode
        head = newNode;
    }

    // Add Last
    public void addLast(int data) {
        // step 1 create new Node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            tail = newNode;
        }
        // step2 - new node next=head
        tail.next = newNode; // link
        // step3- head= newNode
        tail = newNode;
    }

    // Add in the Middle
    public void addMid(int idx, int data) {
        Node temp = head;
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove First
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // Remove Last
    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // prev: i=size-2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // Search(Iterative)
    public int iterativeSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // Search(Recursive)
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    // Reverse a LinkedLists
    // Iterative Approach - 1->2->3->4->5

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

    }

    // Find & Remove Nth node from End O(n)
    // Iterartive Approach
    public void deleteNthEnd(int n) {
        // calculate size
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (n == size) {
            head = head.next; // remove First
            return;
        }
        // size-n
        int i = 1;
        int iToFind = size - n;
        Node prev = head;
        while (i < iToFind) {
            prev.next = prev.next.next;
            return;
        }
    }

    // Check if LL is a palindrome.
    // odd
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow; // slow is my midNode
    }

    public boolean CheckPalindrome() {
        if (head != null || head.next == null) {
            return true;
        }
        // step1 find mid
        Node midNode = findMid(head);
        // step 2 reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // right half head
        Node left = head;
        // step3 check left half & right half;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // Detect a Loop / Cycle in a LL
    // Floyd's Cycle Finding Algo

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if (slow == fast) {
                return true; // cycle exist
            }
        }
        return false; // cycle doesnot exist
    }

    // Remove a Loop/Cycle in a LinkedList
    public void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }
        // Find meeting Point
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // remove cycle-last.next=null
        prev.next = null;
    }

    // Merge Sort on a LL
    public Node mergeSort(Node head) {
        if (head == null || head.next != null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);
        // left & right MS
        Node rHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rHead);
        // merge
        return merge(newLeft, newRight);
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid Node
    }

    private Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergeLL.next;
    }

    // Zig-zag
    public void zigzag() {
        // find Mid
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        // alt merge- zig zag merge
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }

    public static void print() {
        Node temp = head;
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Basic ll = new Basic();
        // ll.head = new Node(1);
        // ll.print();
        // ll.head.next=new Basic();
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.print();
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addMid(2, 9);
        // ll.print();
        // ll.removeFirst();
        // ll.print();
        // ll.removeLast();
        // ll.print();
        // System.out.println("Iterative Search =" + ll.iterativeSearch(10));
        // System.out.println("Recursive Search = " + ll.iterativeSearch(9));
        // ll.reverse();
        // ll.print();
        // ll.deleteNthEnd(2);
        // ll.print();
        // System.out.println(ll.size);
        // ll.addFirst(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // ll.print();
        // ll.addLast(1);
        // System.out.println(ll.CheckPalindrome());
        // System.out.println(isCycle());
        // removeCycle();

        // LinkedList<Integer> ll = new LinkedList<>();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addFirst(0);
        // System.out.println(ll);
        // ll.removeLast();
        // ll.removeFirst();
        // System.out.println(ll);
        ll.addFirst(1);
        ll.addLast(7);
        ll.addLast(5);
        Basic.print();
        // Basic.head = ll.mergeSort(Basic.head);
        // System.out.println(ll.head);
        // Basic.print();
        ll.zigzag();
        ll.print();
    }
}
