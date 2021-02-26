package string;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abba";

        int i = lengthOfLongestSubstring(s);
        System.out.println(i);

    }

    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }

        int longestCount = 0;
        int start = 0; // 开始位置指针
        for (int i = 0; i < s.length(); i++) {
            int charAscii = s.charAt(i);
            int index = last[charAscii];// 字符上一次出现的位置，没出现过就是-1
            if (index != -1) {// 如果出现过，开始位置指针指向上一次出现的位置的下一位
                // 如：dvdf，第一次d出现在第0位，所以最长子串开始计算的索引就是0，但当第二个d出现了，所以有重复了，最长子串的计算计算的索引也要往后移一位，从v开始计算。
                // 如：abba，第一次a出现在第0位，但当第二个d出现时，索引往后移一位就要比较原先记录的start即b的下一位索引大还是a的下一位索引大。
//                start = index + 1;
                start = Math.max(start, index + 1);
            }
            longestCount = Math.max(longestCount, i - start + 1);
            last[charAscii] = i;
        }

        return longestCount;
    }

}
