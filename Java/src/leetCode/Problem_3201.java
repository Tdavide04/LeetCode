package leetCode;

public class Problem_3201 {

	/*
	 * 3201. Find the Maximum Length of Valid Subsequence I 
	 * You are given an integer array nums. A subsequence sub of nums with length x is called valid if it
	 * satisfies:
	 * 
	 * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x
	 * - 1]) % 2. Return the length of the longest valid subsequence of nums.
	 * 
	 * A subsequence is an array that can be derived from another array by deleting
	 * some or no elements without changing the order of the remaining elements.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,2,3,4]
	 * 
	 * Output: 4
	 * 
	 * Explanation:
	 * 
	 * The longest valid subsequence is [1, 2, 3, 4].
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [1,2,1,1,2,1,2]
	 * 
	 * Output: 6
	 * 
	 * Explanation:
	 * 
	 * The longest valid subsequence is [1, 2, 1, 2, 1, 2].
	 * 
	 * Example 3:
	 * 
	 * Input: nums = [1,3]
	 * 
	 * Output: 2
	 * 
	 * Explanation:
	 * 
	 * The longest valid subsequence is [1, 3].
	 * 
	 * 
	 * 
	 * Constraints:
	 * 
	 * 2 <= nums.length <= 2 * 105 1 <= nums[i] <= 107
	 */
	public static void main(String args[]) {
		int[] test1 = { 1, 2, 3, 4 };
		System.out.println("Test 1: \nExpected Output: 4 Real output: " + maximumLength(test1));

		int[] test2 = { 1, 2, 1, 1, 2, 1, 2 };
		System.out.println("Test 2: \nExpected Output: 6 Real output: " + maximumLength(test2));

		int[] test3 = { 2, 2, 4, 6, 2 };
		System.out.println("Test 3: \nExpected Output: 5 Real output: " + maximumLength(test3));

		int[] test4 = { 1, 5, 9, 4, 2 };
		System.out.println("Test 4: \nExpected Output: 3 Real output: " + maximumLength(test4));
	}

	public static int maximumLength(int[] nums) {
		int countEven = 0;
		int countOdd = 0;

		// Count how many even and odd numbers are in the array
		for (int num : nums) {
			if (num % 2 == 0) {
				countEven++;
			} else {
				countOdd++;
			}
		}

		int evenDp = 0;
		int oddDp = 0;

		// Dynamic programming approach to find the longest valid alternating
		// subsequence
		for (int num : nums) {
			if (num % 2 == 0) {
				// If the number is even, we can extend a previous odd subsequence
				evenDp = Math.max(evenDp, oddDp + 1);
			} else {
				// If the number is odd, we can extend a previous even subsequence
				oddDp = Math.max(oddDp, evenDp + 1);
			}
		}

		// Return the maximum among: number of evens, number of odds, longest
		// alternating sequence ending in even or odd
		return Math.max(Math.max(countEven, countOdd), Math.max(evenDp, oddDp));
	}
}
