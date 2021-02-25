package array;

public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit2(prices));
    }

    public static int maxProfit2(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - min;
            maxProfit = Math.max(profit, maxProfit);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                }
            }
        }
        return maxProfit;
    }

}
