package LinkedList;

public class DeleteN {
    static class Node {
        int data;
        Node next;

    }

    static Node push(Node head_ref, int new_data) {
        Node newdata = new Node();
        newdata.data = new_data;
        newdata.next = head_ref;
        head_ref = newdata;
        return head_ref;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.printf("%d", temp.data);
            temp = temp.next;
        }
        System.out.println("\n");
    }

    static void skipMdeleteN(Node head, int M, int N) {
        Node curr = head, t;
        int count;
        while (curr != null) {
            for (count = 1; count < M && curr != null; count++)
                curr = curr.next;
            if (curr == null)
                return;
            t = curr.next;
            for (count = 1; count <= N && t != null; count++) {
                Node temp = t;
                t = t.next;
            }
            curr.next = t;
            curr = t;
        }
    }

    public static void main(String[] args) {
        Node head = null;
        int M = 2, N = 3;
        head = push(head, 10);
        head = push(head, 9);
        head = push(head, 8);
        head = push(head, 7);
        head = push(head, 6);
        head = push(head, 5);
        head = push(head, 4);
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 1);
        head = push(head, 1);
        System.out.printf("M=%d\n" + "LinkedList we have is : \n", M, N);
        printList(head);
        skipMdeleteN(head, M, N);
        System.out.println("\n LinkedList on deletion is: \n");
        printList(head);

    }

}
