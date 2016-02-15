package com.rmtrev.projecteuler.level01;

import com.rmtrev.projecteuler.common.PrimeSieve;
import com.rmtrev.projecteuler.interfaces.IProblem;

/**
 * <b>Smallest multiple</b>
 * 
 * <p>2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.</p>
 * 
 * <p>What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?</p>
 * 
 * @author rmt
 *
 */
public class P005 implements IProblem
{
	// NOTES:
	// 2520 = 1 * 2 * 3 * (2) * 5 * 7 * (3)
	
	private static int LIMIT = 20;

	@Override
	public void Run(String[] args) throws Exception
	{
		long answer = 1;
		long currentPrime = 0;
		
		PrimeSieve sieve = new PrimeSieve();
		
		while(true)
		{
			currentPrime = sieve.next();
			if(currentPrime > LIMIT)
			{
				break;
			}
			
			answer *= currentPrime;
			
			// check if the square of the prime is within limit.
			// if it is, then multiply in the prime a second time
			long curExp = currentPrime * currentPrime;
			while(curExp <= LIMIT)
			{
				answer *= currentPrime;
				curExp *= currentPrime;
			}
		}
		
		System.out.println(Long.toString(answer));
	}

}
