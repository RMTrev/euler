package com.rmtrev.projecteuler.questions;

import com.rmtrev.projecteuler.common.PrimeSieve;

public class Q041 implements IQuestion
{

	@Override
	public void Run(String[] args) throws Exception
	{
		PrimeSieve sieve = new PrimeSieve();
		long prime = sieve.next();
		
		long largestPandigital = 0;
		
		// stop after 7 digits, as all 8 and 9 digit pandigital numbers are divisible by 3, and
		// therefore cannot be prime
		//
		// 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36
		// 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
		while(prime < 10000000)
		{
			if(pandigital(prime))
			{
				largestPandigital = prime;
			}
			
			prime = sieve.next();
		}
		
		System.out.println(Long.toString(largestPandigital));
	}

	/**
	 * Returns true if the number is pandigital
	 * @param n
	 * @return
	 */
	private boolean pandigital(long n)
	{
		int numDigits = Long.toString(n).length();
		int[] digitsTouched = new int[numDigits];
		for(int i = 0; i < numDigits; i++)
		{
			digitsTouched[i] = 0;
		}
		
		long temp = n;
		

		while(temp > 0)
		{
			int digit = (int)(temp % 10);
			temp /= 10;
			if(digit == 0) return false;
			try
			{
				digitsTouched[digit - 1]++;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		// check the list of digits touched to make sure they were all touched exactly once
		for(int i = 0; i < digitsTouched.length; i++)
		{
			if(digitsTouched[i] != 1) return false;
		}
		
		return true;
	}
}
