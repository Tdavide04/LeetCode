package leetCode;

import java.util.Arrays;
import java.util.List;

public class Problem_3350 {

	// 3350. Adjacent Increasing Subarrays Detection II
	/*
	 * Given an array nums of n integers, your task is to find the maximum value of
	 * k for which there exist two adjacent subarrays of length k each, such that
	 * both subarrays are strictly increasing. Specifically, check if there are two
	 * subarrays of length k starting at indices a and b (a < b), where:
	 * 
	 * Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly
	 * increasing. The subarrays must be adjacent, meaning b = a + k. Return the
	 * maximum possible value of k.
	 * 
	 * A subarray is a contiguous non-empty sequence of elements within an array.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [2,5,7,8,9,2,3,4,3,1]
	 * 
	 * Output: 3
	 * 
	 * Explanation:
	 * 
	 * The subarray starting at index 2 is [7, 8, 9], which is strictly increasing.
	 * The subarray starting at index 5 is [2, 3, 4], which is also strictly
	 * increasing. These two subarrays are adjacent, and 3 is the maximum possible
	 * value of k for which two such adjacent strictly increasing subarrays exist.
	 * Example 2:
	 * 
	 * Input: nums = [1,2,3,4,4,4,4,5,6,7]
	 * 
	 * Output: 2
	 * 
	 * Explanation:
	 * 
	 * The subarray starting at index 0 is [1, 2], which is strictly increasing. The
	 * subarray starting at index 2 is [3, 4], which is also strictly increasing.
	 * These two subarrays are adjacent, and 2 is the maximum possible value of k
	 * for which two such adjacent strictly increasing subarrays exist.
	 * 
	 * 
	 * Constraints:
	 * 
	 * 2 <= nums.length <= 2 * 105 -109 <= nums[i] <= 109
	 */
	public static void main(String[] args) {
		System.out.println(maxIncreasingSubarrays(Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1))); // Expected 3
		System.out.println(maxIncreasingSubarrays(Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7))); // Expected 2
		System.out.println(maxIncreasingSubarrays(Arrays.asList(8, -4, -1, 16, 20))); // Expected 2
		System.out.println(maxIncreasingSubarrays(Arrays.asList(-4, 20, 4, 10, -19, -14, -8, 1, 11, 17))); // Expected 3
	}

	public static int maxIncreasingSubarrays(List<Integer> nums) {
		int n = nums.size();
		int[] left = new int[n]; // left[i] = length of increasing subarray ending at i
		int[] right = new int[n]; // right[i] = length of increasing subarray starting at i

		left[0] = 1;
		for (int i = 1; i < n; i++) {
			if (nums.get(i) > nums.get(i - 1))
				left[i] = left[i - 1] + 1;
			else
				left[i] = 1;
		}
		right[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			if (nums.get(i) < nums.get(i + 1))
				right[i] = right[i + 1] + 1;
			else
				right[i] = 1;
		}
		int maxK = 0;
		for (int i = 0; i < n - 1; i++) {
			maxK = Math.max(maxK, Math.min(left[i], right[i + 1]));
		}
		return maxK;
	}

}
