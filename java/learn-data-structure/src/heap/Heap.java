package heap;

import java.util.Arrays;

public class Heap {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        System.out.println(Arrays.toString(heap.array));

        System.out.println(heap.deleteMax());
        System.out.println(heap.deleteMax());
        System.out.println(heap.deleteMax());
        System.out.println(heap.deleteMax());
        System.out.println(heap.deleteMax());
        System.out.println(heap.deleteMax());
        System.out.println(heap.deleteMax());

    }

    public int[] array;

    public int n;

    public Heap(int cap) {
        array = new int[cap + 1];// 第 0 位空出
    }

    public void add(int num) {
        array[++n] = num;// 跳过第0位，从第1位开始加
        swim(n);
    }

    public void swim(int k) {
        while (k > 1) {
            if (array[k] > array[k / 2]) {
                exchange(k, k / 2);
                k = k / 2;
            } else {
                break;
            }
        }
    }

    public int deleteMax() {
        int max = array[1];
        exchange(1, n);
        array[n] = 0;
        n--;
        sink(1);
        return max;
    }

    public void sink(int k) {
        while (2 * k <= n) {
            int indexOfMax;

            if (array[2 * k] > array[2 * k + 1]) {
                indexOfMax = 2 * k;
            } else {
                indexOfMax = 2 * k + 1;
            }
            if (array[k] > array[indexOfMax]) {
                break;
            }
            exchange(k,indexOfMax);
        }
    }

    private void exchange(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
