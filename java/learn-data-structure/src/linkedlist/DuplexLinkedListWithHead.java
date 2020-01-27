package linkedlist;

/**
 * 双向链表
 */
public class DuplexLinkedListWithHead {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void addNode(HeroNode2 node) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                node.prev = temp;
                break;
            }
            temp = temp.next;
        }
    }

    public void deleteNode(int no) {
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                temp.next = temp.prev.next;
                if (temp.next != null) {
                    temp.prev = temp.next.prev;
                }
            }
            temp = temp.next;
        }
    }

    public void modifyNode(HeroNode2 node) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == node.no) {
                temp.next.name = node.name;
                temp.next.nickname = node.nickname;
            }
            temp = temp.next;
        }
    }

    public int getNodeLength() {
        HeroNode2 temp = head;
        int count = 0;
        while (true) {
            if (temp.next == null) {
                break;
            }
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void show() {
        HeroNode2 temp = head;
        while (temp.next != null) {
            System.out.println(temp.next.toString());
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DuplexLinkedListWithHead duplexLinkedListWithHead = new DuplexLinkedListWithHead();
        duplexLinkedListWithHead.addNode(new HeroNode2(1,"宋江","及时雨"));
        duplexLinkedListWithHead.addNode(new HeroNode2(2,"卢俊义","玉麒麟"));
        duplexLinkedListWithHead.addNode(new HeroNode2(3,"吴用","智多星"));
    }
}
