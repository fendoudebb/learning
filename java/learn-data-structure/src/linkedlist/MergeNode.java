package linkedlist;

/**
 * 合并两个有序的单链表，合并之后的链表依然有序
 */
public class MergeNode {

    //TODO merge
    public HeroNode merge(HeroNode node1, HeroNode node2) {
        HeroNode newNode;
        HeroNode current;
        if (node1.no < node2.no) {
            newNode = node1;
            current = node1;
            node1 = node1.next;
        } else {
            newNode = node2;
            current = node2;
            node2 = node2.next;
        }

        while (node1 != null && node2 != null) {
            if (node1.no < node2.no) {
                current.next = node1;
                current = current.next;
                node1 = node1.next;
            } else {
                current.next = node2;
                current = current.next;
                node2 = node2.next;
            }
        }

        if (node1 != null) {
            current.next = node1;
        }

        if (node2 != null) {
            current.next = node2;
        }
        return newNode;
    }

    public static void main(String[] args) {
        SingleLinkedListWithoutHead node1 = new SingleLinkedListWithoutHead();
        node1.addNode(new HeroNode(10, "宋江10", "及时雨"));
        node1.addNode(new HeroNode(30, "卢俊义30", "玉麒麟"));
        node1.addNode(new HeroNode(50, "吴用50", "智多星"));

        SingleLinkedListWithoutHead node2 = new SingleLinkedListWithoutHead();
        node2.addNode(new HeroNode(20, "宋江20", "及时雨"));
        node2.addNode(new HeroNode(40, "卢俊义40", "玉麒麟"));
        node2.addNode(new HeroNode(60, "吴用60", "智多星"));

        MergeNode mergeNode = new MergeNode();
        HeroNode merge = mergeNode.merge(node1.getHead(), node2.getHead());

        HeroNode heroNode = new HeroNode(1, "aaa", "bbb");
        HeroNode h1 = heroNode;
        HeroNode h2 = heroNode;
        h2.next = new HeroNode(3, "ccc", "ddd");
    }

}
