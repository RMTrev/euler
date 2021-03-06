package com.rmtrev.projecteuler.level01;

import com.rmtrev.projecteuler.common.PrimeSieve;
import com.rmtrev.projecteuler.interfaces.IProblem;

/**
 * <b>Largest prime factor</b>
 * 
 * <p>The prime factors of 13195 are 5, 7, 13 and 29.</p>
 * 
 * <p>What is the largest prime factor of the number 600851475143 ?</p>
 * 
 * @author rmt
 *
 */
public class P003 implements IProblem
{
	private static long LIMIT = 600851475143L;
	
	@Override
	public void Run(String[] args) throws Exception
	{
		long curPrime = 0;
		long answer = 0;
		long curLimit = LIMIT;
		
		PrimeSieve sieve = new PrimeSieve();
		
		while(curPrime < curLimit)
		{
			curPrime = sieve.next();
			if(LIMIT % curPrime == 0)
			{
				curLimit = curLimit / curPrime;
				answer = curPrime;
			}
		}
		
		System.out.println(Long.toString(answer));
	}
}
