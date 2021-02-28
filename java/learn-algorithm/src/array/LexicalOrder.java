package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * zbj: created on 2021/2/27 15:40.
 */
public class LexicalOrder {

    public static void main(String[] args) {
        LexicalOrder lexicalOrder = new LexicalOrder();
        List<Integer> integers = lexicalOrder.lexicalOrder2(13);
        System.out.println(integers);
    }

    public List<Integer> lexicalOrder1(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        Collections.sort(list);

        ArrayList<Integer> integers = new ArrayList<>();
        for (String s : list) {
            integers.add(Integer.valueOf(s));
        }
        return integers;
    }

    public List<Integer> lexicalOrder2(int n) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= 9; i++) {
            // list=empty, n=13, i=1
            dfs(list, n, i);
        }
        return list;
    }

    public boolean dfs(List<Integer> list, int n, int target) {
        // target=1 < n=13
        if (target > n) {
            return false;
        }
        // list={1}
        list.add(target);

        // target=10
        target *= 10;

        // 10 11 12 ... 19
        for (int i = 0; i <= 9; i++) {
            // list={1}, n=13, target+i=10+1=11
            if (!dfs(list, n, target + i)) {
                break;
            }
        }
        return true;
    }

}
