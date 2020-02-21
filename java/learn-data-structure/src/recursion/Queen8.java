package recursion;

import java.text.ParseException;

/**
 * 八皇后问题
 * 回溯算法
 */
public class Queen8 {
    private int max = 8;
    private int[] arr = new int[max];

    public static void main(String[] args) throws ParseException {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
    }

    public void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if ((arr[i] == arr[n]) || (Math.abs(n - i) == Math.abs(arr[n] - arr[i]))) {
                return false;
            }
        }
        return true;

    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
