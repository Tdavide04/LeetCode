package leetCode;

import java.util.PriorityQueue;

public class Problem_506 {

	/*
	 * 506. Relative Ranks 
	 * You are given an integer array score of size n, where
	 *  score[i] is the score of the ith athlete in a competition. All the scores are
	 * guaranteed to be unique.
	 * 
	 * The athletes are placed based on their scores, where the 1st place athlete
	 * has the highest score, the 2nd place athlete has the 2nd highest score, and
	 * so on. The placement of each athlete determines their rank:
	 * 
	 * The 1st place athlete's rank is "Gold Medal". The 2nd place athlete's rank is
	 * "Silver Medal". The 3rd place athlete's rank is "Bronze Medal". For the 4th
	 * place to the nth place athlete, their rank is their placement number (i.e.,
	 * the xth place athlete's rank is "x"). Return an array answer of size n where
	 * answer[i] is the rank of the ith athlete.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: score = [5,4,3,2,1] Output:
	 * ["Gold Medal","Silver Medal","Bronze Medal","4","5"] Explanation: The
	 * placements are [1st, 2nd, 3rd, 4th, 5th]. Example 2:
	 * 
	 * Input: score = [10,3,8,9,4] Output:
	 * ["Gold Medal","5","Bronze Medal","Silver Medal","4"] Explanation: The
	 * placements are [1st, 5th, 3rd, 2nd, 4th].
	 * 
	 * 
	 * 
	 * Constraints:
	 * 
	 * n == score.length 1 <= n <= 104 0 <= score[i] <= 106 All the values in score
	 * are unique.
	 */

	public static void main(String[] args) {
		int[] test1 = {5,4,3,2,1};
		System.out.println(findRelativeRanks(test1));
		int[] test2 = {10,3,8,9,4};
		System.out.println(findRelativeRanks(test2));
	}

	public static String[] findRelativeRanks(int[] score) {

		int length = score.length;
		String answer[] = new String[length];
		
		// PriorityQueue with custom comparator to act as a Max-Heap
        // Each element in the heap is an array: [score, original_index]
		PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);

		// Add all scores along with their original indices to the heap
		for (int i = 0; i < length; i++) {
			maxHeap.add(new int[] { score[i], i });
		}

		int position = 1;
		while (!maxHeap.isEmpty()) {
			int[] top = maxHeap.poll(); // Get the highest score from heap
			int index = top[1]; // Get the original index of the athlete

			// Assign the correct rank based on position
			if (position == 1) {
				answer[index] = "Gold Medal";
			} else if (position == 2) {
				answer[index] = "Silver Medal";
			} else if (position == 3) {
				answer[index] = "Bronze Medal";
			} else {
				answer[index] = String.valueOf(position);
			}

			position++;
		}

		return answer;

	}
}
