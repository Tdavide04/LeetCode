package leetCode;

import java.util.HashMap;
import java.util.Map;

public class Problem_3541 {

	// 3541. Find Most Frequent Vowel and Consonant
	/*
	 * You are given a string s consisting of lowercase English letters ('a' to
	 * 'z').
	 * 
	 * Your task is to:
	 * 
	 * Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum
	 * frequency. Find the consonant (all other letters excluding vowels) with the
	 * maximum frequency. Return the sum of the two frequencies.
	 * 
	 * Note: If multiple vowels or consonants have the same maximum frequency, you
	 * may choose any one of them. If there are no vowels or no consonants in the
	 * string, consider their frequency as 0.
	 * 
	 * The frequency of a letter x is the number of times it occurs in the string.
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: s = "successes"
	 * 
	 * Output: 6
	 * 
	 * Explanation:
	 * 
	 * The vowels are: 'u' (frequency 1), 'e' (frequency 2). The maximum frequency
	 * is 2. The consonants are: 's' (frequency 4), 'c' (frequency 2). The maximum
	 * frequency is 4. The output is 2 + 4 = 6. Example 2:
	 * 
	 * Input: s = "aeiaeia"
	 * 
	 * Output: 3
	 * 
	 * Explanation:
	 * 
	 * The vowels are: 'a' (frequency 3), 'e' ( frequency 2), 'i' (frequency 2). The
	 * maximum frequency is 3. There are no consonants in s. Hence, maximum
	 * consonant frequency = 0. The output is 3 + 0 = 3.
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= s.length <= 100 s consists of lowercase English letters only.
	 */

	public static void main(String args[]) {
		System.out.println(maxFreqSum("successes")); //Expected 6
		System.out.println(maxFreqSum("aeiaeia")); //Expected 3
	}

	public static int maxFreqSum(String s) {
		Map<String, Integer> vowels = new HashMap<String, Integer>();
		Map<String, Integer> consonant = new HashMap<String, Integer>();
		
		char[] vowelChars = {'a','e','i','o','u'};
		for (char c : vowelChars) {
		    vowels.put(String.valueOf(c), 0);
		}
		
		char[] charListOfS = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			String key = String.valueOf(charListOfS[i]);
			if(vowels.containsKey(key)) {
				vowels.put(key, vowels.get(key) + 1);
			} else {
				consonant.put(key, consonant.getOrDefault(key, 0) + 1);
			}
		}
		
		int maxVowels = 0;
		for (Integer value : vowels.values()) {
			maxVowels = Math.max(maxVowels, value);
		}
		
		int maxConsonant = 0;
		for (Integer value : consonant.values()) {
			maxConsonant = Math.max(maxConsonant, value);
		}
		return maxConsonant + maxVowels;
	}
}
