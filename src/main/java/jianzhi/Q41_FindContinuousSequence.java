package jianzhi;

import java.util.ArrayList;

/*
 * 合为s的连续正数序列
 *
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * */
public class Q41_FindContinuousSequence {
    // 找规律法
    public ArrayList<ArrayList<Integer>> findContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = (int) Math.floor(Math.sqrt(sum + 0.5) + 0.5);
        for (int i = 2; i <= n; i++) {
            if (n % 2 == 0) {
                if (sum % n == n / 2) {
                    ArrayList<Integer> list = new ArrayList<>();
                    int start = sum / n - n / 2 + 1;
                    int end = sum / n + n / 2 + 1;
                    for (int j = start; j <= end; j++) {
                        list.add(j);
                    }
                    result.add(list);
                }
            } else {
                if (sum % n == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    int start = sum / n - n / 2;
                    int end = sum / n + n / 2;
                    for (int j = start; j <= end ; j++) {
                        list.add(j);
                    }
                    result.add(list);
                }

            }
        }
        return result;
    }

    // 穷举法
    public ArrayList<ArrayList<Integer>> findContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i=1; i < sum; i++){
            int temp = 0;
            int j = i;
            while(temp < sum){
                temp += j;
                j++;
            }
            if(temp == sum){//如果找到了那么就要把数据添加到结果数据中。
                ArrayList<Integer> newArray = new  ArrayList<Integer>();
                for(int k=i;k< j;k++)
                    newArray.add(k);
                result.add(newArray);
            }
        }
        return result;
    }
}
