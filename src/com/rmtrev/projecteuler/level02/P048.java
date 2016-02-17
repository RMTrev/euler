package com.rmtrev.projecteuler.level02;

import com.rmtrev.projecteuler.interfaces.IProblem;

public class P048 implements IProblem
{

	@Override
	public void Run(String[] args) throws Exception
	{
		long result = 0;
		for(int n = 1; n <= 1000; n++)
		{
			result += powerLastTenDigits(n, n);
		}
		
		// print out the last ten digits of the sum of n^n where 1<=n<=1000.
		System.out.println(Long.toString(result % 10000000000L));
	}

	/**
	 * Returns the last 10 digits of the expression b^e.
	 * @param b
	 * @param e
	 * @return
	 */
	private long powerLastTenDigits(int b, int e)
	{
		long temp = 1;
		for(int i = 0; i < e; i++)
		{
			temp = (temp * b) % 10000000000L;
		}
		
		return temp;
	}
}
