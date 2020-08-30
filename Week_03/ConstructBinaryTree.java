public class ConstructBinaryTree{

    /**
     * 思路：
     * 1.先序遍历得到根节点
     * 2.中序遍历结果中，根节点之前的为左节点
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    /**
     *
     * @param preorder 先序数组
     * @param p_start  先序遍历起点
     * @param p_end 先序遍历终点
     * @param inorder   中序遍历数组
     * @param i_start
     * @param i_end
     * @return
     */
    public TreeNode helper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        //终止条件
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //中序遍历寻找根位置
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (inorder[i] == root_val) {
                i_root_index = i;
            }
        }
        //计算左子树个数
        int leftNum = i_root_index - i_start;
        //注意一下左右起点
        root.left = helper(preorder, p_start + 1, p_start + leftNum + 1,inorder,i_start ,i_root_index);
        root.right = helper(preorder, p_start + leftNum + 1, p_end, inorder,i_root_index + 1,i_end);
        return root;
    }
}