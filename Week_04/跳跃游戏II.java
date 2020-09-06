class Solution {

    /**
     * 每一步都取能到最远的为最优
     *  时间复杂度：O(n)
     *  空间复杂度：O(1)
     *
     *  [1,1,1,1,1]
     * i = 0  max = 1   step = 1
     * i = 1  max = 2   step = 2
     * i = 2  max = 3   step = 3
     * i = 3  max = 4   step = 4    return 4
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int end = 0;
        int max = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            //下面这个更新边界值是个神操作
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }
}