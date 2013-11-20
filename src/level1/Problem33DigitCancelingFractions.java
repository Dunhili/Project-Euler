package level1;

/*
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician 
 * in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which 
 * is correct, is obtained by canceling the 9s.
 *
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 *
 * There are exactly four non-trivial examples of this type of fraction, less 
 * than one in value, and containing two digits in the numerator and denominator.
 *
 * If the product of these four fractions is given in its lowest common terms, find 
 * the value of the denominator.
 *
 * ANSWER: 
 */

public class Problem33DigitCancelingFractions {
	public static void main(String[] args) {
		int numerator, denominator, cd, x, y;
		
		for (int a = 10; a < 100; a++) {
			for (int b = a + 1; b < 100; b++) {
				cd = gcd(a, b);
				numerator = a / cd;
				denominator = b / cd;
				
				x = a / 10;
				y = b / 10;
				cd = gcd(x, y);
				x /= cd;
				y /= cd;
				if (x == numerator && y == denominator)
					System.out.println(a + " " + b);
				
				if ((b % 10) != 0) {
					x = a / 10;
					y = b % 10;
					cd = gcd(x, y);
					x /= cd;
					y /= cd;
					if (x == numerator && y == denominator)
						System.out.println(a + " " + b);
				}
				
				if ((a % 10) != 0) {
					x = a % 10;
					y = b / 10;
					cd = gcd(x, y);
					x /= cd;
					y /= cd;
					if (x == numerator && y == denominator)
						System.out.println(a + " " + b);
				}
				
				if (((a % 10) != 0) && ((b % 10) != 0)) {
					x = a % 10;
					y = b % 10;
					cd = gcd(x, y);
					x /= cd;
					y /= cd;
					if (x == numerator && y == denominator)
						System.out.println(a + " " + b);
				}
			}
		}
	}
	
	public static int gcd(int a, int b) {
	   if (b == 0) 
		   return a;
	   return gcd(b, a % b);
	}
}
