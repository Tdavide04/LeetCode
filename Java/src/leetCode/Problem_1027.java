package leetCode;

import java.util.HashMap;
import java.util.Map;

public class Problem_1027 {
	/*
	 * 1027. Longest Arithmetic Subsequence
	 * Given an array nums of integers, return
	 * the length of the longest arithmetic subsequence in nums.
	 * 
	 * Note that:
	 * 
	 * A subsequence is an array that can be derived from another array by deleting
	 * some or no elements without changing the order of the remaining elements. A
	 * sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (for
	 * 0 <= i < seq.length - 1).
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [3,6,9,12] Output: 4 Explanation: The whole array is an
	 * arithmetic sequence with steps of length = 3.
	 */

	public static void main(String[] args) {

		int[] test1 = { 3, 6, 9, 12 };
		System.out.println("Test 1. Expected: 4. Result: " + longestArithSeqLength(test1));
		int[] test2 = { 9, 4, 7, 2, 10 };
		System.out.println("Test 2. Expected: 3. Result: " + longestArithSeqLength(test2));
		int[] test3 = { 20, 1, 15, 3, 10, 5, 8 };
		System.out.println("Test 3. Expected: 4. Result: " + longestArithSeqLength(test3));
		int[] test4 = { 1, 2, 15, 3, 3, 15 };
		System.out.println("Test 4. Expected: 2. Result: " + longestArithSeqLength(test4));

	}

	public static int longestArithSeqLength(int[] nums) {
		// Create an array of HashMaps.
		// Each map[i] will store the difference `diff` as key and the length of the
		// arithmetic subsequence ending at index i with that difference.
		Map<Integer, Integer>[] map = new HashMap[nums.length]; // Keeps track of the maximum length of any arithmetic
																// subsequence found.
		int maxLen = 0;
		for (int i = 0; i < nums.length; i++) {
			map[i] = new HashMap<>();
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				int diff = nums[i] - nums[j];
				// Get the length of the sequence ending at j with the same difference.
				// If no such sequence exists, start with length 1 (i.e., two elements: nums[j]
				// and nums[i]).
				int len = map[j].getOrDefault(diff, 1);
				// Update the sequence length for nums[i] with this difference.
				// Use the maximum between the current length and len + 1 to handle duplicate
				// pairs.
				map[i].put(diff, Math.max(map[i].getOrDefault(diff, 0), len + 1));
				// Update the overall maximum length
				maxLen = Math.max(maxLen, map[i].get(diff));

			}
		}

		return maxLen;
	}
}
