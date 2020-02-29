package jianzhi;

/*
 * 平衡二叉树
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * */
public class Q39_IsBalanced {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    // 在递归计算树深度时，分别比较子树的高度，若高度差>1，则不为平衡二叉树，返回-1。
    public boolean isBalanced_Solution(TreeNode root) {
        return treeDepth(root) != -1;
    }

    public int treeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        if (right == -1 || left == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        else return 1 + (left > right ? left : right);
    }
}
