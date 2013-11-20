package level0;

/*
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 *  1 Jan 1900 was a Monday.
 *  Thirty days has September,
 *  April, June and November.
 *  All the rest have thirty-one,
 *  Saving February alone,
 *  Which has twenty-eight, rain or shine.
 *  And on leap years, twenty-nine.
 *  A leap year occurs on any year evenly divisible by 4, but not on a century unless it is 
 *     divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 
 * to 31 Dec 2000)?
 *
 * ANSWER: 171
 */

public class Problem19CountingSundays {
	public static void main(String[] args) {
		int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
		//Starts on a Tuesday
		int dayOfTheWeek = 2;
		int numberSundays = 0;
	
		for (int year = 1901; year <= 2000; year++) {
			if (year % 400 == 0)
				monthDays[1] = 29;
			else if (year % 4 == 0 && year % 100 != 0)
				monthDays[1] = 29;
			else
				monthDays[1] = 28;
		
			for (int month = 0; month < 12; month++) {
				if (dayOfTheWeek == 0)
					++numberSundays;
				dayOfTheWeek += monthDays[month];
				dayOfTheWeek %= 7;
				
			}
		}
	
		System.out.println("The number of months that start with a Sunday is " + numberSundays + ".");
	}
}
