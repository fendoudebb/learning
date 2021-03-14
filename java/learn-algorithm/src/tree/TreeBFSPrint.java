package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * zbj: created on 2021/2/21 11:49.
 * 层序输出
 */
public class TreeBFSPrint {

    public static void main(String[] args) {
        TreeBFSPrint tree = new TreeBFSPrint();

        int[] arr = {4, 2, 7, 1, 3, 6, 9};
        for (int i : arr) {
            Node node = new Node(i);
            tree.add(node);
        }

        System.out.println(tree.root.id);
//        System.out.println(tree.bfs(tree.root));
        tree.bfsRecursion(tree.root, 0);
        System.out.println(tree.levelList);

    }

    public Node root;

    public List<Integer> bfs(Node root) {
        if (root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            list.add(node.id);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }

    private List<List<Integer>> levelList = new ArrayList<>();

    public void bfsRecursion(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level >= levelList.size()) {
            levelList.add(new ArrayList<>());
        }
        levelList.get(level).add(root.id);
        bfsRecursion(root.left, level + 1);
        bfsRecursion(root.right, level + 1);
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
