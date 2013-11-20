package level1;

/*
 * Surprisingly there are only three numbers that can be written as the sum of fourth 
 * powers of their digits:
 *
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * 
 * As 1 = 1^4 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 * 
 * ANSWER: 443839
 */

public class Problem30SumFifthPowers {
	public static void main(String[] args) {
		int n = 2;
		int sum = 0;
		int localSum;
		String number;
		
		while (n < 1000000) {
			localSum = 0;
			number = n + "";
			for (int i = 0; i < number.length(); i++)
				localSum += (int) Math.pow(Integer.parseInt(number.charAt(i) + ""), 5);
			
			if (localSum == n) 
				sum += n;
			++n;
		}
		
		System.out.println("The sum of the numbers is " + sum + ".");
	}
}
