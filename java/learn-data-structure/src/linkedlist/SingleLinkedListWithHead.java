package linkedlist;

/**
 * 单向链表
 * 带头节点
 */
public class SingleLinkedListWithHead {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void addNode(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    public void addNodeByOrder(HeroNode node) {
        HeroNode temp = head;
        boolean isExist = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                System.out.println("已存在node=" + node.no);
                isExist = true;
                break;
            }
            temp = temp.next;
        }
        if (!isExist) {
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void deleteNode(int no) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    public void modifyNode(HeroNode node) {
        HeroNode temp = head;
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
        HeroNode temp = head;
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
        HeroNode temp = head;
        while (temp.next != null) {
            System.out.println(temp.next.toString());
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedListWithHead singleLinkedListWithHead = new SingleLinkedListWithHead();
        singleLinkedListWithHead.addNode(new HeroNode(1,"宋江","及时雨"));
        singleLinkedListWithHead.addNode(new HeroNode(2,"卢俊义","玉麒麟"));
        singleLinkedListWithHead.addNode(new HeroNode(3,"吴用","智多星"));
        singleLinkedListWithHead.show();
        System.out.println("-----------------------------");
        singleLinkedListWithHead.deleteNode(2);
        singleLinkedListWithHead.deleteNode(1);
        singleLinkedListWithHead.show();
        System.out.println("-----------------------------");
        singleLinkedListWithHead.modifyNode(new HeroNode(3, "小吴", "智慧多"));
        singleLinkedListWithHead.show();
        System.out.println("-----------------------------");
        singleLinkedListWithHead.addNodeByOrder(new HeroNode(1,"宋江","及时雨"));
        singleLinkedListWithHead.addNodeByOrder(new HeroNode(2,"卢俊义","玉麒麟"));
        singleLinkedListWithHead.show();
    }

}


