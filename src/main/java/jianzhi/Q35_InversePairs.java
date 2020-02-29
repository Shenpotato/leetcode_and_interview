package jianzhi;

/*
 * 数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 *
 * 输入 : 1,2,3,4,5,6,7,0
 * 输出 : 7
 * */
public class Q35_InversePairs {
    int count = 0;

    // 两次循环时间复杂度过大，O(n^2)
    public int inversePairs(int[] array) {
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (array[i] < array[j]) count++;
            }
        }
        return count % 1000000007;
    }

    // 归并排序降低时间复杂度
    public int inversePairs2(int[] array) {
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    public void mergeSort(int[] array, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(array, lo, mid);
        mergeSort(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }

    private void merge(int[] array, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        int[] aux = new int[array.length];
        for (int k = 0; k < array.length; k++) {
            aux[k] = array[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) array[k] = aux[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (aux[i] > aux[j]) {
                array[k] = aux[j++];
                count = (count + (mid - k + 1)) % 1000000007;
            } else array[k] = aux[i++];
        }
    }
}
