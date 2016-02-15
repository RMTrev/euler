package com.rmtrev.projecteuler.level02;

import java.util.ArrayList;

import com.rmtrev.projecteuler.common.MathPlus;
import com.rmtrev.projecteuler.common.PrimeSieve;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P035 implements IProblem
{
	private ArrayList<Long> PRIME_LIST = new ArrayList<Long>();
	private PrimeSieve SIEVE = new PrimeSieve();
	
	private static final int LIMIT = 1000000;
	
	@Override
	public void Run(String[] args) throws Exception
	{
		PrimeSieve mainSieve = new PrimeSieve();
		long prime = mainSieve.next();
		
		int result = 0;
		
		while(prime < LIMIT)
		{
			if(isCircularPrime(prime))
			{
				result++;
			}
			
			prime = mainSieve.next();
		}
		
		System.out.println(Integer.toString(result));
	}
	
	/**
	 * Determines if the given number, along with all its digit rotations, is prime.
	 * 
	 * @param n
	 * @return
	 */
	private boolean isCircularPrime(long n)
	{
		long original = n;
		long temp = n;
		int numDigits = (int)(Math.log((double) n) / Math.log(10));
		
		while(true)
		{
			temp = shiftDigits(temp, numDigits);
			if(temp == original) break;
			
			if(!isPrime(temp))
			{
				return false;
			}
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
		
		while(true)
		{
			long prime = SIEVE.next();
			PRIME_LIST.add(prime);
			
			if(n == prime) return true;
			if(n < prime) return false;
		}
	}
	
	/**
	 * Circularly shift the digits of the given number to the left.
	 * The left-most digit will become the right-most digit.
	 * 
	 * @param n
	 * @param numDigits
	 * @return
	 */
	private long shiftDigits(long n, int numDigits)
	{
		int digit = (int)n % 10;
		long ret = n / 10;
		
		ret += MathPlus.power(10, numDigits) * digit;
		
		return ret;
	}
}
