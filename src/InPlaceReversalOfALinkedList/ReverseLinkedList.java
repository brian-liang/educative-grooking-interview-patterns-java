package InPlaceReversalOfALinkedList;

import java.util.*;

class ReverseLinkedList {
    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode next = null;

        LinkedListNode curr = head;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

        return head;
    }

    public static void main(String[] args) {

        int[][] input = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5, 6},
                {3, 2, 1},
                {10},
                {1, 2}
        };

        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
            inputLinkedList.createLinkedList(input[i]);
            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList.printListWithForwardArrow(inputLinkedList.head);
            System.out.print("\n\tReversed linked list: ");
            PrintList.printListWithForwardArrow(reverse(inputLinkedList.head));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}