package com.rmtrev.projecteuler.level02;

import com.rmtrev.projecteuler.common.MathPlus;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P039 implements IProblem
{
	private static final int P_LIMIT = 1000;

	@Override
	public void Run(String[] args) throws Exception
	{
		int maximumSolutions = 0;
		int pWithMaximumSolutions = 0;
		
		// find perimeter with the most integer right triangles. start with perimeter 3, as it is the first perimeter
		// that can have ANY triangle with integer sides
		for(int p = 3; p <= P_LIMIT; p++)
		{
			int solutions = 0;
			
			for(int a = 1; a < p - 2; a++)
			{
				for(int b = a; b < p - a; b++)
				{
					// get c based on sides a and b and perimeter
					int c = p - (a + b);
					
					// test if triangle is a right triangle using pythagorean's theorem
					if(MathPlus.power(c, 2) == (MathPlus.power(a, 2) + MathPlus.power(b, 2)))
					{
						solutions++;
					}
				}
			}
			
			if(solutions > maximumSolutions)
			{
				maximumSolutions = solutions;
				pWithMaximumSolutions = p;
			}
		}
		
		System.out.println(Integer.toString(pWithMaximumSolutions));
	}
}
