import java.util.Scanner;


public class Astrology {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("What was the date of your birth? (e.g. July 4, 1776): ");
		String month = in.next(); String day = in.next(); String year = in.next();
		String bDay= month+day+year;
		
		
		String month3 = month.substring(0,3);
		
		
		boolean jan3 = month3.equals("Jan");
		boolean feb3 = month3.equals("Feb");
		boolean mar3 = month3.equals("Mar");
		boolean apr3 = month3.equals("Apr");
		boolean may3 = month3.equals("May");
		boolean jun3 = month3.equals("Jun");
		boolean jul3 = month3.equals("Jul");
		boolean aug3 = month3.equals("Aug");
		boolean sep3 = month3.equals("Sep");
		boolean oct3 = month3.equals("Oct");
		boolean nov3 = month3.equals("Nov");
		boolean dec3 = month3.equals("Dec");
		
		String yearString = "";
		String dayString = "";
		String weekday = "";
		
		int monthNum = 0;
		
		if (jan3 == true || oct3 == true)
			{
				if (bDay.length() == 13)
				{
					dayString = bDay.substring(7,8);
					yearString = bDay.substring(9,13);
				}
				
				else
				{
					dayString = bDay.substring(7,9);
					yearString = bDay.substring(10,14);
				}
				
					if (jan3 == true)
					monthNum = 1;
				else
					monthNum = 10;
			}
		else if (feb3 == true || nov3 == true || dec3 == true)
			{
				
				if(bDay.length() == 14)
				{
					dayString = bDay.substring(8,9);
					yearString = bDay.substring(10,14);
				}
				else
				{
					dayString = bDay.substring(8,10);
					yearString = bDay.substring(11,15);
				}
				
				if (feb3 == true)
					monthNum = 2;
				else if (nov3 == true)
					monthNum = 11;
				else
					monthNum = 12;
			}
		else if (mar3 == true || apr3 == true)
			{
				if(bDay.length() == 11)
				{
					dayString = bDay.substring(5,6);
					yearString = bDay.substring(7,11);
				}
				else
				{
					dayString = bDay.substring(5,7);
					yearString = bDay.substring(8,12);
				}
				
				if(mar3 == true)
					monthNum = 3;
				else
					monthNum = 4;
			}
		else if (may3 == true)
			{
				if(bDay.length() == 9)
				{
					dayString = bDay.substring(3,4);
					yearString = bDay.substring(5,9);
				}
				else
				{
					dayString = bDay.substring(3,5);
					yearString = bDay.substring(6,10);
				}
				
				monthNum = 5;
			}
		else if (jun3 == true || jul3 == true)
			{
				if(bDay.length() == 10)
				{
					dayString = bDay.substring(4,5);
					yearString = bDay.substring(6,10);
				}
				else
				{
					dayString = bDay.substring(4,6);
					yearString = bDay.substring(7,11);
				}
				
				if(jun3 == true)
					monthNum = 6;
				else
					monthNum = 7;
			}
		else if (aug3 == true)
			{
				if(bDay.length() == 12)
				{
					dayString = bDay.substring(6,7);
					yearString = bDay.substring(8,12);
				}
				else
				{
					dayString = bDay.substring(6,8);
					yearString = bDay.substring(9,13);
				}
				monthNum = 8;
			}
		else if (sep3 == true)
			{
				if(bDay.length() == 15)
				{
					dayString = bDay.substring(9,10);
					yearString = bDay.substring(11,15);
				}
				else
				{
					dayString = bDay.substring(9,11);
					yearString = bDay.substring(12,16);
				}
				
				monthNum = 9;
			}
		
		int dayNum = Integer.parseInt(dayString);
		int yearNum = Integer.parseInt(yearString);
		
		int a = (14 - monthNum)/12;
		int y = yearNum - a;
		int m = monthNum + 12*a-2;
		int d = (dayNum + y + y/4 - y/100 + y/400 + (31*m)/12)%7;
		
		if(d == 0)
			weekday = "Sunday";
		else if (d == 1)
			weekday = "Monday";
		else if (d == 2)
			weekday = "Tuesday";
		else if (d == 3)
			weekday = "Wednesday";
		else if (d == 4)
			weekday = "Thursday";
		else if (d == 5)
			weekday = "Friday";
		else if (d == 6)
			weekday = "Saturday";
		
		boolean leapYear;
		
		if (yearNum % 400 == 0)
			leapYear = true;
		else if (yearNum % 100 == 0)
			leapYear = false;
		
		else if (yearNum % 4 == 0)
			leapYear = true;
		else
			leapYear = false;
		
		String chineseZodiac = "";
		
		if (yearNum % 12 == 0)
			chineseZodiac = "Monkey";
		else if (yearNum % 12 == 1)
			chineseZodiac = "Rooster";
		else if (yearNum % 12 == 2)
			chineseZodiac = "Dog";
		else if (yearNum % 12 == 3)
			chineseZodiac = "Boar";
		else if (yearNum % 12 == 4)
			chineseZodiac = "Rat";
		else if (yearNum % 12 == 5)
			chineseZodiac = "Ox";
		else if (yearNum % 12 == 6)
			chineseZodiac = "Tiger";
		else if (yearNum % 12 == 7)
			chineseZodiac = "Rabbit";
		else if (yearNum % 12 == 8)
			chineseZodiac = "Dragon";
		else if (yearNum % 12 == 9)
			chineseZodiac = "Snake";
		else if (yearNum % 12 == 10)
			chineseZodiac = "Horse";
		else if (yearNum % 12 == 11)
			chineseZodiac = "Ram";
		
	System.out.println(month + " " + day + " " + year + " was a " + weekday + ".");
	if(leapYear == true)
		System.out.println(yearNum + " was a leap year.");
	else
		System.out.println(yearNum + " was not a leap year.");
	System.out.println("Your Chinese zodiac sign is " + chineseZodiac + ".");
		
		
		
		/*System.out.println(dayString);
		System.out.println(yearString);
		
		System.out.println(dayNum);
		System.out.println(yearNum);
		System.out.println(monthNum);
		
		boolean jan = month.equals("January");//7-
		boolean feb = month.equals("February");	//8-
		boolean mar = month.equals("March");	//5-
		boolean apr = month.equals("April");	//5-
		boolean may = month.equals("May");		//3-
		boolean jun = month.equals("June");		//4-
		boolean jul = month.equals("July");		//4-
		boolean aug = month.equals("August");	//6-
		boolean sep = month.equals("September");//9-
		boolean oct = month.equals("October");	//7-
		boolean nov = month.equals("November");	//8-
		boolean dec = month.equals("December");	//8-
		
		System.out.println(jan);*/

	}

}
