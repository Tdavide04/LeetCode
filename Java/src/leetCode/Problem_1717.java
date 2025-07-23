package leetCode;

public class Problem_1717 {

	// 1717. Maximum Score From Removing Substrings
	/*
	 * You are given a string s and two integers x and y. You can perform two types
	 * of operations any number of times.
	 * 
	 * Remove substring "ab" and gain x points. For example, when removing "ab" from
	 * "cabxbae" it becomes "cxbae". Remove substring "ba" and gain y points. For
	 * example, when removing "ba" from "cabxbae" it becomes "cabxe". Return the
	 * maximum points you can gain after applying the above operations on s.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: s = "cdbcbbaaabab", x = 4, y = 5 Output: 19 Explanation: - Remove the
	 * "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are
	 * added to the score. - Remove the "ab" underlined in "cdbcbbaaab". Now, s =
	 * "cdbcbbaa" and 4 points are added to the score. - Remove the "ba" underlined
	 * in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score. -
	 * Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are
	 * added to the score. Total score = 5 + 4 + 5 + 5 = 19. Example 2:
	 * 
	 * Input: s = "aabbaaxybbaabb", x = 5, y = 4 Output: 20
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= s.length <= 105 1 <= x, y <= 104 s consists of lowercase English
	 * letters.
	 * 
	 */
	
	public static void main(String args[]) {
		String test1 = "cdbcbbaaabab";
		System.out.println("Expected: 19. Result "+ maximumGain(test1, 4, 5));
	}
	
	public static int maximumGain(String s, int x, int y) {
		// Convert the string to a character array for easy traversal
		char[] chars = s.toCharArray();

		int total = 0;
		int a = 0; // Counts how many times we've seen the 'first' character (waiting for a pair)
		int b = 0; // Counts how many 'second' characters are waiting for a pair

		// Decide which pair ("ab" or "ba") is more profitable
		char first = x >= y ? 'a' : 'b'; // The first character of the more valuable pair
		char second = x >= y ? 'b' : 'a'; // The second character of the more valuable pair
		int max = Math.max(x, y); // Points for the more valuable pair
		int min = Math.min(x, y); // Points for the less valuable pair

		// Traverse the character array
		for (char c : chars) {
			if (c == first) {
				// Found a 'first' character → store it and wait for a matching 'second'
				a++;
			} else if (c == second) {
				if (a > 0) {
					// We have a matching 'first' → form the pair and gain points
					a--;
					total += max;
				} else {
					// No available 'first' to pair with → store this 'second' for possible future
					// pairing
					b++;
				}
			} else {
				// Found a character that is neither 'a' nor 'b' → treat it as a barrier
				// Before resetting, form as many "ba" pairs as possible with leftovers
				total += Math.min(a, b) * min;
				a = b = 0; // Reset counters for the next block
			}
		}

		// After the loop, handle any remaining letters (leftovers)
		total += Math.min(a, b) * min;

		return total; // Return the total maximum score
	}
}
