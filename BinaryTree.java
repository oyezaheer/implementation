import java.util.Scanner;

public class BinaryTree {
    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

    }
    private Node root;

    public void populate(Scanner scanner) {
        System.out.println("Enter the root: " );
        int value = scanner.nextInt();
        root = new Node(value);
        populate( scanner , root);
    }

    private void populate(Scanner scanner, Node node){
        System.out.println("left : " + node.value);
        boolean left = scanner.nextBoolean();
        if(left) {
            System.out.println("Enter the value of left "+node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("right : " + node.value);
        boolean right = scanner.nextBoolean();
        if(right) {
            System.out.println("Enter the value of right " + node.right);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, root.right);
        }
    }
}
