package com.rmtrev.projecteuler.level02;

import com.rmtrev.projecteuler.common.MathPlus;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P030 implements IProblem
{
	private static final int POWER = 5;

	@Override
	public void Run(String[] args) throws Exception
	{
		int result = 0;
		long upperLimit = getUpperLimit();
		
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
			
			long power = MathPlus.power(digit, POWER);
			
			ret += power;
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
	private long getUpperLimit()
	{
		int numberOfDigits = 1;
		long maxDigit = MathPlus.power(9, POWER);
		while(true)
		{
			long num = MathPlus.power(10, numberOfDigits - 1);
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
