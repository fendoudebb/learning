package linkedlist;

import java.util.Stack;

/**
 * zbj: created on 2021/2/22 20:46.
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode listNode = reverseKGroup.reverseKGroup(listNode1, 2);
//        Node node = reverseKGroup.reverseKGroup(node1, 2);

        System.out.println(listNode.id);
        System.out.println(listNode.next.id);
        System.out.println(listNode.next.next.id);
        System.out.println(listNode.next.next.next.id);
        System.out.println(listNode.next.next.next.next.id);

    }

    public ListNode reverseKGroup(ListNode listNode, int k) {
        int count = 0;

        ListNode dummyHead = new ListNode(0);

        ListNode insertP = dummyHead;

        ListNode cur = listNode;

        Stack<ListNode> stack = new Stack<>();

        while (cur != null) {
            ListNode next = cur.next;
            stack.push(cur);
            count++;
            if (count == k) {
                while (!stack.isEmpty()) {
                    ListNode popListNode = stack.pop();
                    // cur.next要提前保存起来，否则无法遍历完整
                    insertP.next = popListNode;
                    insertP = popListNode;
                }
                count = 0;
            }
            cur = next;
        }

        insertP.next = null;

        // 按原顺序
        while (!stack.isEmpty()) {
            ListNode popListNode = stack.pop();
            popListNode.next = insertP.next;
            insertP.next = popListNode;
        }
        return dummyHead.next;
    }


    private static class ListNode {
        public int id;
        public ListNode next;

        public ListNode(int id) {
            this.id = id;
        }
    }
}
