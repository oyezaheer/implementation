class BST {
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
    private Node root;

    public BST() {

    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if(node == null) {
            node = new Node(value);
            return node;
        }

        if(value < node.value) {
            node.left = insert(value, node.left);
        }
        if(value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    public int height(Node node) {
        if(node == null) {
            return -1;
        }
        return node.height;
    }

    public void populate(int[] nums) {
        for(int i=0; i<nums.length; i++){
            this.insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums) {
        populateSorted(nums, 0 , nums.length);
    }

    public void populateSorted(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);
    }



}