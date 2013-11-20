package level0;

/*
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 
 * 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers 
 * from 1 to 20?
 *
 * ANSWER: 232792560
 */

public class Problem05SmallestMultiple {
	public static void main(String[] args) {
		boolean found = false;
		int number = 20;			//starting point
		
		while (!found) {
			for (int i = 2; i <= 20; i++) {
				if (number % i != 0)
					break;
				if (i == 20) {
					System.out.println("Smallest Remainder is " + number);
					found = true;
				}
			}
			if (!found)
				++number;
		}
	}
}
