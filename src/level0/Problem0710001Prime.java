package level0;

/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
 * we can see that the 6th prime is 13.
 *
 * What is the 10,001st prime number?
 * 
 * ANSWER: 104743
 */

public class Problem0710001Prime {
	public static void main(String[] args) {
		int prime = 1;				//skipping 2
		int i, upperBound;
		int currentNumber = 1;
		
		while (prime != 10001) {
			currentNumber += 2;
			upperBound = (int) Math.sqrt(currentNumber);
			for (i = 2; i <= upperBound; i++) {
				if (currentNumber % i == 0)
					break;
			}
			
			//If the for loop was completed, i is a prime number
			if (i > upperBound) {
				++prime;
			}	
		}
		
		System.out.println("The 10001st prime number is " + currentNumber + ".");
	}

}
