package leetcode;

/*
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */

import java.util.Arrays;

// 中等难度。
public class Q16_ThreeSumClosest {
    // Solu1： 暴力枚举
//    public int threeSumClosest(int[] nums, int target) {
//        int closestSum = 0, result = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < result) {
//                        closestSum = nums[i] + nums[j] + nums[k];
//                        result = Math.abs(nums[i] + nums[j] + nums[k] - target);
//                    }
//                }
//            }
//        }
//        return closestSum;
//    }

    // Solu2: 排序 + 双指针
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs((closestSum - target))) closestSum = sum;
                else if (sum > target) j--;
                else if (sum < target) i++;
                else return sum;                        // sum == target
            }
        }
        return closestSum;
    }
}
