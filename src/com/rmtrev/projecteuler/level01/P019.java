package com.rmtrev.projecteuler.level01;

import com.rmtrev.projecteuler.interfaces.IProblem;

public class P019 implements IProblem
{
	class Month
	{
		public static final int SUNDAY = 0;
		public static final int MONDAY = 1;
		public static final int TUESDAY = 2;
		public static final int WEDNESDAY = 3;
		public static final int THURSDAY = 4;
		public static final int FRIDAY = 5;
		public static final int SATURDAY = 6;
		
		private int _Month;
		private int _Year;
		private int _WeekdayOfFirst;
		private int _FirstSunday;
		private int _NumDays;
		private int _RemainingDays;
		
		public int getYear()
		{
			return _Year;
		}
		
		public Month(int month, int year, int weekdayOfFirst)
		{
			_Month = month;
			_Year = year;
			_WeekdayOfFirst = weekdayOfFirst;
			_NumDays = getNumDays(month, year);
		}
		
		public int getWeekdayOfFirst()
		{
			return _WeekdayOfFirst;
		}
		
		public Month getNext()
		{
			if(_WeekdayOfFirst == SUNDAY)
			{
				_FirstSunday = 1;
			}
			else
			{
				_FirstSunday = 7 - _WeekdayOfFirst + 1;
			}
			
			_RemainingDays = _NumDays - (_FirstSunday - 1);
			
			int weekdayOfNextFirst = (_RemainingDays) % 7;
			int nextMonth = _Month + 1;
			int nextYear = _Year;
			if(nextMonth > 12)
			{
				nextMonth = 1;
				nextYear += 1;
			}
			
			return new Month(nextMonth, nextYear, weekdayOfNextFirst);
		}
		
		private int getNumDays(int month, int year)
		{
			switch(month)
			{
			case 1:
				return 31;
			case 2:
				if(year % 100 == 0)
				{
					if(year % 400 == 0)
					{
						return 29;
					}
					else
					{
						return 28;
					}
				}
				else if(year % 4 == 0)
				{
					return 29;
				}
				else
				{
					return 28;
				}
			case 3:
				return 31;
			case 4:
				return 30;
			case 5:
				return 31;
			case 6:
				return 30;
			case 7:
				return 31;
			case 8:
				return 31;
			case 9:
				return 30;
			case 10:
				return 31;
			case 11:
				return 30;
			case 12:
				return 31;
			default:
				return 0;
			}
		}
	}
	
	@Override
	public void Run(String[] args) throws Exception
	{
		Month curMonth = new Month(1, 1900, Month.MONDAY);
		for(int i = 0; i < 12; i++)
		{
			curMonth = curMonth.getNext();
		}
		int numSundaysTotal = 0;
		
		while(curMonth.getYear() < 2001)
		{
			if(curMonth.getWeekdayOfFirst() == Month.SUNDAY)
			{
				numSundaysTotal += 1;
			}
			
			curMonth = curMonth.getNext();
		}
		
		System.out.println(Integer.toString(numSundaysTotal));
	}
}
