package jianzhi;

/*
 * 树的子结构
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * */

// 首先得搞清楚子结构的定义，当存在roo1一个节点与root2.val相等时，递归其左右子节点进行比较，若都相等，则为子结构。
public class Q17_HasSubtree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return judgeSubtree(root1, root2) ||
                judgeSubtree(root1.left, root2) ||
                judgeSubtree(root1.right, root2);
    }

    public boolean judgeSubtree(TreeNode root1, TreeNode root2) {
        if(root2 == null) return true;
        if(root1 == null) return false;
        if(root1.val != root2.val) {
            return judgeSubtree(root1.left, root2) ||
                    judgeSubtree(root1.right, root2);
        }
        return judgeSubtree(root1.left, root2.left) && judgeSubtree(root1.right, root2.right);
    }

}
