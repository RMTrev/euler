package com.rmtrev.projecteuler.questions;

import java.util.ArrayList;

public class Q032 implements IQuestion
{

	@Override
	public void Run(String[] args) throws Exception
	{
		long result = 0;
		ArrayList<Integer> productsHit = new ArrayList<Integer>();
		
		// there are only two product forms that can possibly be 1-9 pandigital:
		// a * bbbb = cccc
		// aa * bbb = cccc
		// therefore, we only check those forms
		
		for(int a = 1; a < 10; a++)
		{
			for(int b = 1000; b < 10000; b++)
			{
				int product = a * b;
				if(isPandigitalProduct(a, b, product) && !productsHit.contains(product))
				{
					productsHit.add(product);
					result += product;
				}
			}
		}
		
		for(int a = 10; a < 100; a++)
		{
			for(int b = 100; b < 1000; b++)
			{
				int product = a * b;
				if(isPandigitalProduct(a, b, product) && !productsHit.contains(product))
				{
					productsHit.add(product);
					result += product;
				}
			}
		}
		
		System.out.println(Long.toString(result));
	}

	private boolean isPandigitalProduct(int a, int b, int c)
	{
		int[] digitsTouched = new int[]{0,0,0,0,0,0,0,0,0};
		
		// touch digits for each number, return false if any of them contain a zero
		if(!touchDigits(digitsTouched, a)) return false;
		if(!touchDigits(digitsTouched, b)) return false;
		if(!touchDigits(digitsTouched, c)) return false;
		
		// check the list of digits touched to make sure they were all touched exactly once
		for(int i = 0; i < digitsTouched.length; i++)
		{
			if(digitsTouched[i] != 1) return false;
		}
		return true;
	}
	
	private boolean touchDigits(int[] digitsTouched, int n)
	{
		int temp = n;
		while(temp > 0)
		{
			int digit = temp % 10;
			if(digit == 0) return false;
			temp /= 10;
			
			digitsTouched[digit - 1]++;
		}
		return true;
	}
}
