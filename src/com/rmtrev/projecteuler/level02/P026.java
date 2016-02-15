package com.rmtrev.projecteuler.level02;

import com.rmtrev.projecteuler.common.PrimeSieve;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P026 implements IProblem
{
	private static final int LIMIT = 1000;

	@Override
	public void Run(String[] args) throws Exception
	{
		PrimeSieve sieve = new PrimeSieve();
		long prime = sieve.next();
		
		int numWithLongestPeriod = 0;
		int longestPeriod = 0;
		while(prime < LIMIT)
		{
			int period = lengthOfPeriod((int)prime);
			if(period > longestPeriod)
			{
				longestPeriod = period;
				numWithLongestPeriod = (int)prime;
			}
			
			prime = sieve.next();
		}
		
		System.out.println(Integer.toString(numWithLongestPeriod));
	}
	
	private int lengthOfPeriod(int n)
	{
		// christ, this is a terrible way of doing this
		// TODO: find better algorithm
		
		int firstDiv = 10 / n;
		int firstMod = 10 % n;
		int pLen = 1;
		int nextNum = firstMod * 10;
		while(nextNum != 0)
		{
			int div = nextNum / n;
			int mod = nextNum % n;
			if(div == firstDiv && mod == firstMod) return pLen;
			
			pLen++;
			nextNum = mod * 10;
		}
		return pLen;
	}
}
