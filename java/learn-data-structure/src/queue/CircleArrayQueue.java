package queue;

/**
 * 环形数组队列
 * tail不占据额外的一个数组空间
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(3);
        circleArrayQueue.pull();
        circleArrayQueue.push(1);
        circleArrayQueue.push(2);
        circleArrayQueue.push(3);
        circleArrayQueue.show();
        circleArrayQueue.pull();

        circleArrayQueue.pull();
        circleArrayQueue.pull();
        circleArrayQueue.show();
        circleArrayQueue.push(4);
        circleArrayQueue.show();
    }

    private int head;
    private int tail;
    private int size;
    private int[] arr;
    private int curSize;

    public CircleArrayQueue(int size) {
        this.size = size;
        arr = new int[size];
    }

    public boolean isEmpty() {
        return curSize == 0;
    }

    public boolean isFull() {
        return size == curSize;
    }

    public void push(int n) {
        if (isFull()) {
            System.out.printf("队列已满=%d，无法加入: %d\n", curSize, n);
            return;
        }
        curSize++;
        arr[tail] = n;
        tail = (tail + 1) % size;
        System.out.printf("push: current head=%d, tail=%d, push-data=%d\n", head, tail, n);
    }

    public void pull() {
        if (isEmpty()) {
            System.out.printf("队列为空=%d，无法读取\n", curSize);
            return;
        }
        curSize--;
        int i = arr[head];
        head = (head + 1) % size;
        System.out.printf("pull: current head=%d, tail=%d, pull-data=%d\n", head, tail, i);
    }

    public int peek() {
        return arr[head];
    }

    public void show() {
        if (curSize == 0) {
            System.out.println("------show but empty------");
            return;
        }
        for (int i = 0; i < curSize; i++) {
            System.out.printf("show: arr[%d]=%d", (head + i) % size, arr[(head + i) % size]);
            System.out.println();
        }
    }
}

