package interviewTencent;

import jianzhi.Q49_StrToInt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Q4_Median {

    public void findMedian(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        List<Integer> medians = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            List<Integer> temps = new LinkedList<>();
            for (int j = 0; j < list.size(); j++) {
                temps.add(list.get(j));
            }
            temps.remove(i);
//            System.out.println(temps.toString());
            Object[] ints = temps.toArray();
            Arrays.sort(ints);
            medians.add((Integer) ints[n/2 - 1]);
        }


        for (int i = 0; i < medians.size(); i++) {
            System.out.println(medians.get(i));
        }
    }

    public static void main(String[] args) {
        Q4_Median q4_median = new Q4_Median();
        q4_median.findMedian();
    }
}
