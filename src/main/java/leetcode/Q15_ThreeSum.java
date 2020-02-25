package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例：
给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

// 中等难度。暴力法/将数组排序，双指针法
public class Q15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sumlist = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);       // 跳过相邻数相等的sum计算，下同
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    sumlist.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return sumlist;
    }

    public static void main(String[] args) {
        Q15_ThreeSum q15_threeSum = new Q15_ThreeSum();
        int[] nums = {3, 0, -2, -1, 1, 2};
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        System.out.println(q15_threeSum.threeSum(nums2));
    }
}
