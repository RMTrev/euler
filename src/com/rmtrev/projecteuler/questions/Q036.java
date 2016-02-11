package com.rmtrev.projecteuler.questions;

import java.util.ArrayList;

public class Q036 implements IQuestion
{
	public static final int LIMIT = 1000000;

	@Override
	public void Run(String[] args) throws Exception
	{
		int result = 0;
		
		for(int i = 1; i < LIMIT; i++)
		{
			if(isPalindromic(i, 10) && isPalindromic(i, 2))
			{
				result += i;
			}
		}
		
		System.out.println(Integer.toString(result));
	}

	/**
	 * This function determines if the given number is digit palindromic
	 * in the given base.
	 * 
	 * <p>
	 * Examples: isPalindromic(12321, 10), isPalindromic(0x37173, 16)
	 * </p>
	 * @param n
	 * @param base
	 * @return
	 * @throws Exception
	 */
	private boolean isPalindromic(int n, int base)throws Exception
	{
		int temp = n;
		ArrayList<Integer> digits = new ArrayList<Integer>();
		
		while(temp > 0)
		{
			int digit = temp % base;
			temp /= base;
			digits.add(digit);
		}
		
		for(int i = 0; i < digits.size() / 2; i++)
		{
			if(digits.get(i) != digits.get(digits.size() - (i + 1)))
			{
				return false;
			}
		}
		
		return true;
	}
}
