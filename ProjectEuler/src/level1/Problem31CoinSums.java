package level1;

/*
 * In England the currency is made up of pound, £, and pence, p, and there are 
 * eight coins in general circulation:
 * 
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * 
 * It is possible to make £2 in the following way:
 * 
 * 1x£1 + 1x50p + 2x20p + 1x5p + 1x2p + 3x1p
 * 
 * How many different ways can £2 be made using any number of coins?
 * 
 * ANSWER: 73682
 */

public class Problem31CoinSums {
	public static void main(String[] args) {
		int target = 200;
		int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
		int[][] table = new int[target + 1][coins.length];
		
		//Initialize the first column in the matrix, there is 1 way to make
		//the target number of coins if we can only use 1p
		for (int i = 0; i <= target; i++)
			table[i][0] = 1;
		
		//We need to find the rest of the number of ways to make the target number
		//of coins when we can use more than 1p
		for (int j = 0; j <= target; j++) {
			for (int k = 1; k < coins.length; k++) {
				table[j][k] = 0;
				//If our target is greater than the current value of coins, then
				//we need to add the number of ways to create the target from the
				//previous column and the number of ways with the remainder of coins
				if (j >= coins[k]) {
					table[j][k] += table[j][k - 1];
					table[j][k] += table[j - coins[k]][k];
				}
				//If our target is less than the current value of coins, then
				//the number of ways we can reach the target is the previous column
				else {
					table[j][k] = table[j][k - 1];
				}
			}
		}
		System.out.println("The number of different ways we can make £2 is " 
		+ table[target][coins.length - 1] + ".");
	}
}
