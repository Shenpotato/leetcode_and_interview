package algorithm;


/**
 * @author ShenPotato
 * @version 1.0
 * @date 2020/2/23 5:40 下午
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;           // 基于堆的完全二叉树
    private int N;              // 存储于pq[1..N]中，pq[0]没有使用

    public MaxPQ(int max) {
        pq = (Key[]) new Comparable[N + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];            // 从根结点得到最大元素
        exchange(1, N--);        // 将其和最后一个节点交换
        pq[N+1] = null;             // 防止对象游离
        sink(1);                 // 恢复堆的有序性
        return max;
    }

}
