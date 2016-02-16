package com.rmtrev.projecteuler.level02;

import com.rmtrev.projecteuler.common.MathPlus;
import com.rmtrev.projecteuler.common.PrimeSieve;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P046 implements IProblem
{
	private PrimeSieve SIEVE = new PrimeSieve();
	private long currentPrime;

	@Override
	public void Run(String[] args) throws Exception
	{
		long currentN = 1;
		currentPrime = SIEVE.next();
		
		while(true)
		{
			currentN = getNextOddCompositeNumber(currentN);
			
			// find the first odd composite number that does not satisfy Goldbach's Conjecture
			if(!satisfiesGoldbachsConjecture(currentN))
			{
				System.out.println(Long.toString(currentN));
				return;
			}
		}
	}
	
	private long getNextOddCompositeNumber(long currentN)
	{
		long n = currentN + 2;
		
		while(true)
		{
			if(n >= currentPrime)
			{
				while(n >= currentPrime)
				{
					currentPrime = SIEVE.next();
				}
				n += 2;
			}
			else
			{
				return n;
			}
		}
	}

	private boolean satisfiesGoldbachsConjecture(long n)
	{
		PrimeSieve sieve = new PrimeSieve();
		
		long prime = sieve.next();
		while(prime <= n)
		{
			int i = 0;
			while(true)
			{
				long doubleSquare = 2 * MathPlus.power(i, 2);
				if(prime + doubleSquare == n)
					return true;
				if(prime + doubleSquare > n) break;
				
				i++;
			}
			
			prime = sieve.next();
		}
		
		return false;
	}
}
