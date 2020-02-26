package jianzhi;

/*
* 二叉树的镜像
*
* 操作给定的二叉树，将其变换为源二叉树的镜像。
* 输入描述:
二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 * */
public class Q18_Mirror {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    // 交换当前节点的左右子节点，递归调用函数获取子节点作为根节点，递归终止条件为root==null
    public void mirror(TreeNode root) {
        if(root == null) return;
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        mirror(root.left);
        mirror(root.right);
    }
}

