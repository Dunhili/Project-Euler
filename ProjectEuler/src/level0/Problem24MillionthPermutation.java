package level0;

/*
 * A permutation is an ordered arrangement of objects. For example, 3124 is one 
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations 
 * are listed numerically or alphabetically, we call it lexicographic order. The 
 * lexicographic permutations of 0, 1 and 2 are:
 *
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 
 * 6, 7, 8 and 9?
 *
 * ANSWER: 2783915460
 */

public class Problem24MillionthPermutation {
	public static void main(String[] args) {
		String permutation = "";
		String possibleNumbers = "0123456789";
		int remainder = 999999;
		int digit, factorial;
		
		for (int i = 1; i <= 10; i++) {
			factorial = factorial(10 - i);
			digit = remainder / factorial;
			permutation += (possibleNumbers.charAt(digit) + "");
			possibleNumbers = possibleNumbers.replace(possibleNumbers.charAt(digit) + "", "");
			remainder -= digit * factorial;
		}
		
		System.out.println("The millionth permutation is " + permutation + ".");
	}
	
	public static int factorial(int n) {
		if (n < 2)
			return 1;
		return n * factorial(n - 1);
	}
}
