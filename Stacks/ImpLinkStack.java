package Stacks;

public class ImpLinkStack {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        // using LinkedList
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        // push
        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // pop
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }

        public void addFirst(int data) {
            // step 1 create new Node
            Node newNode = new Node(data);
            // size++;
            if (head == null) {
                head = newNode;
                return;
            }
            // step2 - new node next=head
            newNode.next = head; // link
            // step3- head= newNode
            head = newNode;
        }

    }

    public static void main(String[] args) {
        Stack ll = new Stack();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        while (!Stack.isEmpty()) {
            System.out.println(ll.peek());
            Stack.pop();
        }
    }
}
