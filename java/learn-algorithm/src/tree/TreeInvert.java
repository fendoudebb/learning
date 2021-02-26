package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * zbj: created on 2021/2/21 16:01.
 * 翻转二叉树的左右节点
 */
public class TreeInvert {

    public static void main(String[] args) {
        TreeInvert tree = new TreeInvert();
        int[] arr = {4, 2, 7, 1, 3, 6, 9};
        for (int i : arr) {
            Node node = new Node(i);
            tree.add(node);
        }

//        tree.invertR(tree.root);
        tree.invertBfs(tree.root);

        System.out.println(tree.root.id);
        System.out.println(tree.root.left.id);
        System.out.println(tree.root.right.id);
        System.out.println(tree.root.left.left.id);
        System.out.println(tree.root.left.right.id);
        System.out.println(tree.root.right.left.id);
        System.out.println(tree.root.right.right.id);
    }

    public Node root;

public Node invertBfs(Node root) {
    if (root == null) {
        return null;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        Node node = queue.poll();
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }

    }
    return root;
}

    public Node invertR(Node root) {
        if (root == null) {
            return null;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertR(root.left);
        invertR(root.right);
        return root;
    }

    public void add(Node node) {
        root = add(root, node);
    }

    public Node add(Node rootNode, Node node) {
        if (rootNode == null) {
            return node;
        }
        if (rootNode.id > node.id) {
            rootNode.left = add(rootNode.left, node);
        } else {
            rootNode.right = add(rootNode.right, node);
        }
        return rootNode;
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
