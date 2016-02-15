package com.rmtrev.projecteuler.level02;

import com.rmtrev.projecteuler.interfaces.IProblem;

public class P040 implements IProblem
{

	@Override
	public void Run(String[] args) throws Exception
	{
		int result = d(1) * d(10) * d(100) * d(1000) * d(10000) * d(100000) * d(1000000);
		
		System.out.println(Integer.toString(result));
	}

	private int d(int n)
	{
		int temp = n;
		
		// next number to iterate through
		int nextNumber = 1;
		
		// number of digits in next number
		int numDigits = Integer.toString(nextNumber).length();
		
		// reduce n until it can be used as an index in the next number
		while(temp > numDigits)
		{
			temp -= numDigits;
			nextNumber++;
			numDigits = Integer.toString(nextNumber).length();
		}
		
		// once n has been reduced to at most the number of digits in the next number,
		// return the nth digit in that number
		char digit = Integer.toString(nextNumber).charAt(temp - 1);
		
		// return that digit
		return Character.digit(digit, 10);
	}
}
