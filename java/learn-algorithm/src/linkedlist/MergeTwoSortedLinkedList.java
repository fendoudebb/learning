package linkedlist;

/**
 * zbj: created on 2021/2/21 21:04.
 */
public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        Node node11 = new Node(-2);
        Node node12 = new Node(5);
        node11.next = node12;

        Node node21 = new Node(-9);
        Node node22 = new Node(-6);
        Node node23 = new Node(-3);
        Node node24 = new Node(-1);
        Node node25 = new Node(1);
        Node node26 = new Node(6);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;
        node25.next = node26;


        Node node = mergeTwoList(node11, node21);
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.id + " ");
            temp = temp.next;
        }

    }

    public static Node mergeTwoList(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        Node dummyHead = new Node(0);
        dummyHead.next = node1;
        Node cur1 = dummyHead;
        Node cur2 = node2;
        while (true) {
            if (cur1.next == null) {
                cur1.next = cur2;
                break;
            }
            if (cur2 == null) {
                break;
            }
            if (cur1.next.id < cur2.id) {
                cur1 = cur1.next;
            } else {
                Node temp = cur2.next;
                cur2.next = cur1.next;
                cur1.next = cur2;
                cur1 = cur2; // node1指针移动到新插入的节点
                cur2 = temp; // node2指针移动到原先列表的下一个节点
            }
        }
        return dummyHead.next;
    }


    private static class Node {
        public int id;
        public Node next;

        public Node(int id) {
            this.id = id;
        }
    }
}
