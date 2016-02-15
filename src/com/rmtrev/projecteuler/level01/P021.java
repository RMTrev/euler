package com.rmtrev.projecteuler.level01;

import java.util.ArrayList;

import com.rmtrev.projecteuler.common.MathPlus;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P021 implements IProblem
{
	@Override
	public void Run(String[] args) throws Exception
	{
		ArrayList<Integer> amicableNumbers = new ArrayList<Integer>();
		
		for(int i = 1; i < 10000; i++)
		{
			if(amicableNumbers.contains(i)) continue;
			
			int sumOfDivisors = sum(MathPlus.getProperDivisors(i));
			int check = sum(MathPlus.getProperDivisors(sumOfDivisors));
			
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
}
