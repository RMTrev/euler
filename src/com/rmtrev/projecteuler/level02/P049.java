package com.rmtrev.projecteuler.level02;

import java.util.ArrayList;

import com.rmtrev.projecteuler.common.PrimeSieve;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P049 implements IProblem
{
	private ArrayList<Long> _FourDigitPrimes = new ArrayList<Long>();

	@Override
	public void Run(String[] args) throws Exception
	{
		buildList();
		
		for(int i = 0; i < _FourDigitPrimes.size() - 2; i++)
		{
			long a = _FourDigitPrimes.get(i);
			
			for(int j = i + 1; j < _FourDigitPrimes.size() - 1; j++)
			{
				long b = _FourDigitPrimes.get(j);
				
				for(int k = j + 1; k < _FourDigitPrimes.size(); k++)
				{
					long c = _FourDigitPrimes.get(k);
					
					if(isPermutation(a, b, c) && (c - b) == (b - a))
					{
						System.out.println(Long.toString(a) + Long.toString(b) + Long.toString(c));
					}
				}
			}
		}
	}

	private void buildList()
	{
		PrimeSieve sieve = new PrimeSieve();
		
		long prime = sieve.next();
		while(prime < 1000)
		{
			prime = sieve.next();
		}
		
		while(prime < 10000)
		{
			_FourDigitPrimes.add(prime);
			prime = sieve.next();
		}
	}
	
	private boolean isPermutation(long a, long b, long c)
	{
		int[] digitsA = new int[]{0,0,0,0,0,0,0,0,0,0};
		int[] digitsB = new int[]{0,0,0,0,0,0,0,0,0,0};
		int[] digitsC = new int[]{0,0,0,0,0,0,0,0,0,0};
		
		long tempA = a;
		long tempB = b;
		long tempC = c;
		
		for(int i = 0; i < 4; i++)
		{
			int digit = (int)(tempA % 10);
			tempA /= 10;
			digitsA[digit]++;
			
			digit = (int)(tempB % 10);
			tempB /= 10;
			digitsB[digit]++;
			
			digit = (int)(tempC % 10);
			tempC /= 10;
			digitsC[digit]++;
		}
		
		for(int i = 0; i < 10; i++)
		{
			if(digitsA[i] != digitsB[i] || digitsA[i] != digitsC[i])
			{
				return false;
			}
		}
		
		return true;
	}
}
