import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    static class Node {
        int value; Node next;
        Node(int value) { this.value = value; }
    }

    public static Node reverse(Node head) { 
        Stack<Integer> sc = new Stack<>();
        var curr = head;
        while (curr!=null) {
            sc.push(curr.value);
            curr=curr.next;
        }
        curr=head;
        while (curr!=null) {
            curr.value = sc.pop();
            curr=curr.next;
        }
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
