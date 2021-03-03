package array;

public class FindKthNumber {
    public static void main(String[] args) {

        FindKthNumber findKthNumber = new FindKthNumber();
        System.out.println(findKthNumber.findKthNumber2(13, 5));


    }

    public int findKthNumber(int n, int k) {
        int prefix = 1;
        int p = 1;
        while (p < k) {
            int count = getCount(n, prefix);
            if (p + count > k) {
                prefix *= 10;
                p++;
            } else {
                prefix++;
                p += count;
            }
        }
        return prefix;

    }

    public int findKthNumber2(int n, int k) {
        int prefix = 1;
        k = k - 1;
        while (k > 0) {
            int count = getCount(n, prefix);
            if (count > k) {
                prefix *= 10;
                k--;
            } else {
                prefix++;
                k -= count;
            }
        }
        return prefix;

    }

    public int getCount(int n, int prefix) {
        int count = 0;
        for (int a = prefix, b = prefix + 1; a <= n; a *= 10, b *= 10) {
            int min = Math.min(n + 1, b);
            int step = min - a;
            count += step;
            System.out.println("n=" + n + ", b=" + b + ", min=" + min + ", a=" + a + ", min-a=" + step + ", count=" + count);
        }
        return count;
    }
}
