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

    int index = 1;
    TreeNode kthnode = new TreeNode(Integer.MIN_VALUE);

    // Solu1: 中序遍历树，返回第k个节点
    TreeNode kthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        if (kthnode.val == Integer.MIN_VALUE) return null;
        else return kthnode;
    }

    void inOrder(TreeNode treeNode, int k) {
        if (treeNode == null) return;
        inOrder(treeNode.left, k);
        if (index == k) kthnode = treeNode;
        index++;
        inOrder(treeNode.right, k);
    }

    // Solu2: 找到二叉搜索树的最小节点，再循环找到其k-1个后继节点
    TreeNode kthNode2(TreeNode pRoot, int k) {
        TreeNode minTreeNode = pRoot, resultTreeNode = null;
        while (minTreeNode.left != null) {
            minTreeNode = minTreeNode.left;
        }
        resultTreeNode = minTreeNode;
        while (index < k) {
            resultTreeNode = succesor(resultTreeNode);
            index++;
        }
        return resultTreeNode;
    }

    // 后继节点
    TreeNode succesor(TreeNode treeNode) {
        TreeNode succesorNode = treeNode;
        if (treeNode.right != null) {
            succesorNode = treeNode.right;
            while (succesorNode.left != null) succesorNode = succesorNode.left;
        } else {
            TreeNode parentNode = parent(succesorNode);
            while(parentNode!=null && succesorNode == parentNode.right){
                succesorNode = parentNode;
                parentNode = parent(succesorNode);
            }
            succesorNode = parent(succesorNode);
        }
        return succesorNode;
    }

    // 找到当前节点的父节点
    TreeNode parent(TreeNode treeNode) {
        return treeNode;
    }


}
