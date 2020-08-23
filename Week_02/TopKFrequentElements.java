public class TopKFrequentElements {

    /**
     * 对map按照value排序，使用堆简单效
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->(map.get(o2) - map.get(o1)));
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],0);
            }
            map.put(nums[i],map.get(nums[i]) + 1);
        }
        for (Integer num : map.keySet()) {
            queue.add(num);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

}