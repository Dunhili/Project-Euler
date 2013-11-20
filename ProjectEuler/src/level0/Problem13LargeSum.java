package level0;

import java.io.*;
import java.math.BigInteger;

/*
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * (In Problem13Numbers.txt)
 * 
 * ANSWER: 5537376230
 */

public class Problem13LargeSum {
	public static void main(String[] args) throws IOException {
		FileInputStream fstream = new FileInputStream("Problem13Numbers.txt");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String number;
		BigInteger sum = new BigInteger("0");
		
		while ((number = br.readLine()) != null) 
			sum = sum.add(new BigInteger(number));
		
		System.out.println("Sum is " + sum.toString());
		System.out.println("\nFirst 10 digits are " + sum.toString().substring(0, 10));
	}
}
