package utils;

import java.math.BigInteger;

public class HelperMethods {
	private HelperMethods() { /* Can't be initialized */ };
	
	// 0! to 25!
	private static String precomputedFactorials[] = {
		"1",
		"1",
		"2",
		"6",
		"24",
		"120",
		"720",
		"5040",
		"40320",
		"362880",
		"3628800",
		"39916800",
		"479001600",
		"6227020800",
		"87178291200",
		"1307674368000",
		"20922789888000",
		"355687428096000",
		"6402373705728000",
		"121645100408832000",
		"2432902008176640000",
		"51090942171709440000",
		"1124000727777607680000",
		"25852016738884976640000",
		"620448401733239439360000",
		"15511210043330985984000000"
	};
	
	/**
	 * Calculates n! and returns a BigInteger for the result. 
	 * @param n n!
	 * @return BigInteger with the result
	 */
	public static BigInteger factorial(int n) {
		if (n < 0) {
			return new BigInteger("0");
		}
		else if (n < precomputedFactorials.length) {
			return new BigInteger(precomputedFactorials[n]);
		}
		
		// if the factorial is bigger than the list, then 
		// start from the largest value and go from there
		BigInteger factorial = new BigInteger(
				precomputedFactorials[precomputedFactorials.length - 1]);
		
		for (int i = precomputedFactorials.length; i < n; i++) {
			factorial = factorial.multiply(new BigInteger(i + ""));
		}
		return factorial;
	}
	
	/**
	 * Returns true if n is prime, false otherwise.
	 * @param n number to test if it is prime
	 * @return true if prime, false otherwise
	 */
	public static boolean isPrime(int n) {
		// if n is even and not 2
		if ((n & 1) == 0 && n != 2) {
			return false;
		}
		
		int upperBound = (int) Math.sqrt(n);
		for (int i = 2; i <= upperBound; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Calculates the nth fibonacci number in the sequence.
	 * @param n nth number in the fibonacci sequence to calculate
	 * @return nth sequence number
	 */
	public static int fibonacci(int n) {
		if (n == 0 || n == 1 || n == 2) {
			return 1;
		}
		else if (n == 3) {
			return 2;
		}
		
		int n1 = 1;
		int n2 = 1;
		int n3 = 2;
		for (int i = 3; i <= n; i++) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		
		return n3;
	}
}
