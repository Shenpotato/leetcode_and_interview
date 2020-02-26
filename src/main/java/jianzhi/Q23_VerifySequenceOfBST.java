package jianzhi;

/*
 * 二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
 * */
public class Q23_VerifySequenceOfBST {
    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        else return isBST(sequence, 0, sequence.length - 1);
    }

    public boolean isBST(int[] sequence, int start, int end) {
        if (start >= end) return true;
        int root = sequence[end];
        int split = start;
        while (split < end && sequence[split] < root) split++;      // 当出现大于根节点的值时，确定左子树和右子树的分界，split指向右子树第一个节点
        for (int i = split; i < end; i++) {
            if(sequence[i] < root) return false;                    // 当划分的右子树出现比root小的树时，此数组不为后序遍历的结果
        }
        return isBST(sequence, start, split-1) && isBST(sequence, split, end-1);
    }
}
