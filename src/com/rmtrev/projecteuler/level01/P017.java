package com.rmtrev.projecteuler.level01;

import com.rmtrev.projecteuler.interfaces.IProblem;

public class P017 implements IProblem
{
	private static int NUMBER = 1000;
	
	private static int LEN_AND = 3;
	
	private static int LEN_ONE = 3;
	private static int LEN_TWO = 3;
	private static int LEN_THREE = 5;
	private static int LEN_FOUR = 4;
	private static int LEN_FIVE = 4;
	private static int LEN_SIX = 3;
	private static int LEN_SEVEN = 5;
	private static int LEN_EIGHT = 5;
	private static int LEN_NINE = 4;
	
	private static int LEN_TEN = 3;
	private static int LEN_ELEVEN = 6;
	private static int LEN_TWELVE = 6;
	private static int LEN_THIRTEEN = 8;
	private static int LEN_FOURTEEN = 8;
	private static int LEN_FIFTEEN = 7;
	private static int LEN_SIXTEEN = 7;
	private static int LEN_SEVENTEEN = 9;
	private static int LEN_EIGHTEEN = 8;
	private static int LEN_NINETEEN = 8;
	
	private static int LEN_TWENTY = 6;
	private static int LEN_THIRTY = 6;
	private static int LEN_FORTY = 5;
	private static int LEN_FIFTY = 5;
	private static int LEN_SIXTY = 5;
	private static int LEN_SEVENTY = 7;
	private static int LEN_EIGHTY = 6;
	private static int LEN_NINETY = 6;
	
	private static int LEN_HUNDRED = 7;
	private static int LEN_THOUSAND = 8;

	@Override
	public void Run(String[] args) throws Exception
	{
		long result = 0;
		
		for(int i = 1; i <= NUMBER; i++)
		{
			result += getLengthOfNumberString(i);
		}
		
		System.out.println(Long.toString(result));
	}
	
	private int getLengthOfNumberString(int i)
	{
		String strNum = Integer.toString(i);
		int nextIndex = 0;
		boolean hasHundred = false;
		
		int ret = 0;
		
		if(strNum.length() == 4)
		{
			ret += getNumSingle(strNum.charAt(0)) + LEN_THOUSAND;
			nextIndex++;
		}
		
		if(strNum.length() >= 3)
		{
			char c = strNum.charAt(nextIndex);
			if(c != '0')
			{
				ret += getNumSingle(strNum.charAt(nextIndex)) + LEN_HUNDRED;
				hasHundred = true;
			}
			nextIndex++;
		}
		
		if(strNum.length() >= 2)
		{
			char tens = strNum.charAt(nextIndex);
			char ones = strNum.charAt(nextIndex+1);
			if(hasHundred && (tens != '0' || ones != '0'))
			{
				ret += LEN_AND;
			}
			ret += getNumPair(tens, ones);
			nextIndex += 2;
		}
		
		if(strNum.length() == 1)
		{
			char c = strNum.charAt(nextIndex);
			if(hasHundred && c != '0')
			{
				ret += LEN_AND;
			}
			ret += getNumSingle(c);
		}
		
		return ret;
	}
	
	private int getNumSingle(char c)
	{
		int i = Character.digit(c, 10);
		switch(i)
		{
		case 1:
			return LEN_ONE;
		case 2:
			return LEN_TWO;
		case 3:
			return LEN_THREE;
		case 4:
			return LEN_FOUR;
		case 5:
			return LEN_FIVE;
		case 6:
			return LEN_SIX;
		case 7:
			return LEN_SEVEN;
		case 8:
			return LEN_EIGHT;
		case 9:
			return LEN_NINE;
		default:
			return 0;
		}
	}

	private int getNumPair(char tens, char ones)
	{
		if(tens == '0')
		{
			return getNumSingle(ones);
		}
		else if(tens == '1')
		{
			switch(ones)
			{
			case '0':
				return LEN_TEN;
			case '1':
				return LEN_ELEVEN;
			case '2':
				return LEN_TWELVE;
			case '3':
				return LEN_THIRTEEN;
			case '4':
				return LEN_FOURTEEN;
			case '5':
				return LEN_FIFTEEN;
			case '6':
				return LEN_SIXTEEN;
			case '7':
				return LEN_SEVENTEEN;
			case '8':
				return LEN_EIGHTEEN;
			case '9':
				return LEN_NINETEEN;
			default:
				return 0;
			}
		}
		else
		{
			switch(tens)
			{
			case '2':
				return LEN_TWENTY + getNumSingle(ones);
			case '3':
				return LEN_THIRTY + getNumSingle(ones);
			case '4':
				return LEN_FORTY + getNumSingle(ones);
			case '5':
				return LEN_FIFTY + getNumSingle(ones);
			case '6':
				return LEN_SIXTY + getNumSingle(ones);
			case '7':
				return LEN_SEVENTY + getNumSingle(ones);
			case '8':
				return LEN_EIGHTY + getNumSingle(ones);
			case '9':
				return LEN_NINETY + getNumSingle(ones);
			default:
				return 0;
			}
		}
	}
}
