package com.rmtrev.projecteuler.level01;

import com.rmtrev.projecteuler.interfaces.IProblem;

public class P025 implements IProblem
{
	private static final int TARGET_DIGITS = 1000;
	
	class BigFloat
	{
		private double _Fraction;
		private int _Exponent;
		
		public double getFraction()
		{
			return _Fraction;
		}
		
		public int getExponent()
		{
			return _Exponent;
		}
		
		public BigFloat(double f, int e)
		{
			_Fraction = f;
			_Exponent = e;
		}
		
		public BigFloat add(BigFloat other)
		{
			int expOther = other.getExponent() - _Exponent;
			double fracOther = other.getFraction() * Math.pow(10, expOther);
			
			double fracNew = _Fraction + fracOther;
			
			int expDiff = 0;
			while(fracNew >= 10)
			{
				fracNew /= 10;
				expDiff++;
			}
			
			return new BigFloat(fracNew, _Exponent + expDiff);
		}
	}

	@Override
	public void Run(String[] args) throws Exception
	{
		// set initial values
		int index = 0;
		BigFloat current = new BigFloat(0, 0);
		BigFloat next = new BigFloat(1, 0);
		BigFloat temp = null;
		
		// iterate through fibonacci sequence until we get the first number with 1000 digits
		while(current.getExponent() < TARGET_DIGITS - 1)
		{
			temp = current.add(next);
			current = next;
			next = temp;
			index++;
		}
		
		System.out.println(Integer.toString(index));
	}

}
