package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 按之字形顺序打印二叉树
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * */
public class Q58_Print {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean rev = true;
        treeNodeQueue.add(pRoot);
        while(!treeNodeQueue.isEmpty()){
            int size = treeNodeQueue.size();        // 一层的数量
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeQueue.poll();
                if(treeNode == null) continue;
                if(rev){
                    arrayList.add(treeNode.val);
                }else{
                    arrayList.add(0,treeNode.val);
                }
                treeNodeQueue.add(treeNode.left);
                treeNodeQueue.add(treeNode.right);
            }
            if(arrayList.size()!=0) result.add(arrayList);
            rev = !rev;
        }
        return result;
    }
}
