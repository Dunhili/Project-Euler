package level1;

/*
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 *
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 *
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 * 
 * ANSWER: 40730
 */

public class Problem34DigitFactorials {
	public static void main(String[] args) {
		int sum = 0;
		int upperLimit = 100000;
		int localSum;
		// list of factorials from 0! to 9!
		int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
		String str;
		
		for (int i = 3; i < upperLimit; i++) {
			str = i + "";
			localSum = 0;
			for (int j = 0; j < str.length(); j++)
				localSum += factorials[Integer.parseInt(str.charAt(j) + "")];
			if (localSum == i)
				sum += i;
		}
		System.out.println("The sum of all the factorial digit sums is " + sum + ".");
	}
}
