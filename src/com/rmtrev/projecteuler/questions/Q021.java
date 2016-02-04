package com.rmtrev.projecteuler.questions;

import java.util.ArrayList;

public class Q021 implements IQuestion
{
	@Override
	public void Run(String[] args) throws Exception
	{
		ArrayList<Integer> amicableNumbers = new ArrayList<Integer>();
		
		for(int i = 1; i < 10000; i++)
		{
			if(amicableNumbers.contains(i)) continue;
			
			int sumOfDivisors = sum(getDivisors(i));
			int check = sum(getDivisors(sumOfDivisors));
			
			if(i == check && i != sumOfDivisors)
			{
				amicableNumbers.add(i);
				amicableNumbers.add(sumOfDivisors);
			}
		}
		
		int result = sum(amicableNumbers);
		
		System.out.println(Integer.toString(result));
	}
	
	private int sum(ArrayList<Integer> list)
	{
		int ret = 0;
		
		for(int i = 0; i < list.size(); i++)
		{
			ret += list.get(i);
		}
		
		return ret;
	}

	private ArrayList<Integer> getDivisors(int n)
	{
		ArrayList<Integer> ret = new ArrayList<Integer>();
		
		int max = (int)Math.sqrt(n);
		for(int factor = 1; factor <= max; factor++)
		{
			if(n % factor == 0)
			{
				int otherFactor = n / factor;
				ret.add(factor);
				if(factor != otherFactor && otherFactor < n)
				{
					ret.add(otherFactor);
				}
			}
		}
		
		return ret;
	}
}
