package Stacks;

import java.util.*;

public class PaliLink {

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        boolean condiition = isPal(one);
        System.out.println("Palindrome :" + condiition);

    }

    private static boolean isPal(Node head) {
        Node slow = head;
        boolean isPalin = true;
        Stack<Integer> stack = new Stack<Integer>();
        // push data in stack
        while (slow != null) {
            stack.push(slow.data);
            slow = slow.next;
        }
        while (slow != null) {
            int i = stack.pop();
            if (head.data == i) {
                isPalin = true;

            } else {
                isPalin = false;
                break;
            }
            head = head.next;
        }
        return isPalin;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

}