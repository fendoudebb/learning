package tree;

public class AVLTree {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
//        int[] arr = {4, 3, 6, 5, 7, 8}; // 左旋
//        int[] arr = {10, 12, 8, 9, 7, 6}; // 右旋
        int[] arr = {10, 11, 7, 6, 8, 9}; // 双旋
        for (int i : arr) {
            Node node = new Node(i);
            tree.add(node);
        }

        tree.printNode();

        System.out.println("-------------");

        System.out.println("tree height#" + tree.height());

        System.out.println("tree root#" + tree.root.id);
        System.out.println("tree root left#" + tree.root.left.id);
        System.out.println("tree root right#" + tree.root.right.id);
        System.out.println("tree leftHeight#" + tree.root.leftHeight());
        System.out.println("tree rightHeight#" + tree.root.rightHeight());

    }

    public Node root;

    public void add(Node n) {
        root = add(root, n);
    }

    public Node add(Node rootNode, Node n) {
        if (rootNode == null) {
            return n;
        }
        if (rootNode.id > n.id) { // 放左边
            rootNode.left = add(rootNode.left, n);
        } else { // 放右边
            rootNode.right = add(rootNode.right, n);
        }

        if (rootNode.rightHeight() - rootNode.leftHeight() > 1) {
            if (rootNode.right != null && rootNode.right.leftHeight() > rootNode.right.rightHeight()) {
                rootNode.right = rightRotate(rootNode.right);
            }
            rootNode = leftRotate(rootNode);
        } else if (rootNode.leftHeight() - rootNode.rightHeight() > 1) {
            if (rootNode.left != null && rootNode.left.rightHeight() > rootNode.left.leftHeight()) {
                rootNode.left = leftRotate(rootNode.left);
            }
            rootNode = rightRotate(rootNode);
        }
        return rootNode;
    }

    public Node leftRotate(Node n) {
        Node x = n.right;
        n.right = x.left;
        x.left = n;
        return x;
    }

    public Node rightRotate(Node n) {
        Node x = n.left;
        n.left = x.right;
        x.right = n;
        return x;
    }

    public int height() {
        return this.root.height();
    }

    public void printNode() {
        root.infixOrder();
    }

    private static class Node {
        public int id;
        public Node left;
        public Node right;

        public Node(int id) {
            this.id = id;
        }

        public int height() {
            int leftHeight;
            if (this.left == null) {
                leftHeight = 0;
            } else {
                leftHeight = this.left.height();
            }


            int rightHeight;
            if (this.right == null) {
                rightHeight = 0;
            } else {
                rightHeight = this.right.height();
            }
            return Math.max(leftHeight + 1, rightHeight + 1);
        }

        public int leftHeight() {
            if (this.left == null) {
                return 0;
            } else {
                return this.left.height();
            }
        }

        public int rightHeight() {
            if (this.right == null) {
                return 0;
            } else {
                return this.right.height();
            }
        }

        public void infixOrder() {
            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.println("node id#" + this.id);
            if (this.right != null) {
                this.right.infixOrder();
            }
        }

    }

}


