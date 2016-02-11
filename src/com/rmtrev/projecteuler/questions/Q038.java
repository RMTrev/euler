package com.rmtrev.projecteuler.questions;

public class Q038 implements IQuestion
{

	@Override
	public void Run(String[] args) throws Exception
	{
		long largestPandigital = 0;
		
		for(int i = 1; i < 9999; i++)
		{
			long pandigitalNum = pandigitalMultiple(i);
			if(pandigitalNum > largestPandigital)
			{
				largestPandigital = pandigitalNum;
			}
		}
		
		System.out.println(Long.toString(largestPandigital));
	}

	/**
	 * Returns the pandigital concatenated product of the given number,
	 * or -1 if such a number cannot be found.
	 * 
	 * <p>Example: 192</p>
	 * <ul>
	 * <li> n = 1 : 192 * 1 = 192</li>
	 * <li> n = 2 : 192 * 2 = 384</li>
	 * <li> n = 3 : 192 * 3 = 576</li>
	 * </ul>
	 * <p>Thus this returns 192384576</p>
	 * @param n
	 * @return
	 */
	private long pandigitalMultiple(int n)
	{
		int[] digitsTouched = new int[]{0,0,0,0,0,0,0,0,0};
		int digitsCrunched = 0;
		int mult = 0;
		String tempStr = "";
		
		while(digitsCrunched < 9)
		{
			mult++;
			int temp = mult * n;
			tempStr += Integer.toString(temp);
			
			while(temp > 0)
			{
				int digit = temp % 10;
				temp /= 10;
				digitsCrunched++;
				if(digit == 0) return -1;
				digitsTouched[digit - 1]++;
			}
		}
		
		if(mult < 2 || digitsCrunched > 9) return -1;
		
		// check the list of digits touched to make sure they were all touched exactly once
		for(int i = 0; i < digitsTouched.length; i++)
		{
			if(digitsTouched[i] != 1) return -1;
		}
		return Long.parseLong(tempStr);
	}
}
