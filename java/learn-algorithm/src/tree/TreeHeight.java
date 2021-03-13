package tree;

/**
 * zbj: created on 2021/2/21 11:05.
 */
public class TreeHeight {

    public static void main(String[] args) {
        TreeHeight tree = new TreeHeight();
        Node node1 = new Node(3);
        Node node2 = new Node(9);
        Node node3 = new Node(20);
        Node node4 = new Node(15);
        Node node5 = new Node(7);
        /*tree.add(node1);
        tree.add(node2);
        tree.add(node3);
        tree.add(node4);
        tree.add(node5);*/
//        System.out.println(tree.root.id);
//        System.out.println(tree.height(tree.root));

        tree.root = node1;
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(tree.height(tree.root));
    }

    public Node root;

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void add(Node node) {
        root = add(root, node);
    }

    private Node add(Node root, Node node) {
        if (root == null) {
            return node;
        }
        if (root.id > node.id) {
            root.left = add(root.left, node);
        } else {
            root.right = add(root.right, node);
        }
        return root;
    }

    private static class Node {
        public int id;
        public Node left;
        public Node right;

        public Node(int id) {
            this.id = id;
        }
    }

}
