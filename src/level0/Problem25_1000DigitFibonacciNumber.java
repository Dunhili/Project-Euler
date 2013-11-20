package level0;

import java.math.BigInteger;

/* 
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 *  Fn = Fn-1 + Fn-2, where F1 = 1 and F2 = 1.
 *
 * Hence the first 12 terms will be:
 *
 *  F1 = 1
 *  F2 = 1
 *  F3 = 2
 *  F4 = 3
 *  F5 = 5
 *  F6 = 8
 *  F7 = 13
 *  F8 = 21
 *  F9 = 34
 *  F10 = 55
 *  F11 = 89
 *  F12 = 144
 *
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 * 
 * ANSWER: 4782
 */
public class Problem25_1000DigitFibonacciNumber {
	public static void main(String[] args) {
		BigInteger n1 = BigInteger.ONE;				//F1
		BigInteger n2 = BigInteger.ONE;		  		//F2
		BigInteger n3 = BigInteger.ONE;
		int term = 2;
		
		while (n2.toString().length() != 1000) {
			n3 = n1.add(n2);
			n1 = n2;
			n2 = n3;
			++term;
		}
		
		System.out.println("The first fibonacci term with length 1000 is " + term + ".");
	}
}
