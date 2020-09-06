class Solution {

    /**
     * 开始做的时候发现和最小基因变化有点像，就那样写了，后来看了题解才发现数据是图，
     * 和那题的区别就在于一次替换中可能产生两个节点
     *
     * 这题老外还有个没用队列，用set解出来的，时间快了三倍
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        Set<String> sendSet = new HashSet<>();
        sendSet.add(endWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curStr = queue.poll();
                char[] arr = curStr.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newStr = new String(arr);

                        if (wordSet.contains(newStr)) {
                            if (newStr.equals(endWord)) {
                                return count + 1;
                            }
                            if (!visited.contains(newStr)) {
                                queue.add(newStr);
                                visited.add(newStr);
                            }
                        }
                    }
                    arr[i] = old;
                }
            }
            count++;
        }
        return 0;
    }
}