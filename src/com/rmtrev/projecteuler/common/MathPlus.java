package com.rmtrev.projecteuler.common;

public class MathPlus
{
	public static long factorial(int n)
	{
		if(n <= 0) return 1;
		
		long ret = 1;
		for(int i = 1; i <= n; i++)
		{
			ret *= i;
		}
		
		return ret;
	}
}
