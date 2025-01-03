public class SegmentTree {

    // Segment Tree Implementation
    static class segmentTree {
        private static class Node {
            int data;
            int startInterval;
            int endInterval;
            Node left;
            Node right;

            public Node(int startInterval, int endInterval) {
                this.startInterval = startInterval;
                this.endInterval = endInterval;
            }
        }

        Node root;

        public segmentTree(int[] arr) {
            this.root = constructTree(arr, 0, arr.length - 1);
        }

        private Node constructTree(int[] arr, int start, int end) {
            if (start == end) {
                Node leaf = new Node(start, end);
                leaf.data = arr[start];
                return leaf;
            }

            Node node = new Node(start, end);
            int mid = (start + end) / 2;

            node.left = this.constructTree(arr, start, mid);
            node.right = this.constructTree(arr, mid + 1, end);

            node.data = node.left.data + node.right.data;
            return node;
        }

        public void display() {
            display(this.root);
        }

        private void display(Node node) {
            String str = "";

            if (node.left != null) {
                str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ";
            } else {
                str = str + "No left child";
            }

            str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= ";

            if (node.right != null) {
                str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data;
            } else {
                str = str + "No right child";
            }

            System.out.println(str + '\n');

            if (node.left != null) {
                display(node.left);
            }

            if (node.right != null) {
                display(node.right);
            }
        }

        public int query(int qsi, int qei) {
            return this.query(this.root, qsi, qei);
        }

        private int query(Node node, int qsi, int qei) {
            if (node.startInterval >= qsi && node.endInterval <= qei) {
                return node.data;
            } else if (node.startInterval > qei || node.endInterval < qsi) {
                return 0;
            } else {
                return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
            }
        }

        public void update(int index, int value) {
            this.root.data = update(this.root, index, value);
        }

        private int update(Node node, int index, int value) {
            if (index >= node.startInterval && index <= node.endInterval) {
                if (index == node.startInterval && index == node.endInterval) {
                    node.data = value;
                    return node.data;
                } else {
                    int leftAns = update(node.left, index, value);
                    int rightAns = update(node.right, index, value);
                    node.data = leftAns + rightAns;
                    return node.data;
                }
            }
            return node.data;
        }
    }

    public static void main(String[] args) {
        // Input array
        int[] arr = {2, 5, 1, 4, 9, 3};

        // Construct the segment tree
        segmentTree st = new segmentTree(arr);

        // Display the segment tree
        System.out.println("Segment Tree Structure:");
        st.display();

        // Perform some range queries
        System.out.println("Query Results:");
        System.out.println("Sum of range [1, 3]: " + st.query(1, 3)); // Output: 10 (5+1+4)
        System.out.println("Sum of range [2, 5]: " + st.query(2, 5)); // Output: 17 (1+4+9+3)

        // Update a value
        System.out.println("\nUpdating index 2 to 6...");
        st.update(2, 6);

        // Display the segment tree after the update
        System.out.println("\nSegment Tree Structure After Update:");
        st.display();

        // Perform some range queries after the update
        System.out.println("Query Results After Update:");
        System.out.println("Sum of range [1, 3]: " + st.query(1, 3)); // Output: 15 (5+6+4)
        System.out.println("Sum of range [2, 5]: " + st.query(2, 5)); // Output: 22 (6+4+9+3)
    }
}
