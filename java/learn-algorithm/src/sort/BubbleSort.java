package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, -1, 4, -2};

        sortProduce(arr);

//        bubbleSort(arr);
    }

    private static void sortProduce(int[] arr) {
        int temp;
        //第一次排序，对比前4个即可
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println("第1次排序：" + Arrays.toString(arr));

        //第二次排序，对比前3个即可
        for (int i = 0; i < arr.length - 1 - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println("第2次排序：" + Arrays.toString(arr));

        //第三次排序，对比前2个即可
        for (int i = 0; i < arr.length - 1 - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println("第3次排序：" + Arrays.toString(arr));

        //第四次排序，对比前1个即可
        for (int i = 0; i < arr.length - 1 - 3; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println("第4次排序：" + Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            // 若数组长度是5
            // 第一次排序，只需要对前4个元素进行对比即可。经过第一次排序后，数组的最后一个元素已经是最大的了
            // 第二次排序，只需要对前3个元素进行对比即可。以此类推，直到第四次排序结束，得到最后排完序的数组
            // 所以
            // 第一次排序的循环次数是`数组长度减一`次
            // 第二次排序的循环次数是`数组长度减二`次
            // 依次类推
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "次排序：" + Arrays.toString(arr));
            if (!flag) {
                break;
            }
        }
    }


}
