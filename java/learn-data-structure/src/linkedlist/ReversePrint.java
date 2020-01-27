package linkedlist;

import java.util.Stack;

/**
 * 单链表反向打印
 */
public class ReversePrint {

    /**
     * 递归
     */
    public void recursionPrint(HeroNode node) {
        if (node == null) {
            return;
        }
        recursionPrint(node.next);
        System.out.println(node.toString());
    }

    /**
     * 栈
     */
    public void stackPrint(HeroNode node) {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = node.next;
        while (true) {
            stack.add(temp);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        while (stack.size() > 0) {
            HeroNode n = stack.pop();
            System.out.println(n.toString());
        }

    }

    public static void main(String[] args) {
        SingleLinkedListWithHead singleLinkedListWithHead = new SingleLinkedListWithHead();
        singleLinkedListWithHead.addNode(new HeroNode(1, "宋江", "及时雨"));
        singleLinkedListWithHead.addNode(new HeroNode(2, "卢俊义", "玉麒麟"));
        singleLinkedListWithHead.addNode(new HeroNode(3, "吴用", "智多星"));

        ReversePrint reversePrint = new ReversePrint();
        reversePrint.recursionPrint(singleLinkedListWithHead.getHead());
        System.out.println("------------------------------------------------");
        reversePrint.stackPrint(singleLinkedListWithHead.getHead());
    }

}
