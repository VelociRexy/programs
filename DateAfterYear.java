import java.io.*;
public class DateAfterYear 
{
	static boolean checkLeap(int year) 
	{
		boolean leap = false;
		if (year % 4 == 0) 
		{
			leap = true;
			if (year % 100 == 0) 
			{
				if (year % 400 == 0)
					leap = true;
				else
					leap = false;
			}
		} 
		else
			leap = false;
		return leap;
	}	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("INPUT:\tDAY NUMBER\n\t");
		int day_num = Integer.parseInt(br.readLine());
		System.out.print("\tYear\n\t");
		int year = Integer.parseInt(br.readLine());
		System.out.print("\tDATE AFTER(N DAYS)\n\t");
		int date_after = Integer.parseInt(br.readLine());
		System.out.print("OUTPUT:\t");
		if (day_num >= 1 && day_num <= 366) 
		{
			if (date_after >= 1 && date_after <= 100) 
			{
				if (year >= 1000 && year <= 9999) 
				{
					String moname[] = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
					int num_of_days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
					if (checkLeap(year) == true) 
						num_of_days[1] = 29;
					if (checkLeap(year) == false && day_num > 365) 
					{
						System.out.print("DATE NUMBER OUT OF RANGE");
						return;
					}
					int sumDays = 0,i;
					for (i = 0; i < 12 && sumDays < day_num; i++)
						sumDays = sumDays + num_of_days[i];
					sumDays = sumDays - num_of_days[i - 1];
					int dateNumber = day_num - sumDays;
					String date = "";
					date+=dateNumber;
					if (dateNumber== 1||dateNumber== 21)
						date+="st";
					else if (dateNumber == 2||dateNumber == 22)
						date+="nd";
					else if (dateNumber== 3||dateNumber== 23)
						date+="rd";
					else
						date+="th";
					date = date + " " + moname[i - 1] + "," + year;
					System.out.println("DATE:" + date);
					i--;
					int next_date = dateNumber + date_after;
					while (next_date > num_of_days[i]) 
					{
						if (i == 11) 
						{
							i = 0;
							year++;
							if (checkLeap(year) == true)
								num_of_days[1] = 29;
							else
								num_of_days[1] = 28;
							next_date -= num_of_days[i];
						} 
						else 
						{
							next_date -= num_of_days[i];
							i++;							
						}
					}
					String strdate = "";
					strdate +=next_date;
					if (next_date==1||next_date== 21)
						strdate +="st";
					else if (next_date==2||next_date== 22)
						strdate +="nd";
					else if (next_date==3||next_date== 23)
						strdate +="rd";
					else
						strdate +="th";
					strdate = strdate + " " + moname[i] + "," + year;
					System.out.println("\tDATE AFTER " + date_after + " DAYS:" + strdate);
				} 
				else
					System.out.print("YEAR NOT OF FOUR DIGITS");
			} 
			else
				System.out.print("DATE AFTER (N DAYS) OUT OF RANGE");
		}
		 else
			System.out.print("DAY NUMBER OUT OF RANGE");
	}
} 