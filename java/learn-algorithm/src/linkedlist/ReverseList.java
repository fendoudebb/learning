package linkedlist;

import java.util.HashMap;

/**
 * zbj: created on 2021/2/22 20:07.
 */
public class ReverseList {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ReverseList reverseList = new ReverseList();
        Node node = reverseList.reverseList(node1);
        System.out.println(node.id);
        System.out.println(node.next.id);
        System.out.println(node.next.next.id);
        System.out.println(node.next.next.next.id);
        System.out.println(node.next.next.next.next.id);



        String s = new StringBuffer("ja").append("va").toString();
        System.out.println(s == s.intern());
        String a = "java";
        String b = new String("java");
        System.out.println(a == "java");
        System.out.println(a == s);
        System.out.println(b == s);
        System.out.println(b == a); // false

        System.out.println(tableSizeFor(3));

        HashMap<String, String> map = new HashMap<>();

        map.put(null, "123");
        map.put(null, "456");
        System.out.println(map);

    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node cur = head;
        Node dummyHead = new Node(0);

        while (cur != null) {
            Node next = cur.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
            cur = next;
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
