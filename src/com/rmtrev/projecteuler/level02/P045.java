package com.rmtrev.projecteuler.level02;

import com.rmtrev.projecteuler.common.MathPlus;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P045 implements IProblem
{

	@Override
	public void Run(String[] args) throws Exception
	{
		for(int i = 286; ; i++)
		{
			long tn = triangle(i);
			if(isPentagonal(tn) && isHexagonal(tn))
			{
				System.out.println(Long.toString(tn));
				return;
			}
		}
	}
	
	private long triangle(long n)
	{
		return n * (n + 1) / 2;
	}

	private boolean isPentagonal(long pn)
	{
		long sqrt = MathPlus.getPerfectSquareRoot(24 * pn + 1);
		if(sqrt < 0) return false;
		
		return (sqrt + 1) % 6 == 0;
	}
	
	private boolean isHexagonal(long hn)
	{
		long sqrt = MathPlus.getPerfectSquareRoot(8 * hn + 1);
		if(sqrt < 0) return false;
		
		return (sqrt + 1) % 4 == 0;
	}
}
