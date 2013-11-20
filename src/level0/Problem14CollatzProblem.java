package level0;

/*
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 		13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 
 * 10 terms. Although it has not been proved yet (Collatz Problem), it is thought 
 * that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 * ANSWER: 837799
 */

public class Problem14CollatzProblem {
	public static void main(String[] args) {
		int chain;
		long currentNumber;
		int longestChain = 1;
		int longestChainNumber = 1;
		int limit = 1000000;	//1 million
		
		for (int startingNumber = 1; startingNumber < limit; startingNumber++) {
			currentNumber = startingNumber;
			chain = 1;
			while (currentNumber != 1) {
				//Even
				if (currentNumber % 2 == 0)
					currentNumber /= 2;
				//Odd
				else
					currentNumber = 3 * currentNumber + 1;
				++chain;
			}
			
			if (chain > longestChain) {
				longestChain = chain;
				longestChainNumber = startingNumber;
			}
		}
		
		System.out.println("Number that produces the longest chain is " + longestChainNumber + ".");
		System.out.println("The chain was of length " + longestChain + ".");
	}
}
