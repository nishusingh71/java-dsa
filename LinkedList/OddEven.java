package LinkedList;

public class OddEven {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void segregateEvenOdd() {
        Node end = head;
        Node prev = null;
        Node curr = head;
        while (end.next != null)
            end = end.next;
        Node newEnd = end;
        while (curr.data % 2 != 0 && curr != end) {
            newEnd.next = curr;
            curr = curr.next;
            newEnd.next.next = null;
            newEnd = newEnd.next;
        }
        if (curr.data % 2 == 0) {
            head = curr;
            while (curr != end) {
                if (curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    newEnd.next = curr;
                    newEnd = curr;
                    curr = prev.next;
                }
            }
        } else
            prev = curr;
        if (newEnd != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
        }
    }

    void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OddEven oe = new OddEven();
        oe.push(11);
        oe.push(10);
        oe.push(8);
        oe.push(6);
        oe.push(4);
        oe.push(2);
        oe.push(0);
        System.out.println("LinkedList");
        oe.printList();
        oe.segregateEvenOdd();
        System.out.println("Update Linked List");
        oe.printList();

    }
}
