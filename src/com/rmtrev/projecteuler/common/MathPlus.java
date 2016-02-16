package com.rmtrev.projecteuler.common;

import java.util.ArrayList;

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
	
	public static long power(int b, int e)
	{
		int ret = 1;
		for(int i = 0; i < e; i++)
		{
			ret *= b;
		}
		return ret;
	}
	
	public static ArrayList<Integer> getProperDivisors(int n)
	{
		ArrayList<Integer> ret = new ArrayList<Integer>();
		
		int max = (int)Math.sqrt(n);
		for(int factor = 1; factor <= max; factor++)
		{
			if(n % factor == 0)
			{
				int otherFactor = n / factor;
				ret.add(factor);
				if(factor != otherFactor && otherFactor < n)
				{
					ret.add(otherFactor);
				}
			}
		}
		
		return ret;
	}
	
	public static long getPerfectSquareRoot(long n)
	{
		if(n < 0) return -1;
		
		long tmp = (long)Math.sqrt(n);
		if(tmp * tmp == n)
		{
			return tmp;
		}
		
		return -1;
	}
}
