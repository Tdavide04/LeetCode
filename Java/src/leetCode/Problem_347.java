package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem_347 {

	/*
	 * 347. Top K Frequent Elements 
	 * Given an integer array nums and an integer k,
	 * return the k most frequent elements. You may return the answer in any order.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2] Example 2:
	 * 
	 * Input: nums = [1], k = 1 Output: [1]
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= nums.length <= 105 -104 <= nums[i] <= 104 k is in the range [1, the
	 * number of unique elements in the array]. It is guaranteed that the answer is
	 * unique.
	 * 
	 * 
	 * Follow up: Your algorithm's time complexity must be better than O(n log n),
	 * where n is the array's size.
	 */

	public static void main(String[] args) {

		int[] test1 = { 1, 1, 1, 2, 2, 3 };
		System.out.println(topKFrequent(test1, 2));
	}

	public static int[] topKFrequent(int[] nums, int k) {

		// Count the frequency of each number in the array
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// If the number is not in the map, add it with a frequency of 1
		for (int j = 0; j < nums.length; j++) {
			if (!map.containsKey(nums[j])) {
				map.put(nums[j], 1);
			} else {
				// If it already exists, increment its frequency
				map.put(nums[j], map.get(nums[j]) + 1);
			}
		}

		// Create a max-heap (priority queue) based on frequency
	    // The entry with the highest frequency will be at the top
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		// Add all map entries to the max-heap
		maxHeap.addAll(map.entrySet());

		int[] result = new int[k];
		for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
			Map.Entry<Integer, Integer> max = maxHeap.poll(); // get the element with highest frequency
			result[i] = max.getKey();
			map.remove(max.getKey());
		}
		return result;
	}

}
