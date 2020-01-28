package stack;

/**
 * 栈：单向链表
 */
public class LinkedListStack {
    private Node node = null;

    public Node getNode() {
        return node;
    }

    public void add(Node node) {
        Node temp = this.node;
        if (temp == null) {
            this.node = node;
            return;
        }
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    public void pop() {
        if (node == null) {
            System.out.println("node is null");
            return;
        }
        if (node.next == null) {
            node = null;
            return;
        }
        Node temp = node;
        while (true) {
            if (temp.next.next == null) {
                temp.next = null;
                break;
            }
            temp = temp.next;
        }
    }

    public void show(Node node) {
        if (node == null) {
            return;
        }
        show(node.next);
        System.out.printf("node=%d\n", node.no);
    }

    static class Node {
        public int no;
        public Node next;

        public Node(int no) {
            this.no = no;
        }
    }

    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.add(new Node(1));
        linkedListStack.add(new Node(2));
        linkedListStack.add(new Node(3));
        linkedListStack.show(linkedListStack.getNode());
        linkedListStack.pop();
        linkedListStack.pop();
        System.out.println("-------------------------------------");
        linkedListStack.show(linkedListStack.getNode());

        String s = "abcdefg";
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
    }
}
