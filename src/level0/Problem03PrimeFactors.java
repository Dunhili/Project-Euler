package level0;

import java.math.BigInteger;
import java.util.ArrayList;

/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143?
 * 
 * ANSWER: 6857
 */

public class Problem03PrimeFactors {
	public static void main(String[] args) {
		BigInteger number = new BigInteger("600851475143");
		BigInteger highestFactor = new BigInteger("1");
		ArrayList<BigInteger> factors = new ArrayList<BigInteger>();
		int n = 775146;			//sqrt of 600851475143
		
		for (int i = 2; i < n; i++) {
			BigInteger mod = new BigInteger(i + "");
			if (number.mod(mod).equals(BigInteger.ZERO)) {
				factors.add(mod);
				factors.add(number.divide(mod));
			}
		}
		
		System.out.println("Factors are " + factors);
		BigInteger factor;
		for (int j = 0; j < factors.size(); j++) {
			factor = factors.get(j);
			BigInteger k = new BigInteger("2");
			BigInteger condition = factor.divide(new BigInteger("2"));
			for (k = new BigInteger("2"); k.compareTo(condition) <= 0; k = k.add(BigInteger.ONE)) {
				if (factor.mod(k).equals(BigInteger.ZERO))
					break;
				if (k.equals(condition)) {
					if (factor.compareTo(highestFactor) > 0)
						highestFactor = factor;
				}
			}
		}
		
		System.out.println("Largest prime factor is " + highestFactor + ".");
	}
}
