package leetCode;

public class Problem_3370 {

	// 3370. Smallest Number With All Set Bits
	/*
	 * You are given a positive number n.
	 * 
	 * Return the smallest number x greater than or equal to n, such that the binary
	 * representation of x contains only set bits
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: n = 5
	 * 
	 * Output: 7
	 * 
	 * Explanation:
	 * 
	 * The binary representation of 7 is "111".
	 * 
	 * Example 2:
	 * 
	 * Input: n = 10
	 * 
	 * Output: 15
	 * 
	 * Explanation:
	 * 
	 * The binary representation of 15 is "1111".
	 * 
	 * Example 3:
	 * 
	 * Input: n = 3
	 * 
	 * Output: 3
	 * 
	 * Explanation:
	 * 
	 * The binary representation of 3 is "11".
	 * 
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= n <= 1000
	 */

	public static void main(String[] args) {
		System.out.println(smallestNumber(5)); // Expected 7
		System.out.println(smallestNumber(10)); // Expected 15
		System.out.println(smallestNumber(3)); // Expected 3
	}

	public static int smallestNumber(int n) {
		int x = 1;
		while (x < n) {
			x = x * 2 + 1; // Iteratively build the number with all bits set to 1
		}
		return x;

	}

}
