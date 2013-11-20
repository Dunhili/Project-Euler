package level1;

/*
 * Euler published the remarkable quadratic formula:
 * 
 * n^2 + n + 41
 *
 * It turns out that the formula will produce 40 primes for the 
 * consecutive values n = 0 to 39. However, when n = 40, 40^2 + 
 * 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41,
 * 41^2 + 41 + 41 is clearly divisible by 41.
 * 
 * Using computers, the incredible formula  n^2 - 79n + 1601 was discovered, 
 * which produces 80 primes for the consecutive values n = 0 to 79. The product 
 * of the coefficients, -79 and 1601, is -126479.
 * 
 * Considering quadratics of the form:
 *
 *  n^2 + an + b, where |a| < 1000 and |b| < 1000
 *
 *  where |n| is the modulus/absolute value of n
 *  e.g. |11| = 11 and |-4| = 4
 *
 * Find the product of the coefficients, a and b, for the quadratic expression 
 * that produces the maximum number of primes for consecutive values of n, 
 * starting with n = 0.
 * 
 * ANSWER: -59231
 */

public class Problem27QuadraticFormula {
	public static void main(String[] args) {
		int numberCoefficients;
		int product = 0;
		int maxCoefficients = 0;

		for (int a = -1000; a <= 1000; a++) {
			for (int b = -1000; b <= 1000; b++) {
				if (!isPrime(b))
					continue;
				
				numberCoefficients = findNumberCoefficients(a, b);
				if (numberCoefficients > maxCoefficients) {
					maxCoefficients = numberCoefficients;
					product = a * b;
				}
			}
		}
		
		System.out.println("The product of a and b with the largest number of coefficients is " 
				+ product + ".");
	}
	
	public static int findNumberCoefficients(int a, int b) {
		boolean continueFindingCoefficients = true;
		int result;
		int n = 0;
		
		while (continueFindingCoefficients) {
			result = n * n + a * n + b;
			continueFindingCoefficients = isPrime(result);
			if (continueFindingCoefficients)
				++n;
		}
		return n;
	}
	
	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		int upperBound = (int) Math.sqrt(n);
		for (int i = 2; i <= upperBound; i++) {
			if (n % i == 0 && i != upperBound)
				return false;
		}
		return true;
	}
}
