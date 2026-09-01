import java.util.Scanner;

public class TreeDemo {
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

        if (root == null) {
            return new Node(no);
        }
        if (root.left == null) {
            root.left = new Node(no);
        }
        else if (root.right == null) {
            root.right = new Node(no);
        }

        else {
            add(root.left, no);
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