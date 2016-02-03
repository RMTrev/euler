package com.rmtrev.projecteuler.questions;

import java.math.BigInteger;

public class Q016 implements IQuestion
{
	private static int POWER = 1000;
	
	@Override
	public void Run(String[] args) throws Exception
	{
		BigInteger theNumber = BigInteger.valueOf(2).pow(POWER);
		
		String strNumber = theNumber.toString();
		long result = 0;
		for(int i = 0; i < strNumber.length(); i++)
		{
			char c = strNumber.charAt(i);
			if(Character.isDigit(c))
			{
				result += Character.digit(c, 10);
			}
		}
		
		System.out.println(Long.toString(result));
	}
}
