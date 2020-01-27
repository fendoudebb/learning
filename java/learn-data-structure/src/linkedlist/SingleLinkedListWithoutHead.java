package linkedlist;

/**
 * 单向链表
 * 带头节点
 */
public class SingleLinkedListWithoutHead {

    private HeroNode head = null;

    public HeroNode getHead() {
        return head;
    }

    public void addNode(HeroNode node) {
        if (head == null) {
            head = node;
            return;
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    public void show() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        while (true) {
            System.out.println(temp.toString());
            if (temp.next == null) {
                return;
            }
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        SingleLinkedListWithoutHead singleLinkedListWithoutHead = new SingleLinkedListWithoutHead();
        singleLinkedListWithoutHead.addNode(new HeroNode(1,"宋江","及时雨"));
        singleLinkedListWithoutHead.addNode(new HeroNode(2,"卢俊义","玉麒麟"));
        singleLinkedListWithoutHead.addNode(new HeroNode(3,"吴用","智多星"));
        singleLinkedListWithoutHead.show();
    }

}


