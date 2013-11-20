package level0;

import java.math.BigInteger;

/*
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 *
 * ANSWER: 1366
 */

public class Problem16PowerDigitSum {
	public static void main(String[] args) {
		BigInteger N = new BigInteger("2");
		N = N.pow(1000);
		int sum = 0;
		
		String str = N.toString();
		for (int j = 0; j < str.length(); j++) 
			sum += Integer.parseInt(str.charAt(j) + "");
		
		System.out.println("The sum of the digits of 2^1000 is " + sum + ".");
	}
}
