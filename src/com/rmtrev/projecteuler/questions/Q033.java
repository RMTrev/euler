package com.rmtrev.projecteuler.questions;

import java.util.ArrayList;

import com.rmtrev.projecteuler.common.PrimeSieve;

public class Q033 implements IQuestion
{
	static class Fraction
	{
		private int _Numerator;
		private int _Denominator;
		
		public int getNumerator()
		{
			return _Numerator;
		}
		
		public int getDenominator()
		{
			return _Denominator;
		}
		
		private static ArrayList<Long> PRIME_LIST = null;
		private static PrimeSieve SIEVE = null;
		
		public Fraction(int n, int d)
		{
			_Numerator = n;
			_Denominator = d;
			
			if(PRIME_LIST == null)
			{
				PRIME_LIST = new ArrayList<Long>();
				SIEVE = new PrimeSieve();
			}
		}
		
		public Fraction getReducedFraction()
		{
			int n = _Numerator;
			int d = _Denominator;
			
			for(int i = 0; i < PRIME_LIST.size(); i++)
			{
				long p = PRIME_LIST.get(i);
				
				while(n % p == 0 && d % p == 0)
				{
					n /= p;
					d /= p;
					
					if(p > n)
					{
						return new Fraction(n, d);
					}
				}
			}
			
			while(true)
			{
				long p = SIEVE.next();
				PRIME_LIST.add(p);
				
				while(n % p == 0 && d % p == 0)
				{
					n /= p;
					d /= p;
					
					if(p > n)
					{
						return new Fraction(n, d);
					}
				}
			}
		}
	}

	@Override
	public void Run(String[] args) throws Exception
	{
		int finalNum = 1;
		int finalDenom = 1;
		
		for(int denom = 10; denom < 100; denom++)
		{
			for(int num = 10; num < denom; num++)
			{
				if(isDigitCancelling(num, denom))
				{
					Fraction frac = new Fraction(num, denom);
					frac = frac.getReducedFraction();
					
					finalNum *= frac.getNumerator();
					finalDenom *= frac.getDenominator();
				}
			}
		}
		
		Fraction finalFrac = new Fraction(finalNum, finalDenom);
		finalFrac = finalFrac.getReducedFraction();
		
		int result = finalFrac.getDenominator();
		
		System.out.println(Integer.toString(result));
	}

	/**
	 * Determines if the given fraction is non-trivially digit cancelling.
	 * 
	 * <p>
	 * Example: 49/98 -> reduces to 4/8 by removing the 9's. However,
	 * 30/50 is trivial, so this doesn't count.
	 * </p>
	 * @param num
	 * @param denom
	 * @return
	 */
	private boolean isDigitCancelling(int num, int denom)
	{
		int num0 = num % 10;
		int num1 = num / 10;
		int denom0 = denom % 10;
		int denom1 = denom / 10;
		
		if(num0 == denom0)
		{
			// this fraction is "trivially cancelling", therefore we don't care about this
			return false;
		}
		else if(num0 == denom1)
		{
			return isDigitCancellingInner(num, denom, num1, denom0);
		}
		else if(num1 == denom0)
		{
			return isDigitCancellingInner(num, denom, num0, denom1);
		}
		else if(num1 == denom1)
		{
			return isDigitCancellingInner(num, denom, num0, denom0);
		}
		
		return false;
	}
	
	private boolean isDigitCancellingInner(int numA, int denomA, int numB, int denomB)
	{
		return (Math.abs((((double)numA) / denomA) - ((double)numB) / denomB) < 0.00000000001);
	}
}
