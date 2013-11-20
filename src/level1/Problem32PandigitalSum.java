package level1;

import java.util.ArrayList;

/*
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 
 * 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 x 186 = 7254, containing multiplicand, 
 * multiplier, and product is 1 through 9 pandigital.
 *
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written 
 * as a 1 through 9 pandigital.
 * HINT: Some products can be obtained in more than one way so be sure to only include it once 
 * in your sum.
 *
 * ANSWER: 45228
 */
public class Problem32PandigitalSum {
	public static void main(String[] args) {
		ArrayList<Integer> listOfProducts = new ArrayList<Integer>();
		int sum = 0;
		int product;
		
		//Iterate over the possible values of a and b
		for (int a = 1; a < 100; a++) {
			for (int b = a + 1; b < 10000; b++) {
				product = a * b;
				if (checkPandigital(a, b, product) && !listOfProducts.contains(product)) {
					listOfProducts.add(product);
					sum += product;
				}
			}
		}
		
		System.out.println("The sum of all the pandigital numbers (1 - 9) are " + sum + ".");
	}
	
	public static boolean checkPandigital(int a, int b, int product) {
		String pandigital = a + "" + b + "" + product;
		//If the string isn't exactly length 9, then it can't be a pandigital number
		if (pandigital.length() != 9)
			return false;
		
		//Used to keep track of the number of 1s - 9s
		int[] digits = {0, 0, 0, 0, 0, 0, 0, 0, 0};
		int number;
		
		//Increment the corresponding values in digits, if the number has a zero,
		//then it can't be a pandigital number
		for (int i = 0; i < pandigital.length(); i++) {
			number = Integer.parseInt(pandigital.charAt(i) + "");
			if (number == 0)
				return false;
			digits[number - 1]++;
		}
		
		//Check to see how many of each digit was in the number
		for (int j = 0; j < digits.length; j++) {
			if (digits[j] != 1)
				return false;
		}
		return true;
	}
}
