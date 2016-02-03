package com.rmtrev.projecteuler.questions;

public class Q017 implements IQuestion
{
	private static int NUMBER = 1000;

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
			ret += getNumSingle(strNum.charAt(0)) + 8; // thousand = 8
			nextIndex++;
		}
		
		if(strNum.length() >= 3)
		{
			char c = strNum.charAt(nextIndex);
			if(c != '0')
			{
				ret += getNumSingle(strNum.charAt(nextIndex)) + 7; // hundred = 7
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
				ret += 3; // and = 3
			}
			ret += getNumPair(tens, ones);
			nextIndex += 2;
		}
		
		if(strNum.length() == 1)
		{
			char c = strNum.charAt(nextIndex);
			if(hasHundred && c != '0')
			{
				ret += 3 ; // and = 3
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
			return 3; // "one";
		case 2:
			return 3; // "two";
		case 3:
			return 5; // "three";
		case 4:
			return 4; // "four";
		case 5:
			return 4; // "five";
		case 6:
			return 3; // "six";
		case 7:
			return 5; // "seven";
		case 8:
			return 5; // "eight";
		case 9:
			return 4; // "nine";
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
				return 3; // "ten";
			case '1':
				return 6; // "eleven";
			case '2':
				return 6; // "twelve";
			case '3':
				return 8; // "thirteen";
			case '4':
				return 8; // "fourteen";
			case '5':
				return 7; // "fifteen";
			case '6':
				return 7; // "sixteen";
			case '7':
				return 9; // "seventeen";
			case '8':
				return 8; // "eighteen";
			case '9':
				return 8; // "nineteen";
			default:
				return 0;
			}
		}
		else
		{
			switch(tens)
			{
			case '2':
				return 6 + getNumSingle(ones);
			case '3':
				return 6 + getNumSingle(ones);
			case '4':
				return 5 + getNumSingle(ones);
			case '5':
				return 5 + getNumSingle(ones);
			case '6':
				return 5 + getNumSingle(ones);
			case '7':
				return 7 + getNumSingle(ones);
			case '8':
				return 6 + getNumSingle(ones);
			case '9':
				return 6 + getNumSingle(ones);
			default:
				return 0;
			}
		}
	}
}
