package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 把二叉树打印成多行
 *
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * */
public class Q59_Print {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if(treeNode == null) continue;
                arrayList.add(treeNode.val);
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
            if(arrayList.size() != 0) result.add(arrayList);
        }
        return result;
    }
}
