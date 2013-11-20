package level0;

/*
 * The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle 
 * number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
 * 
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * 
 * Let us list the factors of the first seven triangle numbers:
 *
 *    1: 1
 *    3: 1,3
 *    6: 1,2,3,6
 *   10: 1,2,5,10
 *   15: 1,3,5,15
 *   21: 1,3,7,21
 *   28: 1,2,4,7,14,28
 *
 * We can see that 28 is the first triangle number to have over five divisors.
 *
 * What is the value of the first triangle number to have over five hundred divisors?
 * 
 * ANSWER: 76576500
 */

public class Problem12TriangleDivisor {
	public static void main(String[] args) {
		int triangleNumber = 1;
		int sum = 0;
		int numberFactors, sqrt;
		
		boolean found = false;
		
		while (!found) {
			sum = (triangleNumber * (triangleNumber + 1)) / 2;
			sqrt = (int) Math.sqrt(sum) + 1;
			numberFactors = 0;
			
			for (int i = 1; i < sqrt; i++) {
				if (sum % i == 0)
					numberFactors += 2;
			}
			
			if (numberFactors >= 500)
				found = true;
			else
				++triangleNumber;
		}
		
		System.out.println("Triangle Number with over 500 factors is : " + sum);
	}
}
