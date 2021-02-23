package array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = findKthLargest2(arr, 4);
        System.out.println(Arrays.toString(arr));
        System.out.println(kthLargest);

        Arrays.sort(arr);
//        arr[arr.length-k]
    }

    public static int findKthLargest2(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : arr) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() < num) {
                queue.poll();
                queue.add(num);
            }
        }
        return queue.peek();
    }

    public static int findKthLargest(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            // 一次都没交换，说明已经有序
            if (!flag) {
                break;
            }
            // 第k次排序后，末尾的几个元素已经有序
            count++;
            if (count >= k) {
                break;
            }
        }
        return arr[arr.length - k];
    }

}
