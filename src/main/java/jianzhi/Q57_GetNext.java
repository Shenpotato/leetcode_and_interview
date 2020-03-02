package jianzhi;

/*
* 二叉树的下一个节点
*
* 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
* 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
* */
public class Q57_GetNext {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    // Solu1: 找到父节点，中序遍历找到该节点的下一个节点

    // Solu2:
    // 存在右子树：
    //      1）右子树有左子树 - > 遍历左子树节点
    //      2）右子树无左子树 - > 输出右子树根节点
    // 不存在右子树：
    //      1）为根节点返回null
    //      2）判断该节点是其父节点的左孩子/右孩子：
    //          （1）左孩子 - > 返回父节点
    //          （2）右孩子 - > 向上遍历父节点，当某个父节点的父节点是其父节点的左节点时，返回该父节点的父节点
    public TreeLinkNode getNext(TreeLinkNode pNode){
        if(pNode == null) return null;
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null) pNode = pNode.left;
            return pNode;
        }
        while(pNode.next != null){
            if(pNode.next.left == pNode) return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }

}
