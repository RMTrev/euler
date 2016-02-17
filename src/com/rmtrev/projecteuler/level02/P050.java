package com.rmtrev.projecteuler.level02;

import java.util.ArrayList;

import com.rmtrev.projecteuler.common.PrimeSieve;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P050 implements IProblem
{
	ArrayList<Long> _PrimeList = new ArrayList<Long>();

	@Override
	public void Run(String[] args) throws Exception
	{
		int maxChain = 0;
		long primeWithMaxChain = 0;
		
		PrimeSieve sieve = new PrimeSieve();
		
		long prime = sieve.next();
		_PrimeList.add(prime);
		while(prime < 1000000)
		{
			int numTerms = getNumTermsInConsecutivePrimeSum(prime);
			
			if(numTerms > maxChain)
			{
				maxChain = numTerms;
				primeWithMaxChain = prime;
			}
			
			prime = sieve.next();
			_PrimeList.add(prime);
		}
		
		System.out.println(Long.toString(primeWithMaxChain));
	}

	private int getNumTermsInConsecutivePrimeSum(long n)
	{
		// TODO: Optimize this. Right now this is causing my solution
		// to run for about a minute.
		
		int ret = 0;
		
		for(int i = 0; i < _PrimeList.size(); i++)
		{
			long sum = _PrimeList.get(i);
			int numTerms = 1;
			
			for(int j = i + 1; j < _PrimeList.size(); j++)
			{
				sum += _PrimeList.get(j);
				numTerms++;
				if(sum == n && numTerms > ret)
				{
					ret = numTerms;
					break;
				}
				if(sum > n)
				{
					break;
				}
			}
		}
		
		return ret;
	}
}
