import java.util.Scanner;


public class LinkedListDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean add = true;
        SinglyLinkedlistNode head =null;
        while (add) {
            System.out.println("enter the value to be added to LL");
            int val = sc.nextInt();
            head = SinglyLinkedlistNode.insertEnd(head, val);
            System.out.println("press 1 to continue adding ");
            add = sc.nextInt()==1; 
        }
        var temp = head;
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        sc.close();
    }
    
}

class SinglyLinkedlistNode {
    int data ;
    SinglyLinkedlistNode next;

    SinglyLinkedlistNode(int data){this.data = data; next=null; }
    SinglyLinkedlistNode(int data,SinglyLinkedlistNode next){
        this.data = data;
        this.next=next; 
    }

    static SinglyLinkedlistNode insertBegining(SinglyLinkedlistNode head,int data){
        SinglyLinkedlistNode newNode = new SinglyLinkedlistNode(data, head);
        return newNode;
    }
    static SinglyLinkedlistNode insertEnd(SinglyLinkedlistNode head , int data){
        if(head==null) return new SinglyLinkedlistNode(data);
        var currNode = head;
        while (currNode.next!=null) {
            currNode=currNode.next;
        }
        currNode.next = new SinglyLinkedlistNode(data);
        return head;
    }
}
