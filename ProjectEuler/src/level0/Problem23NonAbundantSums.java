package level0;

import java.util.ArrayList;

/*
 * A perfect number is a number for which the sum of its proper divisors is exactly 
 * equal to the number. For example, the sum of the proper divisors of 28 would be 
 * 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n and 
 * it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number 
 * that can be written as the sum of two abundant numbers is 24. By mathematical analysis, 
 * it can be shown that all integers greater than 28123 can be written as the sum of two 
 * abundant numbers. However, this upper limit cannot be reduced any further by analysis 
 * even though it is known that the greatest number that cannot be expressed as the sum of 
 * two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant 
 * numbers.
 *
 * ANSWER: 4179871
 */

public class Problem23NonAbundantSums {
	public static void main(String[] args) {
		int upperLimit = 28123;
		ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
		int currentSum;
		int[] abundantNumberSum = new int[upperLimit + 1];
		int sum = 0;
		
		// Finds all the abundant numbers under the upper limit
		for (int i = 1; i <= upperLimit; i++) {
			currentSum = 1;
			for (int j = 2; j <= (int) Math.sqrt(i); j++) {
				if (i % j == 0 && i != j) {
					currentSum += j;
					if ((i / j) != j)
						currentSum += (i / j);
				}
			}
			
			// Checks if i is an abundant number
			if (currentSum > i) 
				abundantNumbers.add(new Integer(i));
		}
		
		// Initializes the array which contains all the numbers which are
		// not the sum of two abundant numbers
		for (int k = 0; k <= upperLimit; k++)
			abundantNumberSum[k] = k;
		
		// Iterates through all the possible sums of pairs of abundant numbers
		// and removes those numbers from the abundant number array
		int size = abundantNumbers.size();
		int abNum1, abNum2, abSum;
		for (int n1 = 0; n1 < size; n1++) {
			abNum1 = abundantNumbers.get(n1).intValue();
			for (int n2 = n1; n2 < size; n2++) {
				abNum2 = abundantNumbers.get(n2).intValue();
				abSum = abNum1 + abNum2;
				// Removes the number from the array
				if (abSum <= upperLimit)
					abundantNumberSum[abSum] = 0;
				else
					break;
			}
		}
		
		// Sums up all the remaining numbers
		for (int l = 0; l <= upperLimit; l++)
			sum += abundantNumberSum[l];
		
		System.out.println("The sum of all the numbers that aren't sums of abundant numbers" +
				" are " + sum + ".");
	}
}
