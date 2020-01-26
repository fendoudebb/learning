package queue;

/**
 * 环形数组队列
 * tail占用额外的数组一个空间
 * 即：若数组初始化长度为8，则认为7已经是满了
 */
public class CircleArrayQueue2 {
    public static void main(String[] args) {
        CircleArrayQueue2 circleArrayQueue2 = new CircleArrayQueue2(3);
        circleArrayQueue2.push(1);
        circleArrayQueue2.push(2);
        circleArrayQueue2.push(3);
        circleArrayQueue2.show();
        circleArrayQueue2.pull();
        circleArrayQueue2.show();
        circleArrayQueue2.push(4);
        circleArrayQueue2.show();
    }

    private int head;
    private int tail;
    private int[] arr;
    private int size;

    public CircleArrayQueue2(int size) {
        this.size = size;
        arr = new int[size];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    public void push(int n) {
        if (isFull()) {
            System.out.printf("队列已满=%d，无法加入: %d\n", curSize(), n);
            return;
        }
        arr[tail] = n;
        tail = (tail + 1) % size;
        System.out.printf("push: current head=%d, tail=%d, push-data=%d\n", head, tail, n);
    }

    public void pull() {
        if (isEmpty()) {
            System.out.printf("队列为空=%d，无法读取\n", curSize());
            return;
        }
        int i = arr[head];
        head = (head + 1) % size;
        System.out.printf("pull: current head=%d, tail=%d, pull-data=%d\n", head, tail, i);
    }

    /**
     * 下标：i % size， 是根据head下标而来，因为环形，所以取模。
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("------show but empty------");
            return;
        }
        for (int i = head; i < head + curSize(); i++) {
            System.out.printf("show: arr[%d]=%d", i % size, arr[i % size]);
            System.out.println();
        }
    }

    /**
     * 若不是环形，则可直接tail-head，但因为是环形所以计算tail与head差时需考虑tail下标比head下标小的问题
     */
    public int curSize() {
        return (tail + size - head) % size;
    }
}
