import java.util.Scanner;

public class BSTDemo {
        public static void main(String[] args) {

        boolean keepAdding = true;
        Node root = null;

        Scanner sc = new Scanner(System.in);

        while (keepAdding) {

            System.out.println("Enter a value to add to tree:");
            int val = sc.nextInt();

            root = Node.add(root, val);

            System.out.println("Press 1 to keep adding, 0 to stop:");
            val = sc.nextInt();

            keepAdding = val == 1;
        }

        System.out.println("\nInorder Traversal:");
        Node.inOrder(root);

        sc.close();
    }
    
}


class Node {

    int val;
    Node left, right;

    public Node(int val) {
        this.val = val;
        left = right = null;
    }

    static Node add(Node root, int no) {
        if (root == null  ) {
            return new Node(no);
        }
        if (root.val==no) {
            return root;
        } 
        if (root.val > no) {
            root.left = add(root.left, no);
        }
        else if (root.val < no) {
            root.right = add(root.right, no);
        }
        return root;
    }

    static void preOrder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + "->");

        preOrder(root.left);
        preOrder(root.right);
    }
    static void inOrder(Node root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + "->");
        inOrder(root.right);
    }
}