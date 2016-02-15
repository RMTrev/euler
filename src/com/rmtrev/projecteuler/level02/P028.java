package com.rmtrev.projecteuler.level02;

import com.rmtrev.projecteuler.interfaces.IProblem;

public class P028 implements IProblem
{
	private static final int SIZE = 1001;

	@Override
	public void Run(String[] args) throws Exception
	{
		// initialize to 1, as this is the center number in the grid
		int result = 1;
		int nextNum = 1;
		
		// for each "ring" in the grid
		for(int i = 3; i <= SIZE; i += 2)
		{
			// this represents how many "steps" lie between each diagonal in the grid
			int step = i - 1;
			
			for(int j = 0; j < 4; j++)
			{
				nextNum += step;
				result += nextNum;
			}
		}
		
		System.out.println(Integer.toString(result));
	}

}
