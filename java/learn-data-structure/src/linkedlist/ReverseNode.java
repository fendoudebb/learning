package linkedlist;

/**
 * 将单向链表反转
 *
 * @see #reverse(HeroNode)
 */
public class ReverseNode {

    public void reverse(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }

        HeroNode temp = head.next;
        HeroNode next;//指向temp的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (temp != null) {

            //第一次循环时：temp=宋江，temp.next=卢俊义
            //第二次循环时：temp=卢俊义，temp.next=吴用
            //第三次循环时：temp=吴用，temp.next=null
            next = temp.next;//先暂时保存当前节点的下一个节点，否则下一步会覆盖掉

            //第一次循环时：reverseHead.next为null, 赋值给`宋江`的next
            //第二次循环时：reverseHead.next为`宋江`, 赋值给`卢俊义`的next
            //第三次循环时：reverseHead.next为`卢俊义`, 赋值给`吴用`的next
            temp.next = reverseHead.next;//将reverse的头节点的下一个节点赋值给当前节点的下一个节点

            //第一次循环时：将`宋江`赋值给reverseHead.next
            //第二次循环时：将`卢俊义`赋值给reverseHead.next
            //第三次循环时：将`吴用`赋值给reverseHead.next
            reverseHead.next = temp;//reverse的头节点的下一个节点指向当前节点

            //第一次循环时：将`卢俊义`赋值给，准备下一次循环
            //第二次循环时：将`吴用`赋值给，准备下一次循环
            //第三次循环时：将`null`赋值给，准备下一次循环
            temp = next;//准备遍历下一个节点
        }
        //将`吴用`赋值给head.next，完成反转
        head.next = reverseHead.next;
    }

    public static void main(String[] args) {
        SingleLinkedListWithHead singleLinkedListWithHead = new SingleLinkedListWithHead();
        singleLinkedListWithHead.addNode(new HeroNode(1, "宋江", "及时雨"));
        singleLinkedListWithHead.addNode(new HeroNode(2, "卢俊义", "玉麒麟"));
        singleLinkedListWithHead.addNode(new HeroNode(3, "吴用", "智多星"));

        ReverseNode reverseNode = new ReverseNode();
        reverseNode.reverse(singleLinkedListWithHead.getHead());

        singleLinkedListWithHead.show();
    }

}
