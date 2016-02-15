package com.rmtrev.projecteuler.level01;

import java.util.ArrayList;

import com.rmtrev.projecteuler.common.MathPlus;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P023 implements IProblem
{
	private ArrayList<Integer> _ListOfAbundantNumbers;

	@Override
	public void Run(String[] args) throws Exception
	{
		// TODO: Find a faster way of solving this
		
		ArrayList<Integer> listOfAbundantNumbers = new ArrayList<Integer>();
		
		// because all integers greater than 28123 can be written as the sum of
		// two abundant numbers, we take that as our upper limit
		for(int i = 1; i <= 28123; i++)
		{
			if(isPerfect(i) > 0)
			{
				listOfAbundantNumbers.add(i);
			}
		}
		
		_ListOfAbundantNumbers = listOfAbundantNumbers;
		
		// find the sum of all numbers that cannot be represented as the sum of two abundant numbers
		int sum = 0;
		for(int i = 0; i <= 28123; i++)
		{
			if(!isSumOfTwoAbundantNums(i))
			{
				sum += i;
			}
		}
		
		System.out.println(Integer.toString(sum));
	}
	
	private boolean isSumOfTwoAbundantNums(int n)
	{
		for(int i = 0; i < _ListOfAbundantNumbers.size(); i++)
		{
			int x = _ListOfAbundantNumbers.get(i);
			
			// if first number is greater than n, then n cannot be a sum of two abundant numbers
			if(x > n) return false;
			
			for(int j = 0; j < _ListOfAbundantNumbers.size(); j++)
			{
				int y = _ListOfAbundantNumbers.get(j);
				
				// found the two abundant numbers whose sum equals n. return true
				if(x + y == n) return true;
				
				// if sum of abundant numbers is greater than n, break out of inner loop,
				// as all further numbers in the list will also result in a sum greater than n
				if(x + y > n) break;
			}
		}
		
		// went through whole list and didn't find a pair of numbers whose sum equals n.
		return false;
	}

	/**
	 * Checks to see if the given number is perfect. The return value is an integer indicating the following:
	 * 
	 * <ul>
	 * <li>= 0 : n is perfect</li>
	 * <li>&lt; 0 : n is deficient</li>
	 * <li>&gt; 0 : n is abundant</li>
	 * </ul>
	 * @param n
	 * @return
	 */
	private int isPerfect(int n)
	{
		ArrayList<Integer> properDivisors = MathPlus.getProperDivisors(n);
		
		int sum = 0;
		for(int i = 0; i < properDivisors.size(); i++)
		{
			sum += properDivisors.get(i);
		}
		
		return sum - n;
	}
}
