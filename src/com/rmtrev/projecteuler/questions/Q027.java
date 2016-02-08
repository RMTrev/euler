package com.rmtrev.projecteuler.questions;

import java.util.ArrayList;

import com.rmtrev.projecteuler.common.PrimeSieve;

public class Q027 implements IQuestion
{
	private PrimeSieve sieve = new PrimeSieve();
	private ArrayList<Long> primes = new ArrayList<Long>();

	@Override
	public void Run(String[] args) throws Exception
	{
		int longestPrimeSequence = 0;
		int longestA = 0;
		int longestB = 0;
		
		// gross brute force loop, but with only 4mil combinations of a and b this is actually quite fast regardless
		for(int a = -999; a < 1000; a++)
		{
			for(int b = -999; b < 1000; b++)
			{
				// evaluate n^2 + an + b, starting with n = 0, until we find an n that does not evaluate to a prime number
				int n = 0;
				int sequenceLength = 0;
				while(true)
				{
					long evalN = (n * n) + (a * n) + b;
					if(isPrime(evalN))
					{
						sequenceLength++;
						n++;
					}
					else
					{
						break;
					}
				}
				
				// check if the prime sequence is the longest
				if(sequenceLength > longestPrimeSequence)
				{
					longestPrimeSequence = sequenceLength;
					longestA = a;
					longestB = b;
				}
			}
		}
		
		int prod = longestA * longestB;
		System.out.println(Integer.toString(prod));
	}

	private boolean isPrime(long n)
	{
		// check if a prime starting with the list of known primes
		long lastPrime = 0;
		for(int i = 0; i < primes.size(); i++)
		{
			lastPrime = primes.get(i);
			if(n == lastPrime) return true;
			if(lastPrime > n) return false;
		}
		
		// once the list is exhausted, start going through the sieve
		while(true)
		{
			lastPrime = sieve.next();
			primes.add(lastPrime);
			if(n == lastPrime) return true;
			if(lastPrime > n) return false;
		}
	}
}
