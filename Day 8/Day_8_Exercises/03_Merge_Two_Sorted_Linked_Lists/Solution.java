import java.util.ArrayList;

public class Solution {
    static class Node {
        int value; Node next;
        Node(int value) { this.value = value; }
    }

    public static Node merge(Node a, Node b) { 
        if(a==null) return b;
        else if (b==null) return a; 
        Node temp = new Node(-99);
        Node currNode = temp;
         
        while(a!=null && b!=null){
            if(a.value<b.value){
                currNode.next = a;
                a=a.next;
                currNode=currNode.next;
            }else{
                currNode.next = b;
                b=b.next;
                currNode=currNode.next;
            }
        }
            if(a==null&b!=null) currNode.next = b;
            else if(b==null&a!=null) currNode.next = a;

        return temp.next; 
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
