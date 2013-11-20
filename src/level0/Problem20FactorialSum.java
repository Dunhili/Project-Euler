package level0;

import java.math.BigInteger;

/*
 * n! means n x (n - 1) x ... x 3 x 2 x 1
 * 
 * For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 * 
 * ANSWER: 648
 */

public class Problem20FactorialSum {
	public static void main(String[] args) {
		int N = 100;
		BigInteger factorial = new BigInteger("1");
		int sum = 0;
		String str;
		
		for (int i = 1; i <= N; i++)
			factorial = factorial.multiply(new BigInteger(i + ""));
		
		str = factorial.toString();
		for (int j = 0; j < str.length(); j++)
			sum += Integer.parseInt(str.charAt(j) + "");
		
		System.out.println("The sum of the digits of 100! is " + sum + ".");
	}
}
