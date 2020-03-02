package jianzhi;

/*
* 二叉搜索树的第k个节点
*
* 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
* */
public class Q61_KthNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    int index = 0;
    // 中序遍历树，返回第k个节点
    TreeNode kthNode(TreeNode pRoot, int k) {

    }


}
