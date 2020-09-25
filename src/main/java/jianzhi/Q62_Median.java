package jianzhi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 数据流中的中位数
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值
 * ，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * */
public class Q62_Median {

    // Solu1: 利用ArrayList保存数据（错误，但不知道哪里有问题）
    ArrayList<Integer> numArrayList = new ArrayList<>();

    public void Insert(Integer num) {
        for (int i = 0; i < numArrayList.size(); i++) {
            if (num <= numArrayList.get(i)) {
                numArrayList.add(i, num);
                break;
            }
        }
    }

    public Double GetMedian() {
        if (numArrayList.size() % 2 == 0)
            return (numArrayList.get(numArrayList.size() / 2 - 1) + numArrayList.get(numArrayList.size() / 2)) / 2.0;
        else return (double) numArrayList.get(numArrayList.size() / 2);
    }

    // Solu2: 优先队列（看别人的思路）
    // 代码中奇数时刻大顶堆存值，所以遇到奇数时刻，大顶堆直接弹出就是中位数
    private int cnt = 0;
    private PriorityQueue<Integer> low = new PriorityQueue<>();
    private PriorityQueue<Integer> high = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public void insert(Integer num) {
        cnt++;
        if ((cnt & 1) == 1) {
            if (!low.isEmpty() && num > low.peek()) {
                low.offer(num);
                num = low.poll();
            }
            high.offer(num);
        } else {
            if (!high.isEmpty() && num < high.peek()){
                high.offer(num);
                num = high.poll();
            }
            low.offer(num);
        }
    }

    public Double getMedian(){
        double res = 0;
        if((cnt&1) == 1) res = high.peek();
        else res = (high.peek()+low.peek())/2.0;
        return res;
    }
}
