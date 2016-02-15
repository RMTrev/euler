package com.rmtrev.projecteuler.level02;

import java.util.ArrayList;

import com.rmtrev.projecteuler.interfaces.IProblem;

public class P043 implements IProblem
{

	@Override
	public void Run(String[] args) throws Exception
	{
		ArrayList<String> nums = new ArrayList<String>();
		getSpecialPandigital(new int[]{0,1,2,3,4,5,6,7,8,9}, "", nums);
		
		long result = 0;
		for(int i = 0; i < nums.size(); i++)
		{
			result += Long.valueOf(nums.get(i), 10);
		}
		
		System.out.println(Long.toString(result));
	}

	private int getSpecialPandigital(int[] digitsRemaining, String num, ArrayList<String> nums)
	{
		int ret = 0;
		
		if(digitsRemaining.length == 0)
		{
			if(isSpecialPandigital(num))
			{
				nums.add(num);
				ret++;
			}
		}
		
		for(int i = 0; i < digitsRemaining.length; i++)
		{
			if(digitsRemaining[i] == 0 && num == "") continue;
			
			String tempNum = num + Integer.toString(digitsRemaining[i]);
			int[] newArray = new int[digitsRemaining.length - 1];
			int nextIndex = 0;
			for(int j = 0; j < digitsRemaining.length; j++)
			{
				if(i != j)
				{
					newArray[nextIndex] = digitsRemaining[j];
					nextIndex++;
				}
			}
			ret += getSpecialPandigital(newArray, tempNum, nums);
		}
		
		return ret;
	}
	
	private boolean isSpecialPandigital(String num)
	{
		if(Integer.valueOf(num.substring(1, 4), 10) % 2 != 0)
		{
			return false;
		}
		
		if(Integer.valueOf(num.substring(2, 5), 10) % 3 != 0)
		{
			return false;
		}
		
		if(Integer.valueOf(num.substring(3, 6), 10) % 5 != 0)
		{
			return false;
		}
		
		if(Integer.valueOf(num.substring(4, 7), 10) % 7 != 0)
		{
			return false;
		}
		
		if(Integer.valueOf(num.substring(5, 8), 10) % 11 != 0)
		{
			return false;
		}
		
		if(Integer.valueOf(num.substring(6, 9), 10) % 13 != 0)
		{
			return false;
		}
		
		if(Integer.valueOf(num.substring(7, 10), 10) % 17 != 0)
		{
			return false;
		}
		
		return true;
	}
}
