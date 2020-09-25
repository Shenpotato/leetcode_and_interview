package interviewTencent;

import java.util.Scanner;

public class TecentAlgo {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minindex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j]<nums[minindex]) minindex = j;
            }
            swap(nums, minindex, i);
        }
    }

    // 消费生产者模式
//    static int mutex = 1;
//    final static int emptyNum= 100;
//    final static int fullNum = 0;
//
//    public void producer(){
//        while(true){
//            int itemNum = produceItem();
//            down(emptyNum);
//            down(mutex);
//            insertItem(itemNum);
//            up(mutex);
//            up(fullNum);
//        }
//    }
//
//
//    public void consumer(){
//        while(true){
//            int itemNum = consumItem();
//            down(fullNum);
//            down(mutex);
//            consumeItem(itemNum);
//            up(mutex);
//            up(emptyNum);
//        }
//    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] nums = new int[number];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        TecentAlgo tecentAlgo = new TecentAlgo();
        tecentAlgo.selectSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
