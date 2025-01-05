import java.util.Stack;

// import AVL.Node;

class DFS {
    class Node {
        int val;
        Node left;
        Node right;
    
        // Constructor to initialize the node with a value
        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    
    }


    void dfsStack(Node node) {
        if(node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            Node removed = stack.pop();
            System.out.println(removed.val + " ");
            if(removed.right != null) {
                stack.push(removed.right);
            }
            if(removed.left != null) {
                stack.push(removed.left);
            }
        }
    }
} 