package com.rmtrev.projecteuler.questions;

import java.util.ArrayList;

public class Q029 implements IQuestion
{
	private static final int LIMIT = 100;
	
	class Power
	{
		private int _Base;
		private int _Exponent;
		
		public Power(int base, int exp)
		{
			_Base = base;
			_Exponent = exp;
		}
		
		@Override
		public boolean equals(Object obj)
		{
			if(obj == null) return false;
			if(!Power.class.isAssignableFrom(obj.getClass())) return false;
			
			Power other = (Power)obj;
			
			// this tests if the two exponentials are equal. this check is derived from the following:
			//   a^b = c^d --> log_(a)(c) = b/d
			// I'm using an imperfect check of the difference, because comparing doubles tends to be imperfect
			if(Math.abs(Math.log(other._Base) / Math.log(_Base) - (double)_Exponent / other._Exponent) < 0.0000000001)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}

	@Override
	public void Run(String[] args) throws Exception
	{
		ArrayList<Power> l = new ArrayList<Power>();
		
		for(int a = 2; a <= LIMIT; a++)
		{
			for(int b = 2; b <= LIMIT; b++)
			{
				Power num = new Power(a, b);
				
				if(!l.contains(num))
				{
					l.add(num);
				}
			}
		}
		
		System.out.println(Integer.toString(l.size()));
	}

}
