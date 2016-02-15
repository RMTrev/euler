package com.rmtrev.projecteuler.level02;
import java.util.ArrayList;

import com.rmtrev.projecteuler.common.MathPlus;
import com.rmtrev.projecteuler.common.PrimeSieve;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P037 implements IProblem
{
	private ArrayList<Long> PRIME_LIST = new ArrayList<Long>();
	private PrimeSieve SIEVE = new PrimeSieve();
	
	// Given: there are 11 primes that are truncable primes from both ltr and rtl
	private static final int LIMIT = 11;

	@Override
	public void Run(String[] args) throws Exception
	{
		int primesFound = 0;
		long result = 0;
		
		while(primesFound < LIMIT)
		{
			long prime = SIEVE.next();
			PRIME_LIST.add(prime);
			
			// skip the single digit primes
			if(prime < 10) continue;
			
			if(isTruncatablePrime(prime))
			{
				primesFound++;
				result += prime;
			}
		}
		
		System.out.println(Long.toString(result));
	}

	/**
	 * This function tests if the given number and all its digit truncations
	 * are prime numbers.
	 * 
	 * <p>
	 * Example: 3797 -> 797, 97, 7, 379, 37, 3
	 * </p>
	 * @param n
	 * @return
	 */
	private boolean isTruncatablePrime(long n)
	{
		long temp = n;
		
		ArrayList<Integer> digits = new ArrayList<Integer>();
		
		// truncate right to left
		while(temp > 0)
		{
			if(!isPrime(temp)) return false;
			
			int digit = (int)(temp % 10);
			temp /= 10;
			
			digits.add(digit);
		}
		
		// truncate left to right
		for(int i = 0; i < digits.size() - 1; i++)
		{
			int digit = digits.get(i);
			temp += digit * MathPlus.power(10, i);
			
			if(!isPrime(temp)) return false;
		}
		
		return true;
	}
	
	/**
	 * Tests if the given number is a prime.
	 * 
	 * @param n
	 * @return
	 */
	private boolean isPrime(long n)
	{
		for(int i = 0; i < PRIME_LIST.size(); i++)
		{
			long prime = PRIME_LIST.get(i);
			
			if(n == prime) return true;
			if(n < prime) return false;
		}
		
		return false;
	}
}
