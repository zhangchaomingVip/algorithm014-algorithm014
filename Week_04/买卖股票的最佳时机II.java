class Solution {
    /**
     * 这个题有意思的地方在于：每天都减去前一天的，赚了（差值大于0）就算入收益，很简单很巧妙
     *
     * 时间复杂度：O(n),O(1)
     *
     * [7,1,5,3,6,4]
     *
     * 5-1 =4
     * 6-3 =3
     * return 4+3 =7
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}