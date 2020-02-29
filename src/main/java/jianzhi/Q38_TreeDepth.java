package jianzhi;

/*
 * 二叉树的深度
 *
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * */
public class Q38_TreeDepth {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int treeDepth(TreeNode root) {
        if(root == null) return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left,right) + 1;
    }

}
