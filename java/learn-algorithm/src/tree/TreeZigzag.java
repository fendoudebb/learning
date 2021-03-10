package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * zbj: created on 2021/2/21 16:41.
 */
public class TreeZigzag {

    public static void main(String[] args) {
        TreeZigzag tree = new TreeZigzag();
        Node node3 = new Node(3);
        Node node9 = new Node(9);
        Node node20 = new Node(20);
        Node node15 = new Node(15);
        Node node7 = new Node(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        tree.root = node3;


        tree.bfsR(tree.root, 0);
        System.out.println(tree.levelList);
    }

    public Node root;

    private List<List<Integer>> levelList = new ArrayList<>();

    public void bfsR(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level >= levelList.size()) {
            levelList.add(new ArrayList<>());
        }
        // %2 判断奇偶层
        if (level % 2 == 0) {//第奇数层（从1开始计算层高），从头部开始加
            levelList.get(level).add(root.id);
        } else { // 第偶数层，从尾部开始加
            levelList.get(level).add(0, root.id);
        }
        bfsR(root.left, level + 1);
        bfsR(root.right, level + 1);
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
