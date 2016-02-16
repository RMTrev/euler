package com.rmtrev.projecteuler.level02;

import com.rmtrev.projecteuler.interfaces.IProblem;

public class P047 implements IProblem
{
	@Override
	public void Run(String[] args) throws Exception
	{
		long firstInChain = 0;
		long chainLength = 0;
		
		// start with 210, as that's the first number with four distinct prime factors.
		// (2 * 3 * 5 * 7)
		long n = 210;
		while(true)
		{
			if(hasFourDistinctPrimeFactors(n))
			{
				if(chainLength == 0)
				{
					firstInChain = n;
				}
				chainLength++;
			}
			else
			{
				chainLength = 0; // chain broken!
			}
			
			if(chainLength == 4)
			{
				System.out.println(Long.toString(firstInChain));
				return;
			}
			
			n++;
		}
	}

	private boolean hasFourDistinctPrimeFactors(long n)
	{
		long temp = n;
		int numFactors = 0;
		
		for(int factor = 2; temp > 1; factor++)
		{
			if(temp % factor == 0)
			{
				numFactors++;
				while(temp % factor == 0)
				{
					temp /= factor;
				}
			}
		}
		
		return numFactors == 4;
	}
}
