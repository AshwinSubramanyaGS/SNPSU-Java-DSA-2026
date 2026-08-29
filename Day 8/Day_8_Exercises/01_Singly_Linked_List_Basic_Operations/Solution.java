import java.util.ArrayList;

public class Solution {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static Node insertHead(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null)
            return newNode;
        newNode.next = head;
        return newNode;
    }

    public static Node insertTail(Node head, int value) { /* implement */
        Node newNode = new Node(value);
        var crr = head;
        if (head == null)
            return newNode;
        while (crr.next != null) {
            crr = crr.next;
        }
        crr.next = newNode;

        return head;
    }

    public static Node deleteFirst(Node head, int value) {
        
        if(head==null) return null;
        head = head.next;
        return head;
    }

    public static int[] toArray(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.value);
            head=head.next;
        }
        int arr[] = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return arr;
    }
}
