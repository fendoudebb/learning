package linkedlist;

/**
 * 查找单链表倒数第K个节点
 */
public class FindLastKNode {

    public HeroNode findLastKNode(HeroNode head, int nodeLength, int k) {
        if (k > nodeLength) {
            System.out.println("倒数K超过链表总长度");
            return null;
        }
        int index = nodeLength - k;
        HeroNode kNode = head.next;
        for (int i = 0; i < index; i++) {
            kNode = kNode.next;
        }
        return kNode;
    }


    public static void main(String[] args) {
        SingleLinkedListWithHead singleLinkedListWithHead = new SingleLinkedListWithHead();
        singleLinkedListWithHead.addNode(new HeroNode(1, "宋江", "及时雨"));
        singleLinkedListWithHead.addNode(new HeroNode(2, "卢俊义", "玉麒麟"));
        singleLinkedListWithHead.addNode(new HeroNode(3, "吴用", "智多星"));
        System.out.println(singleLinkedListWithHead.getNodeLength());

        FindLastKNode findLastKNode = new FindLastKNode();

        HeroNode lastKNode = findLastKNode.findLastKNode(singleLinkedListWithHead.getHead(), singleLinkedListWithHead.getNodeLength(), 1);
        System.out.println(lastKNode);
    }

}
