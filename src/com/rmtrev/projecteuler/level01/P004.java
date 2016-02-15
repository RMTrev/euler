package com.rmtrev.projecteuler.level01;

import com.rmtrev.projecteuler.interfaces.IProblem;

/**
 * <b>Largest palindrome product</b>
 * 
 * <p>A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.</p>
 * 
 * <p>Find the largest palindrome made from the product of two 3-digit numbers.</p>
 * 
 * @author rmt
 *
 */
public class P004 implements IProblem
{
	@Override
	public void Run(String[] args) throws Exception
	{
		int currentMax = 0;
		
		for(int i = 999; i >= 100; i--)
		{
			for(int j = 999; j >= 100; j--)
			{
				int n = i * j;
				if(isPalindromic(n) && n > currentMax)
				{
					currentMax = n;
				}
			}
		}
		
		System.out.println(Integer.toString(currentMax));
	}
	
	private boolean isPalindromic(int num)
	{
		String sNum = Integer.toString(num);
		int limit = sNum.length() / 2;
		
		for(int i = 0; i < limit; i++)
		{
			if(sNum.charAt(i) != sNum.charAt(sNum.length() - (i + 1)))
			{
				return false;
			}
		}
		
		return true;
	}

}
