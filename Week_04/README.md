第四周总结

BFS+DFS+贪心+二分查找

1.遍历搜索
    BFS在二叉树、N叉树层序遍历用到过，使用了队列
    DFS有递归和非递归两种写法
2.贪心算法
    每次选取最优解，达到结果最优
    典型题目：跳跃游戏II
    
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
    
3.二分搜索
    有点像猜大小，大了就往小了猜，小了就往大了猜
    典型题目：求根号
    
     public int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2 ;
            if ((long) mid * mid <= x ) {
               ans = mid; 
                left = mid + 1;
            } else {
               right = mid - 1;
            }
        }
        return ans;
    }
