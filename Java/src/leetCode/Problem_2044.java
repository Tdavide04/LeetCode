package leetCode;

public class Problem_2044 {

	// 2044. Count Number of Maximum Bitwise-OR Subsets
	/*
	 * Given an integer array nums, find the maximum possible bitwise OR of a subset
	 * of nums and return the number of different non-empty subsets with the maximum
	 * bitwise OR.
	 * 
	 * An array a is a subset of an array b if a can be obtained from b by deleting
	 * some (possibly zero) elements of b. Two subsets are considered different if
	 * the indices of the elements chosen are different.
	 * 
	 * The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length -
	 * 1] (0-indexed).
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [3,1] Output: 2 Explanation: The maximum possible bitwise OR of
	 * a subset is 3. There are 2 subsets with a bitwise OR of 3: - [3] - [3,1]
	 * Example 2:
	 * 
	 * Input: nums = [2,2,2] Output: 7 Explanation: All non-empty subsets of [2,2,2]
	 * have a bitwise OR of 2. There are 23 - 1 = 7 total subsets. Example 3:
	 * 
	 * Input: nums = [3,2,1,5] Output: 6 Explanation: The maximum possible bitwise
	 * OR of a subset is 7. There are 6 subsets with a bitwise OR of 7: - [3,5] -
	 * [3,1,5] - [3,2,5] - [3,2,1,5] - [2,5] - [2,1,5]
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= nums.length <= 16 1 <= nums[i] <= 105
	 */

	private int maxOr = 0; // Stores the maximum possible OR value across all subsets
	private int count = 0; // Counts how many subsets achieve that maximum OR

	public int countMaxOrSubsets(int[] nums) {
		// Step 1: Calculate the maximum OR value by OR-ing all elements together
		for (int num : nums) {
			maxOr |= num;
		}

		// Step 2: Start the backtracking process from index 0 and current OR = 0
		backtrack(nums, 0, 0);

		// Step 3: Return the count of subsets that reached the max OR
		return count;
	}

	// Recursive backtracking function
	private void backtrack(int[] nums, int index, int currOr) {
		// Base case: we've considered all elements
		if (index == nums.length) {
			// If the current OR equals the maximum OR, it's a valid subset
			if (currOr == maxOr) {
				count++;
			}
			return;
		}

		// Option 1: Include nums[index] in the subset
		backtrack(nums, index + 1, currOr | nums[index]);

		// Option 2: Exclude nums[index] from the subset
		backtrack(nums, index + 1, currOr);
	}
}
