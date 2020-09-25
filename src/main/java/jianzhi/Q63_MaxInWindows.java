package jianzhi;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;


/*
 * 滑动窗口的最大值
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 *  {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * */
public class Q63_MaxInWindows {
    // 主要是优先队列的使用，其特性是自动排序。堆顶元素是最大/最小值
    public PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));   //降序
    public ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || num.length <= 0 || size <= 0 || num.length < size) return result;
        int count = 0;
        for (; count < size; count++) {
            priorityQueue.offer(num[count]);
        }
        while (count < num.length){
            result.add(priorityQueue.peek());
            priorityQueue.remove(num[count-size]);
            priorityQueue.add(num[count]);
            count++;
        }
        result.add(priorityQueue.peek());
        return result;
    }

}
