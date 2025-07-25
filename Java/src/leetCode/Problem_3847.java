package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem_3847 {

	// 3487. Maximum Unique Subarray Sum After Deletion
	/*
	 * You are given an integer array nums.
	 * 
	 * You are allowed to delete any number of elements from nums without making it
	 * empty. After performing the deletions, select a subarray of nums such that:
	 * 
	 * All elements in the subarray are unique. The sum of the elements in the
	 * subarray is maximized. Return the maximum sum of such a subarray.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,2,3,4,5]
	 * 
	 * Output: 15
	 * 
	 * Explanation:
	 * 
	 * Select the entire array without deleting any element to obtain the maximum
	 * sum.
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [1,1,0,1,1]
	 * 
	 * Output: 1
	 * 
	 * Explanation:
	 * 
	 * Delete the element nums[0] == 1, nums[1] == 1, nums[2] == 0, and nums[3] ==
	 * 1. Select the entire array [1] to obtain the maximum sum.
	 * 
	 * Example 3:
	 * 
	 * Input: nums = [1,2,-1,-2,1,0,-1]
	 * 
	 * Output: 3
	 * 
	 * Explanation:
	 * 
	 * Delete the elements nums[2] == -1 and nums[3] == -2, and select the subarray
	 * [2, 1] from [1, 2, 1, 0, -1] to obtain the maximum sum.
	 * 
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= nums.length <= 100 -100 <= nums[i] <= 100
	 */
	
	public static void main(String args[]) {
		int[] test1 = {1,2,3,4,5};
		System.out.println("Expected: 15.Result: " + maxSum(test1));
		int[] test2 = {1,1,0,1,1};
		System.out.println("Expected: 1.Result: " + maxSum(test2));
		int[] test3 = {1,2,-1,-2,1,0,-1};
		System.out.println("Expected: 3.Result: " + maxSum(test3));
		int[] test4 = {-100};
		System.out.println("Expected: -100.Result: " + maxSum(test4));
		int[] test5 = {20, -20};
		System.out.println("Expected: 20.Result: " + maxSum(test5));
		int[] test6 = {-17, -15};
		System.out.println("Expected: -15.Result: " + maxSum(test6));
	}
	
	public static int maxSum(int[] nums) {
        // Check if all elements are negative
        boolean allNegative = true;
        int maxValue = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n >= 0) {
                allNegative = false;
            }
            if (n > maxValue) {
                maxValue = n;
            }
        }
        if (allNegative)
            return maxValue;

        // Use a set to remove duplicates
        Set<Integer> unique = new HashSet<>();
        for (int n : nums) {
            unique.add(n);
        }

        // Sum all positive numbers from the set
        int sum = 0;
        for (int val : unique) {
            if (val > 0) {
                sum += val;
            }
        }

        return sum;
    }
}
