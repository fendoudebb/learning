package linkedlist;

/**
 * 单向环形链表
 * 约瑟夫环问题
 * 丢手绢问题:
 *
 * 设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，数到m 的那个人出列，
 * 它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列。
 */
public class CircleSingleLinkedList {

    private Boy first = null;

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums invalid");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.next = first;//自己成环
                curBoy = first;
            } else {
                curBoy.next = boy;
                boy.next = first;
                curBoy = boy;
            }
        }
    }

    public void countBoy(int k, int m, int nums) {
        if (first == null || k < 1 || k > nums) {
            System.out.println("params invalid");
            return;
        }
        Boy helper = first;
        while (true) {
            if (helper.next == first) {
                break;
            }
            helper = helper.next;
        }

        // helper, first 先移动k-1次, 如从第3个人开始报数，则first第移动两次，到第三个boy
        for (int i = 1; i <= k -1; i++) {
            first = first.next;
            helper = helper.next;
        }

        while (true) {
            if (helper == first) {
                break;
            }
            for (int i = 1; i <= m - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.printf("小孩=%d 出圈\n", first.no);
            first = first.next;
            helper.next = first;
        }
        System.out.printf("最后留在小圈的小孩=%d\n", first.no);

    }

    public void show() {
        if (first == null) {
            System.out.println("first is null");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩编号=%d\n", curBoy.no);
            if (curBoy.next == first) {
                break;
            }
            curBoy = curBoy.next;
        }
    }


    static class Boy {
        public int no;
        public Boy next;

        public Boy(int no) {
            this.no = no;
        }
    }

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.countBoy(1,2,5);
    }

}
