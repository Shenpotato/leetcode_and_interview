package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 从上往下打印二叉树
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * */
public class Q22_PrintFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 思路：利用队列进行全序遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> treeNodeList = new ArrayList<>();
        if(root == null) return treeNodeList;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();     // java中的queue使用LinkedList实现
        treeNodeQueue.add(root);
        while(!treeNodeQueue.isEmpty()){
            TreeNode tempNode = treeNodeQueue.remove();
            treeNodeList.add(tempNode.val);
            if(tempNode.left != null) treeNodeQueue.add(tempNode.left);
            if(tempNode.right != null) treeNodeQueue.add(tempNode.right);
        }
        return treeNodeList;
    }

}
