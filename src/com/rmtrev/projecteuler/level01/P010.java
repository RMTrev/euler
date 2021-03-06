package com.rmtrev.projecteuler.level01;

import com.rmtrev.projecteuler.common.PrimeSieve;
import com.rmtrev.projecteuler.interfaces.IProblem;

/**
 * <b>Summation of primes</b>
 * 
 * <p>The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.</p>
 * 
 * <p>Find the sum of all the primes below two million.</p>
 * 
 * @author rmt
 *
 */
public class P010 implements IProblem
{
	private static long LIMIT = 2000000;
	
	@Override
	public void Run(String[] args) throws Exception
	{
		long sum = 0;
		PrimeSieve sieve = new PrimeSieve();
		
		while(true)
		{
			long prime = sieve.next();
			if(prime >= LIMIT)
			{
				break;
			}
			
			sum += prime;
		}
		
		System.out.println(Long.toString(sum));
	}
}
