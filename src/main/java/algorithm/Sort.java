package algorithm;


import static algorithm.SortUtil.*;

// 常见排序算法集合, rev版本是从大到小排列
public class Sort {

    /*
     * 初级排序算法：选择排序，插入排序，希尔排序
     * */
    // 选择排序: 找到数组中最小的元素，与数组的第一个位置交换...如此往复，直至整个数组排序
    public Comparable[] selectSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int minindex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[minindex])) minindex = j;
            }
            exchange(a, minindex, i);
        }
        return a;
    }

    public Comparable[] selectSortRev(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int maxindex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (more(a[j], a[j - 1])) maxindex = j;
            }
            exchange(a, maxindex, i);
        }
        return a;
    }

    // 插入排序：将卡片插入已经排好序的卡组里
    public Comparable[] insertSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
        return a;
    }

    public Comparable[] insertSortRev(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && more(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
        return a;
    }

    // 希尔排序：为了解决插入排序在原数组完全反序时，只能依次全部交换所有的数组元素的弊端，进行改进的快速排序算法
    public Comparable[] shellSort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h = h / 3;
        }
        return a;
    }

    /*
     * 归并排序，包含自顶向下和自顶向上的归并排序。
     * 时间复杂度 O(NlogN), 空间复杂度 O(N)
     * */

    // 原地归并，添加了一个N的数组空间
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 将a[lo..mid] 和 a[mid+1..hi]归并
        int i = lo, j = mid + 1;                // i是左半边元素指针，j是右半边元素指针
        Comparable[] aux = new Comparable[a.length];
        for (int k = lo; k <= hi; k++) {        // 复制a到aux
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {        // 归并回到a[lo..hi]
            if (i > mid) a[k] = aux[j++];       // 左半边没有元素，只能取右半边元素
            else if (j > hi) a[k] = aux[i++];   // 右半边没有元素，只能取右半边元素
            else if (less(aux[j], aux[i])) a[k] = aux[j++];     // 右半边元素小于左半边，选择右半边元素，右半边指针后移
            else a[k] = aux[i++];               // 左半边元素小于右半边，选择左半边元素，左半边指针后移
        }
    }

    // 自顶向下归并排序
    public void mergeSortTopToBottom(Comparable[] a) {
        mergeSortTopToBottom(a, 0, a.length - 1);
    }

    public void mergeSortTopToBottom(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;                // *关键，当左边指针等于右边指针时停止分割
        int mid = lo + (hi - lo) / 2;
        mergeSortTopToBottom(a, lo, mid);
        mergeSortTopToBottom(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    // 自底向上归并排序
    public void mergeSortBottomToTop(Comparable[] a) {
        // 进行logN次两两归并
        for (int sz = 1; sz < a.length; sz = sz + sz) {               // sz：子数组大小, 即需要归并的两个数组中的一个数组的大小
            for (int lo = 0; lo < a.length - sz; lo += sz + sz)        // lo：子数组索引，a.length = hi - lo + 1
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));
        }
    }


    /*
     * 快速排序以及其变种
     * 优点：速度快，辅助空间小，时间复杂度低，健壮性不强
     * */

    // 快排切分，确定数组第j个元素的数值，j左边的数组不大于a[j], 右边的数组不小于a[j]
    public int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];                               // 以a[lo]作为数组分割元素值
        int i = lo, j = hi + 1;                             // i为左指针，j为右指针
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;     // 左指针向右移动，i记录数组元素值大于v的位置
            while (less(v, a[--j])) if (j == lo) break;     // 右指针向左移动，j记录数组元素值小于v的位置
            if (i >= j) break;                              // 当i >= j时，j的位置就是我们要找的位置，跳出循环，不执行交换操作
            exchange(a, i, j);                              // 交换i，j位置元素值
        }
        exchange(a, lo, j);                                 // j是a[lo]元素值应该在的位置，交换j位置和lo位置元素值
        return j;
    }

    public void quickSort(Comparable[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public void quickSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;               // 与归并排序相同，不用切分
        int j = partition(a, lo, hi);
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }

    public void quickSortThreeWay(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exchange(a, lt++, i++);
            else if (cmp > 0) exchange(a, i, gt--);
            else i++;
        }
        quickSortThreeWay(a, lo, lt - 1);
        quickSort(a, gt + 1, hi);
    }


    public static void main(String[] args) {
        Sort sort = new Sort();
        Integer[] nums = {12, 3, 4, 2, 14, 6};
//        sort.selectSortRev(nums);     sort.selectSort(nums)
//        sort.insertSortRev(nums);     sort.insertSort(nums);
//        sort.mergeSortTopToBottom(nums);
//        sort.mergeSortBottomToTop(nums);
//        sort.shellSort(nums);
        sort.quickSort(nums);
        assert isSorted(nums);
        show(nums);
    }

}
