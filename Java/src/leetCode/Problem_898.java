package leetCode;

import java.util.HashSet;
import java.util.Set;

public class Problem_898 {

	// 898. Bitwise ORs of Subarrays
	/*
	 * Given an integer array arr, return the number of distinct bitwise ORs of all
	 * the non-empty subarrays of arr.
	 * 
	 * The bitwise OR of a subarray is the bitwise OR of each integer in the
	 * subarray. The bitwise OR of a subarray of one integer is that integer.
	 * 
	 * A subarray is a contiguous non-empty sequence of elements within an array.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: arr = [0] Output: 1 Explanation: There is only one possible result: 0.
	 * Example 2:
	 * 
	 * Input: arr = [1,1,2] Output: 3 Explanation: The possible subarrays are [1],
	 * [1], [2], [1, 1], [1, 2], [1, 1, 2]. These yield the results 1, 1, 2, 1, 3,
	 * 3. There are 3 unique values, so the answer is 3. Example 3:
	 * 
	 * Input: arr = [1,2,4] Output: 6 Explanation: The possible results are 1, 2, 3,
	 * 4, 6, and 7.
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= arr.length <= 5 * 104 0 <= arr[i] <= 109
	 */
	
	public static void main(String args[]) {
		int[] test1 = {0};
		System.out.println("Expected . Result " + subarrayBitwiseORs(test1));
		int[] test2 = {1,1,2};
		System.out.println("Expected . Result " + subarrayBitwiseORs(test2));
		int[] test3 = {1,2,4};
		System.out.println("Expected . Result " + subarrayBitwiseORs(test3));
	}
	
	// O(n2) 
	/*
	 * public static int subarrayBitwiseORs(int[] arr) { Set<Integer> set = new
	 * HashSet<Integer>(); for(int i = 0; i < arr.length; i++) { int val = 0;
	 * for(int j = i; j < arr.length; j++) { val |= arr[j]; set.add(val); } } return
	 * set.size();
	 * 
	 * }
	 */
	
	// O(n)
    public static int subarrayBitwiseORs(int[] arr) {
    Set<Integer> ans = new HashSet<>(); // result
    Set<Integer> cur = new HashSet<>(); // current set
    cur.add(0);
    for (int x : arr) {
        Set<Integer> cur2 = new HashSet<>(); // temporary set
        for (int y: cur)
            cur2.add(x | y);
        cur2.add(x);
        cur = cur2;
        ans.addAll(cur);
    }

    return ans.size();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
