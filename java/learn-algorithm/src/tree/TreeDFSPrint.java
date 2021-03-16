package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * zbj: created on 2021/2/21 11:49.
 * 层序输出
 */
public class TreeDFSPrint {

    public static void main(String[] args) {
        TreeDFSPrint tree = new TreeDFSPrint();

        int[] arr = {4, 2, 7, 1, 3, 6, 9};
        for (int i : arr) {
            Node node = new Node(i);
            tree.add(node);
        }

        List<Integer> list = tree.inorderTraversal(tree.root);
        System.out.println(list);


        List<Integer> list1 = tree.stackInfixOrder(tree.root);
        System.out.println(list1);

    }

    public Node root;

    //栈方式
    public List<Integer> stackInfixOrder(Node root) {
        if (root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.id);
                cur = cur.right;
            }
        }
        return list;
    }

    // 递归方式
    public List<Integer> inorderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        infixOrder(root, list);
        return list;
    }

    public void infixOrder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            infixOrder(root.left, list);
        }
        list.add(root.id);
        if (root.right != null) {
            infixOrder(root.right, list);
        }
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
