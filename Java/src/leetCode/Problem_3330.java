package leetCode;

public class Problem_3330 {

	// 3330. Find the Original Typed String I
	/*
	 * Alice is attempting to type a specific string on her computer. However, she
	 * tends to be clumsy and may press a key for too long, resulting in a character
	 * being typed multiple times.
	 * 
	 * Although Alice tried to focus on her typing, she is aware that she may still
	 * have done this at most once.
	 * 
	 * You are given a string word, which represents the final output displayed on
	 * Alice's screen.
	 * 
	 * Return the total number of possible original strings that Alice might have
	 * intended to type.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: word = "abbcccc"
	 * 
	 * Output: 5
	 * 
	 * Explanation:
	 * 
	 * The possible strings are: "abbcccc", "abbccc", "abbcc", "abbc", and "abcccc".
	 * 
	 * Example 2:
	 * 
	 * Input: word = "abcd"
	 * 
	 * Output: 1
	 * 
	 * Explanation:
	 * 
	 * The only possible string is "abcd".
	 * 
	 * Example 3:
	 * 
	 * Input: word = "aaaa"
	 * 
	 * Output: 4
	 * 
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= word.length <= 100 word consists only of lowercase English letters.
	 */
	public static void main(String args[]) {
		System.out.println("Expected: 5. Result: " + possibleStringCount("abbcccc"));
	}

	public static int possibleStringCount(String word) {
		int counter = 1;
		char[] chars = word.toCharArray();
		for (int i = 1; i < chars.length; i ++) {
			char lastSeen = chars[i-1];
			if (chars[i] == lastSeen) {
				counter += 1;
			}
		}
		return counter;
	}
}
