package com.rmtrev.projecteuler.questions;

public class Q031 implements IQuestion
{
	private static final int TARGET = 200;

	@Override
	public void Run(String[] args) throws Exception
	{
		int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
		
		int result = getNumberOfSolutions(coins, 0, 0);
		
		System.out.println(Integer.toString(result));
	}

	/**
	 * This appears to be a variation of the knapsack problem, with the following differences:
	 * 
	 * <ul>
	 * <li>There can be an arbitrary number of each type of item</li>
	 * <li>The "knapsack" must be filled completely (no empty space)</li>
	 * <li>There is no weight property, just value</li>
	 * </ul>
	 * 
	 * <p>This function recursively finds every solution, starting with the smallest coin to ensure
	 * distinct combinations.</p>
	 * 
	 * @param coinList The list of coins to search through
	 * @param currentValue The current value of the "knapsack"
	 * @param startingIndex The starting index for testing coins in the list
	 * @return
	 */
	private int getNumberOfSolutions(int[] coinList, int currentValue, int startingIndex)
	{
		int ret = 0;
		for(int i = startingIndex; i < coinList.length; i++)
		{
			int tempValue = currentValue + coinList[i];
			
			if(tempValue == TARGET)
			{
				ret++;
			}
			else if(tempValue < TARGET)
			{
				ret += getNumberOfSolutions(coinList, tempValue, i);
			}
		}
		return ret;
	}
}
