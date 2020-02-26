package jianzhi;

import java.util.ArrayList;

/*
* 二叉搜索树和双向链表
*
* 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
* */
public class Q26_Convert {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        ArrayList<TreeNode> midlleList = new ArrayList<>();
        middleOrder(pRootOfTree, midlleList);               // 中序遍历的结果就是从小到大的结果
        for(int i = 0; i < midlleList.size() - 1; i++){
            midlleList.get(i).right = midlleList.get(i + 1);
            midlleList.get(i + 1).left = midlleList.get(i);
        }
        return midlleList.get(0);
    }

    public void middleOrder(TreeNode treeNode, ArrayList<TreeNode> middleList){
        if(treeNode.left!=null) middleOrder(treeNode.left, middleList);
        middleList.add(treeNode);
        if(treeNode.right!=null) middleOrder(treeNode.right, middleList);
    }


}
