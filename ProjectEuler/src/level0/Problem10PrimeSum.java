package level0;

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 * 
 * ANSWER: 142913828922
 */

public class Problem10PrimeSum {
	public static void main(String[] args) {
		int upperLimit = 2000000;
		int sqrt;
		long sum = 0;
		
		for (int i = 2; i < upperLimit; i++) {
			sqrt = (int) Math.sqrt(i) + 1;
			for (int j = 2; j <= sqrt; j++) {
				if (i % j == 0 && i != j)
					break;
				if (j == sqrt)
					sum += i;
			}
		}
		
		System.out.println("Sum of all primes from 1 to 2,000,000 is " + sum + ".");
	}
}
