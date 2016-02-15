package com.rmtrev.projecteuler.level01;

import com.rmtrev.projecteuler.common.MathPlus;
import com.rmtrev.projecteuler.interfaces.IProblem;

public class P024 implements IProblem
{
	public static final int TARGET_INDEX = 1000000;

	@Override
	public void Run(String[] args) throws Exception
	{
		int[] listOfNumbers = new int[]{0,1,2,3,4,5,6,7,8,9};
		int nextIndex = TARGET_INDEX - 1;
		
		// this loop should process every entry in the array exactly once.
		while(listOfNumbers.length > 0)
		{
			// get number of remaining permutations after this entry
			long permutations = MathPlus.factorial(listOfNumbers.length - 1);
			
			// divide the next index by the number of remaining permutations.
			// this will determine the number that will be in this position.
			int div = (int)(nextIndex / permutations);
			
			// the remainder of this division will be our next index.
			int rem = (int)(nextIndex % permutations);
			
			int num = listOfNumbers[div];
			nextIndex = rem;
			
			// print out the number
			System.out.print(Integer.toString(num));
			
			// and remove the number from the list
			listOfNumbers = removeFromArray(listOfNumbers, div);
		}
		
		System.out.println();
	}
	
	private int[] removeFromArray(int[] oldList, int toRemove)
	{
		int[] ret = new int[oldList.length - 1];
		int nextIndex = 0;
		for(int i = 0; i < oldList.length; i++)
		{
			if(i == toRemove) continue;
			
			ret[nextIndex] = oldList[i];
			nextIndex++;
		}
		
		return ret;
	}
}
