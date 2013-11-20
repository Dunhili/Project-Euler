package level1;

/*
 * A unit fraction contains 1 in the numerator. The decimal 
 * representation of the unit fractions with denominators 2 to 10 are given:
 * 
 * 1/2  = 0.5
 * 1/3  = 0.(3)
 * 1/4  = 0.25
 * 1/5  = 0.2
 * 1/6  = 0.1(6)
 * 1/7  = 0.(142857)
 * 1/8  = 0.125
 * 1/9  = 0.(1)
 * 1/10 = 0.1
 * 
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen 
 * that 1/7  has a 6-digit recurring cycle.
 *
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in 
 * its decimal fraction part.
 * 
 * ANSWER: 983
 */

public class Problem26ReciprocalCycles {
	public static void main(String[] args) {
		int largestD = 0;
		int longestCycleLength = 0;
		int remainder, cycleLength;
		
		for (int d = 1000; d > 1; d--) {
			//Stops the loop once the cycle length is greater than d,
			//since we can't find a longer cycle length at that point.
			if (longestCycleLength > d)
				break;
			
			cycleLength = 0;
			remainder = 1;
			int[] numberRemainders = new int[d];
			
			//Continues until we either have a remainder of zero (no cycle)
			//or until we have a duplicate remainder.
			while (numberRemainders[remainder] == 0 && remainder != 0) {
				numberRemainders[remainder] = 1;
				remainder *= 10;
				remainder %= d;
				++cycleLength;
			}
			
			if (cycleLength > longestCycleLength) {
				longestCycleLength = cycleLength;
				largestD = d;
			}
		}
		
		System.out.println("The longest cycle is length " + longestCycleLength + 
				" with the value of d being " + largestD + ".");
	}
}
