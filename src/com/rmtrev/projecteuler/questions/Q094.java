package com.rmtrev.projecteuler.questions;

import com.rmtrev.projecteuler.common.SquareIterator;
import java.util.HashMap;

public class Q094 implements IQuestion
{
	private SquareIterator iter = new SquareIterator();
	private HashMap<Long, Long> map = new HashMap<Long, Long>();
	
	@Override
	public void Run(String[] args) throws Exception
	{
		boolean flag = true;
		long n = 2;
		
		long s = 0;
		
		double a = 0.75;
		double bm = 0.5;
		double bp = -0.5;
		double c = 0.25;
		
		while(flag)
		{
			boolean breakFlag = true;
			
			long h2 = iter.next();
			double c2 = c - h2;
			double sq;
			
			// check AET with third leg n - 1
			sq = Math.sqrt(bm * bm - 4 * a *c2);
			double nTest = (-bm + sq) / (2 * a);
			if((nTest * 3 - 1) < 1000000000)
			{
				breakFlag = false;
			}
			
			if(isIntegral(nTest))
			{
				s += nTest * 3 - 1;
			}
			
			nTest = (-bm - sq) / (2 * a);
			if((nTest * 3 - 1) < 1000000000)
			{
				breakFlag = false;
			}
			if(isIntegral(nTest))
			{
				s += nTest * 3 - 1;
			}
			
			// check AET with third leg n - 1
			sq = Math.sqrt(bp * bp - 4 * a *c2);
			nTest = (-bp + sq) / (2 * a);
			if((nTest * 3 + 1) < 1000000000)
			{
				breakFlag = false;
			}
			if(isIntegral(nTest))
			{
				s += nTest * 3 + 1;
			}
			
			nTest = (-bp - sq) / (2 * a);
			if((nTest * 3 + 1) < 1000000000)
			{
				breakFlag = false;
			}
			if(isIntegral(nTest))
			{
				s += nTest * 3 + 1;
			}
			
			if(breakFlag)
			{
				flag = false;
			}
			
			/*
			
			// check AET with third leg n - 1
			
			double h2 = (0.75 * n * n) + (0.5 * n) - 0.25;
			if((3 * n - 1) < 1000000000)
			{
				breakFlag = false;
				
				if(isPerfectSquare(h2))
				{
					s += 3 * n - 1;
				}
			}
			
			// check AET with third leg n + 1
			
			h2 = (0.75 * n * n) - (0.5 * n) - 0.25;
			if((3 * n + 1) < 1000000000)
			{
				breakFlag = false;
				
				if(isPerfectSquare(h2))
				{
					s += 3 * n + 1;
				}
			}
			
			if(breakFlag)
			{
				flag = false;
			}
			
			n++;*/
			
			
		}
		
		System.out.println(Long.toString(s));
	}
	
	private boolean isPerfectSquare(double n)
	{
		long ln = (long)n;
		if(n - ln != 0)
		{
			return false;
		}
		
		if(map.containsKey(ln))
		{
			return true;
		}
		else
		{
			long testN = 0;
			while(testN < ln)
			{
				testN = iter.next();
				map.put(testN, testN);
				if(ln == testN)
				{
					return true;
				}
			}
			return false;
		}
	}
	
	private boolean isIntegral(double n)
	{
		long ln = (long) n;
		if(n - ln == 0)
		{
			return true;
		}
		
		return false;
	}
}
