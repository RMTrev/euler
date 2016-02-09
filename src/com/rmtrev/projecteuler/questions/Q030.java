package com.rmtrev.projecteuler.questions;

public class Q030 implements IQuestion
{
	private static final int POWER = 5;

	@Override
	public void Run(String[] args) throws Exception
	{
		int result = 0;
		int upperLimit = getUpperLimit();
		
		// skip over 1, as 1 is not a valid sum.
		for(int i = 2; i < upperLimit; i++)
		{
			int sumOfFifthPowers = getSumOfFifthPowers(i);
			if(i == sumOfFifthPowers)
			{
				result += i;
			}
		}
		
		System.out.println(Integer.toString(result));
	}

	private int getSumOfFifthPowers(int n)
	{
		int temp = n;
		int ret = 0;
		
		while(temp > 0)
		{
			int digit = temp % 10;
			temp /= 10;
			
			int power = power(digit, POWER);
			
			ret += power;
		}
		
		return ret;
	}
	
	private int power(int b, int e)
	{
		int ret = 1;
		for(int i = 0; i < e; i++)
		{
			ret *= b;
		}
		return ret;
	}
	
	/**
	 * This function will pick an upper limit for the main loop such that
	 * 
	 * <p>d * 9<sup>p</sup> < 10<sup>d</sup></p>
	 * 
	 * <p>
	 * In other words, 999...9 ('d' 9's) where the sum of its fifth powers
	 * will fit within the limit
	 * </p>
	 * 
	 * @return
	 */
	private int getUpperLimit()
	{
		int numberOfDigits = 1;
		int maxDigit = power(9, POWER);
		while(true)
		{
			int num = power(10, numberOfDigits - 1);
			if(numberOfDigits * maxDigit < num)
			{
				return num;
			}
			else
			{
				numberOfDigits++;
			}
		}
	}
}
