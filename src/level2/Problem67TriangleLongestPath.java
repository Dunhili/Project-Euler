package level2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, 
 * the maximum total from top to bottom is 23.
 *
 *		3
 *	   7 4
 * 	  2 4 6
 *   8 5 9 3
 * 
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), 
 * a 15K text file containing a triangle with one-hundred rows.
 * 
 * NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to 
 * solve this problem, as there are 2^99 altogether! If you could check one trillion (10^12) routes 
 * every second it would take over twenty billion years to check them all. There is an efficient 
 * algorithm to solve it. ;o)
 * 
 * ANSWER: 7273
 */

public class Problem67TriangleLongestPath {
	public static void main(String[] args) throws IOException {
		try {
			// Reads from the input file
			FileInputStream fstream = new FileInputStream("Problem67Triangle.txt");
			DataInputStream input = new DataInputStream(fstream);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			ArrayList<String> lines = new ArrayList<String>();
		
			// Parses the lines and gets the names
			String line;
			while ((line = reader.readLine()) != null)
				lines.add(line);
			
			reader.close();
			findLongestPath(lines);
		}
		catch (IOException e) {
			System.out.println("Could not find file.");
		}
	}
	
	public static void findLongestPath(ArrayList<String> lines) {
		int numberRows = lines.size();
		int[][] triangle = new int[numberRows][numberRows];
		int number;
		Scanner scan;
		
		for (int i = 0; i < numberRows; i++) {
			scan = new Scanner(lines.get(i));
			for (int j = 0; j <= i; j++) {
				number = Integer.parseInt(scan.next());
				triangle[i][j] = number;
			}
		}
		
		for (int i = 1; i < numberRows; i++) {
			for (int j = 0; j <= i; j++) {
				//At the left edge
				if (j == 0)
					triangle[i][j] = triangle[i][j] + triangle[i - 1][j];
				//At the right edge
				else if (i == j)
					triangle[i][j] = triangle[i][j] + triangle[i - 1][j - 1];
				//In the middle of the row
				else
					triangle[i][j] = max(triangle[i][j] + triangle[i - 1][j - 1], 
							triangle[i][j] + triangle[i - 1][j]);
			}
		}
		
		//Iterates over the elements in the final row to find the longest path
		int longestPath = 0;
		for (int k = 0; k < numberRows; k++) {
			if (triangle[numberRows - 1][k] > longestPath)
				longestPath = triangle[numberRows - 1][k];
		}

		System.out.println("The longest path is " + longestPath + ".");
	}
	
	public static int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}
}
