package leetCode;

import java.util.HashSet;
import java.util.Set;

public class Problem_1695 {

	// 1695. Maximum Erasure Value
	/*
	 * You are given an array of positive integers nums and want to erase a subarray
	 * containing unique elements. The score you get by erasing the subarray is
	 * equal to the sum of its elements.
	 * 
	 * Return the maximum score you can get by erasing exactly one subarray.
	 * 
	 * An array b is called to be a subarray of a if it forms a contiguous
	 * subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some
	 * (l,r).
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [4,2,4,5,6] Output: 17 Explanation: The optimal subarray here
	 * is [2,4,5,6]. Example 2:
	 * 
	 * Input: nums = [5,2,1,2,5,2,1,2,5] Output: 8 Explanation: The optimal subarray
	 * here is [5,2,1] or [1,2,5].
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= nums.length <= 105 1 <= nums[i] <= 104
	 */
	
	public static void main(String[] args) {

		int[] test1 = {4,2,4,5,6};
		System.out.println("Expected: 17. Result: " + maximumUniqueSubarray(test1));
		int[] test2 = {5,2,1,2,5,2,1,2,5};
		System.out.println("Expected: 8. Result: " + maximumUniqueSubarray(test2));
	}

	public static int maximumUniqueSubarray(int[] nums) {
		// Initialize two pointers for the sliding window: left and right
		int left = 0; 
		int right = 0;
		
		// Initialize the current sum of the window and the max sum found
		int sum = 0;
		int max = 0;
		
		Set<Integer> window = new HashSet<Integer>();
		while(right < nums.length) {
			// If the current element is not in the window, it's unique
			if(!window.contains(nums[right])) {
				sum += nums[right];
				window.add(nums[right]);
				max = Math.max(max, sum);
				right ++;
			} else {
				// If duplicate found, shrink the window from the left
				sum -= nums[left];
				window.remove(nums[left]);
				left ++;
			}
		}
		
		
		return max;

	}
}
