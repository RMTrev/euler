package com.rmtrev.projecteuler.level02;

import java.util.ArrayList;

import com.rmtrev.projecteuler.interfaces.IProblem;

public class P044 implements IProblem
{
	@Override
	public void Run(String[] args) throws Exception
	{
		// list containing all pentagonal numbers attempted as Pj
		ArrayList<Long> pentagonalNumbers = new ArrayList<Long>();
		
		long j = 1;
		while(true)
		{
			// generate our Pj
			long pj = pentagonalNumber(j);
			
			// try each previously generated pentagonal numbers as our Pk
			for(int i = 0; i < pentagonalNumbers.size(); i++)
			{
				long pk = pentagonalNumbers.get(i);
				if(isPentagonal(pj + pk) && isPentagonal(pj - pk))
				{
					// we found our solution. print and exit
					System.out.println(Long.toString(pj - pk));
					return;
				}
			}
			
			pentagonalNumbers.add(pj);
			j++;
		}
	}

	private long pentagonalNumber(long i)
	{
		return (i * (3 * i - 1)) / 2;
	}
	
	private boolean isPentagonal(long n)
	{
		// TODO: This is the biggest bottleneck. Needs optimization.
		for(int i = 1; ; i++)
		{
			long p = pentagonalNumber(i);
			if(n == p) return true;
			if(p > n) return false;
		}
	}
}
