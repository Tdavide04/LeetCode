package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Problem_118 {

	// 118. Pascal's Triangle
	/*
	 * Given an integer numRows, return the first numRows of Pascal's triangle.
	 * 
	 * In Pascal's triangle, each number is the sum of the two numbers directly
	 * above it as shown:
	 * 
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: numRows = 5 Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]] Example
	 * 2:
	 * 
	 * Input: numRows = 1 Output: [[1]]
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= numRows <= 30
	 */
	public static void main(String args[]) {
		System.out.println("Expected [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]. Result " + generate(5));
		
	}
	public static List<List<Integer>> generate(int numRows) {
	    List<List<Integer>> result = new ArrayList<>();
	    for (int i = 0; i < numRows; i++) {
	        // Create a new list to represent the current row
	        List<Integer> row = new ArrayList<>();

	        // Loop through each position in the current row
	        for (int j = 0; j <= i; j++) {
	            // The first and last elements of each row are always 1
	            if (j == 0 || j == i) {
	                row.add(1);
	            } else {
	                // Each inner element is the sum of the two elements above it from the previous row
	                int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
	                row.add(val);
	            }
	        }
	        result.add(row);
	    }
	    return result;
	}

}
