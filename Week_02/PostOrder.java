public class PostOrder {
    /**
     * 后序遍历：左-右-根
     *
     * 这题我也想到了后序和前序顺序差不多相反，解题方法应该和前序差不多，可编码能力还是不够，仍需练习
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.addFirst(node.val);//根
            if(node.left != null) {
                stack.add(node.left);
            }
            if(node.right != null) {
                stack.add(node.right);
            }
        }
        return res;
    }
}