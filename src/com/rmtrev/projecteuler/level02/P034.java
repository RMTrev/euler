package com.rmtrev.projecteuler.level02;

import com.rmtrev.projecteuler.common.MathPlus;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P034 implements IProblem
{
	@Override
	public void Run(String[] args) throws Exception
	{
		long upperLimit = getUpperLimit();
		
		int result = 0;
		
		for(int n = 3; n < upperLimit; n++)
		{
			if(isDigitFactorial(n))
			{
				result += n;
			}
		}
		
		System.out.println(Integer.toString(result));
	}

	/**
	 * This function tests if the given number is equal to the num
	 * of the factorial of its digits.
	 * 
	 * <p>Example: 145 -> 1! + 4! + 5! = 145</p>
	 * @param n
	 * @return
	 */
	private boolean isDigitFactorial(int n)
	{
		int temp = n;
		
		int facts = 0;
		
		while(temp > 0)
		{
			int digit = temp % 10;
			temp /= 10;
			
			facts += (int)MathPlus.factorial(digit);
		}
		
		return n == facts;
	}
	
	/**
	 * This function will pick an upper limit for the main loop such that
	 * 
	 * <p>d * 9! < 10<sup>d</sup></p>
	 * 
	 * <p>
	 * (yes, this is an almost complete copy-paste of the getUpperLimit function
	 * used in problem 30)
	 * </p>
	 * 
	 * @return
	 */
	private long getUpperLimit()
	{
		int numberOfDigits = 1;
		long maxDigit = MathPlus.factorial(9);
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
