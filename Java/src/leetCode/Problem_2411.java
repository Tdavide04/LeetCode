package leetCode;

import java.util.Arrays;

public class Problem_2411 {

	// 2411. Smallest Subarrays With Maximum Bitwise OR
	/*
	 * You are given a 0-indexed array nums of length n, consisting of non-negative
	 * integers. For each index i from 0 to n - 1, you must determine the size of
	 * the minimum sized non-empty subarray of nums starting at i (inclusive) that
	 * has the maximum possible bitwise OR.
	 * 
	 * In other words, let Bij be the bitwise OR of the subarray nums[i...j]. You
	 * need to find the smallest subarray starting at i, such that bitwise OR of
	 * this subarray is equal to max(Bik) where i <= k <= n - 1. The bitwise OR of
	 * an array is the bitwise OR of all the numbers in it.
	 * 
	 * Return an integer array answer of size n where answer[i] is the length of the
	 * minimum sized subarray starting at i with maximum bitwise OR.
	 * 
	 * A subarray is a contiguous non-empty sequence of elements within an array.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,0,2,1,3] Output: [3,3,2,2,1] Explanation: The maximum
	 * possible bitwise OR starting at any index is 3. - Starting at index 0, the
	 * shortest subarray that yields it is [1,0,2]. - Starting at index 1, the
	 * shortest subarray that yields the maximum bitwise OR is [0,2,1]. - Starting
	 * at index 2, the shortest subarray that yields the maximum bitwise OR is
	 * [2,1]. - Starting at index 3, the shortest subarray that yields the maximum
	 * bitwise OR is [1,3]. - Starting at index 4, the shortest subarray that yields
	 * the maximum bitwise OR is [3]. Therefore, we return [3,3,2,2,1]. Example 2:
	 * 
	 * Input: nums = [1,2] Output: [2,1] Explanation: Starting at index 0, the
	 * shortest subarray that yields the maximum bitwise OR is of length 2. Starting
	 * at index 1, the shortest subarray that yields the maximum bitwise OR is of
	 * length 1. Therefore, we return [2,1].
	 * 
	 * 
	 * Constraints:
	 * 
	 * n == nums.length 1 <= n <= 105 0 <= nums[i] <= 109
	 */

	public static void main(String args[]) {
		int[] test1 = { 1, 0, 2, 1, 3 };
		System.out.println("Expected: [3, 3, 2, 2, 1]. Result: " + Arrays.toString(calcSubarray(test1)));
		int[] test2 = { 21, 14, 0, 3, 21 };
		System.out.println("Expected: [4, 4, 4, 3, 2, 1]. Result: " + Arrays.toString(calcSubarray(test2)));
	}

	// Time Complexity O(n2)
	/*
	public static int[] calcSubarray(int[] nums) {
		int len = nums.length;

		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			int currentValue = 0;
			int maxValue = 0;
			int currentLen = 0;
			int minLen = 1;
			for (int j = i; j < len; j++) {
				currentValue |= nums[j];
				currentLen += 1;
				if (currentValue > maxValue) {
					maxValue = currentValue;
					minLen = currentLen;
				}

			}
			result[i] = minLen;
		}
		return result;
	}
	*/
	
	// Time Complexity O(n2)
		public static int[] calcSubarray(int[] nums) {
	        int n = nums.length;
	        int[] result = new int[n];
	        int[] lastSeen = new int[30];  // solo 30 bit usati
	        Arrays.fill(lastSeen, -1);

	        for (int i = n - 1; i >= 0; i--) {
	            int maxReach = i;
	            for (int b = 0; b < 30; b++) {
	                if (((nums[i] >> b) & 1) == 1) {
	                    lastSeen[b] = i;
	                }
	                maxReach = Math.max(maxReach, lastSeen[b]);
	            }
	            result[i] = maxReach - i + 1;
	        }

	        return result;
		}

}
