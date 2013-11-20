package level0;

/*
 * A palindromic number reads the same both ways. The largest palindrome made from the product 
 * of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * ANSWER: 906609
 */

public class Problem04LargestPalindromeProduct {
	public static void main(String[] args) {
		int product;
		String str;
		int largestPalindrome = 1;
		
		for (int n1 = 100; n1 < 1000; n1++) {
			for (int n2 = 100; n2 < 1000; n2++) {
				product = n1 * n2;
				str = product + "";
				int i;
				for (i = 0; i < str.length() / 2; i++) {
					if (str.charAt(i) != str.charAt(str.length() - i - 1))
						break;
				}
				
				if (i == str.length() / 2) {
					if (product > largestPalindrome)
						largestPalindrome = product;
				}
			}
		}
		
		System.out.println("Largest Palindrome : " + largestPalindrome);
	}
}
