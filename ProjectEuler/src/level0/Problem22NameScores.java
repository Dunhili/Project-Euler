package level0;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file 
 * containing over five-thousand first names, begin by sorting it into alphabetical 
 * order. Then working out the alphabetical value for each name, multiply this value 
 * by its alphabetical position in the list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 
 * 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a 
 * score of 938 x 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 * 
 * ANSWER: 871198282
 */

public class Problem22NameScores {
	public static void main(String[] args) throws IOException {
		try {
			// Reads from the input file
			FileInputStream fstream = new FileInputStream("Problem22Names.txt");
			DataInputStream input = new DataInputStream(fstream);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line = reader.readLine();
			ArrayList<String> lines = new ArrayList<String>();
			
			// Parses the lines and gets the names
			Scanner scan = new Scanner(line).useDelimiter(",");
			while (scan.hasNext())
				lines.add(scan.next());
			
			String[] names = lines.toArray(new String[lines.size()]);
			Arrays.sort(names);
			findNameScore(names);
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Could not find file.");
		}
	}
	
	public static void findNameScore(String[] names) {
		BigInteger sum = new BigInteger("0");
		int score = 0;
		String name;
		for (int i = 0; i < names.length; i++) {
			score = 0;
			name = names[i].replace("\"", "");
			
			for (int j = 0; j < name.length(); j++) 
				score += (int) name.charAt(j) - 64;
				
			score *= i + 1;
			sum = sum.add(new BigInteger(score + ""));
		}
		
		System.out.println("The score for this file is " + sum.toString() + ".");
	}
}
