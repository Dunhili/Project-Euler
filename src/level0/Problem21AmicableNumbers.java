package level0;

/*
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which 
 * divide evenly into n).
 * 
 * If d(a) = b and d(b) = a, where a /= b, then a and b are an amicable pair and each 
 * of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; 
 * therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 *
 * ANSWER: 31626
 */

public class Problem21AmicableNumbers {
	public static void main(String[] args) {
		int limit = 10000;
		int[] numbers = new int[limit];
		int currentSum = 1;
		
		//Computes the factors
		for (int i = 2; i < limit; i++) {
			for (int j = 2; j <= (int) Math.sqrt(i); j++) {
				if (i % j == 0 && i != j) {
					currentSum += j;
					if ((i / j) != j)
						currentSum += (i / j);
				}
			}
			numbers[i] = currentSum;
			currentSum = 1;
		}
		
		int totalSum = 0;
		int b;
		for (int a = 2; a < limit; a++) {
			b = numbers[a];
			if (b < limit) {
				if (a == numbers[b] && a != b)
					totalSum += a;
			}
		}
		System.out.println("The sum of all amicable numbers under " + limit + " is " + totalSum + ".");
	}
}
