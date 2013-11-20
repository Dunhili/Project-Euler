package level0;

import java.util.HashMap;

/*
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, 
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, 
 * how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) 
 * contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of 
 * "and" when writing out numbers is in compliance with British usage.
 *
 * ANSWER: 21124
 */
public class Problem17NumberLetterCounts {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("0", "zero");
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put("4", "four");
		map.put("5", "five");
		map.put("6", "six");
		map.put("7", "seven");
		map.put("8", "eight");
		map.put("9", "nine");
		map.put("10", "ten");
		map.put("11", "eleven");
		map.put("12", "twelve");
		map.put("13", "thirteen");
		map.put("14", "fourteen");
		map.put("15", "fifteen");
		map.put("16", "sixteen");
		map.put("17", "seventeen");
		map.put("18", "eighteen");
		map.put("19", "nineteen");
		map.put("20", "twenty");
		map.put("30", "thirty");
		map.put("40", "forty");
		map.put("50", "fifty");
		map.put("60", "sixty");
		map.put("70", "seventy");
		map.put("80", "eighty");
		map.put("90", "ninety");
		map.put("100", "hundred");
		map.put("1000", "thousand");
		
		String str;
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i < 20) {
				str = map.get(i + "");
			}
			else if (i < 100) {
				if (i % 10 == 0)
					str = map.get(((i / 10) * 10) + "");
				else
					str = map.get(((i / 10) * 10) + "") + map.get((i % 10) + "");
			}
			else if (i < 1000) {
				if (i % 100 == 0) {
					str = map.get((i / 100) + "") + map.get("100");
				}
				else {
					if (i % 100 < 20)
						str = map.get((i / 100) + "") + map.get("100") + "and" +
								map.get((i % 100) + "");
					else if (i % 10 == 0)
						str = map.get((i / 100) + "") + map.get("100") + "and" + 
								map.get((((i % 100) / 10) * 10)+ "");
					else
						str = map.get((i / 100) + "") + map.get("100") + "and" + 
								map.get((((i % 100) / 10) * 10)+ "") + map.get((i % 10) + "");
				}
			}
			else
				str = "one" + map.get(i + "");
			
			sum += str.length();
		}
		
		System.out.println("The sum of the letters of the numbers 1 to 1000 is " + sum + ".");
	}
}
