package stack;

/**
 * 栈：数组
 */
public class ArrayStack {
    private int maxSize;
    private int top = -1;
    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void add(int num) {
        if (isFull()) {
            System.out.println("stack is full");
            return;
        }
        top++;
        stack[top] = num;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }
        int value = stack[top];
        top--;
        System.out.printf("stack pop value=%d\n", value);
    }

    public void show() {
        for (int i = top; i >= 0; i--) {
            System.out.printf("show: stack[%d]=%d\n", i, stack[i]);
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.add(1);
        arrayStack.add(2);
        arrayStack.add(3);
        arrayStack.add(4);
        arrayStack.show();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.show();
    }


}
