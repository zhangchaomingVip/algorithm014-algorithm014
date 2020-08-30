public class ValidateBinarySearchTree {

    /**
     * 思路:
     * 逐层向下比较，任意一层不符合返回false
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    /**
     *
     * @param root 当前节点
     * @param low   上界限
     * @param up    下界
     * @return
     */
    public boolean helper (TreeNode root, Integer low, Integer up) {
        //终止条件
        if (root == null) return true;
        if (low != null && root.val <= low) return false;
        if (up != null && root.val >= up) return false;
        //左子树，把当前节点作为上界，带入下一层
        if (!helper(root.left,low,root.val)) return false;
        //右子树，当前节点作为下界
        if (!helper(root.right,root.val,up)) return false;
        return true;
    }
}